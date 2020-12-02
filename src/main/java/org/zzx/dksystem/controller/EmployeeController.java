package org.zzx.dksystem.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zzx.dksystem.domain.Login;
import org.zzx.dksystem.domain.Manager;
import org.zzx.dksystem.service.EmpManager;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class EmployeeController {

    @Resource(name = "empManager")
    private EmpManager mgr;

    // 定义处理登录系统的的处理方法
    @PostMapping("/processLogin")
    public String processLogin(@Validated(Login.class) Manager manager,
                               BindingResult bindingResult, String vercode,
                               RedirectAttributes attrs, WebRequest webRequest)
    {
        if (bindingResult.getErrorCount() > 0)
        {
            return "login";
        }
        // 获取HttpSession中的rand属性
        var ver2 = (String) webRequest.getAttribute("rand",
                WebRequest.SCOPE_SESSION);
        if (vercode.equalsIgnoreCase(ver2))
        {
            // 调用业务逻辑方法来处理登录请求
            var result = mgr.validLogin(manager);
            // 登录结果为普通员工
            if (result == EmpManager.LOGIN_EMP)
            {
                webRequest.setAttribute(WebConstant.USER,
                        manager.getName(), WebRequest.SCOPE_SESSION);
                webRequest.setAttribute(WebConstant.LEVEL,
                        WebConstant.EMP_LEVEL, WebRequest.SCOPE_SESSION);
                attrs.addFlashAttribute("tip", "您已经成功登录系统");
                return "employee/index";
            }
            // 登录结果为经理
            else if (result == EmpManager.LOGIN_MGR)
            {
                webRequest.setAttribute(WebConstant.USER,
                        manager.getName(), WebRequest.SCOPE_SESSION);
                webRequest.setAttribute(WebConstant.LEVEL,
                        WebConstant.MGR_LEVEL, WebRequest.SCOPE_SESSION);
                attrs.addFlashAttribute("tip", "您已经成功登录系统");
                return "manager/index";
            }
            // 用户名和密码不匹配
            else
            {
                attrs.addFlashAttribute("error", "用户名或密码错误。");
                return "redirect:login";
            }
        }
        // 验证码不匹配
        attrs.addFlashAttribute("error", "验证码不匹配,请重新输入");
        return "redirect:login";
    }

    //定义处理登出请求的处理方法
    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        //使session失效
        return "main";
    }

    //进入打卡的处理方法
    @GetMapping("/{category}Punch")
    public String punch(@PathVariable String category,
                        Model model,WebRequest webRequest)
    {
        //获取HttpSession中的user属性
        var user = (String) webRequest.getAttribute(WebConstant.USER,WebRequest.SCOPE_SESSION);
        var sdf = new SimpleDateFormat("yyyy-MM-dd");
        //格式化当前时间
        var dutyDay = sdf.format(new Date());
        //调用业务逻辑方法处理用户请求
        var result = mgr.validPunch(user,dutyDay);
        model.addAttribute("punchIsValid" , result);
        return StringUtils.uncapitalize(category) + "/punch";
    }

    //上班打卡的处理方法
    @GetMapping("/{category}Come")
    public String come(@PathVariable String category,
    Model model,WebRequest webRequest)
    {
        return process(category,true,model,webRequest);
    }
    //下班打卡的处理方法
    @GetMapping("/{category}Leave")
    public String leave(@PathVariable String category,
                       Model model,WebRequest webRequest)
    {
        return process(category,false,model,webRequest);
    }

    private String process(String category,boolean isCome,Model model,WebRequest webRequest)
    {
        //获取httpSession中的user属性
        var user = (String) webRequest.getAttribute(WebConstant.USER,WebRequest.SCOPE_SESSION);
        var dutyDay = new java.sql.Date(
                System.currentTimeMillis()).toString();
        //调用业务逻辑方法处理打卡请求
        var result = mgr.punch(user,dutyDay,isCome);
        switch (result)
        {
            case EmpManager.PUNCH_FAIL:
            model.addAttribute("tip","打卡失败");
            break;
            case EmpManager.PUNCHED:
            model.addAttribute("tip","您已经打卡过了，请勿重复打卡");
            break;
            case EmpManager.PUNCH_SUCC:
            model.addAttribute("tip","打卡成功");
            break;
        }
        return StringUtils.uncapitalize(category) + "/index";
    }

    //查看自己非正常出勤的处理方法
    @GetMapping("/viewUnAttend")
    public String viewUnAttend(Model model,WebRequest webRequest)
    {
        //获取HttpSession中的USER属性
        var user = (String) webRequest.getAttribute(WebConstant.USER,WebRequest.SCOPE_SESSION);
        //调用方法查看最近三天的打卡记录
        var result = mgr.unAttend(user);
        model.addAttribute("unAttends" ,result);
        return "employee/viewUnAttend";
    }

    //进入异动申请表单的处理方法
    @GetMapping("/appChange-{attId}")
    public String appChange(@PathVariable String attId,
                            Model model,WebRequest webRequest)
    {
         model.addAttribute("attId",attId);
         model.addAttribute("types",mgr.getAllType());
         return "employee/appChange";
    }

    //获取异常考勤表单的处理方法
    @PostMapping("/processApp")
    public String processApp(Integer attId,Integer typeId,String reason, Model model)
    {
        //处理申请
        var result = mgr.addApplication(attId,typeId,reason);
        //如果申请成功
        if (result)
        {
            model.addAttribute("tip","您已成功提交申请，请等待经理审阅");
        }
        else
        {
            model.addAttribute("tip","申请失败，请注意不要重复提交申请");
        }
        return "employee/index";
    }

    //查看工资的处理方法
    @GetMapping("/view{category}Salary")
    public String viewSalary(@PathVariable String category,
                             Model model, WebRequest webRequest)
    {
        //获取HttpSession中的user属性
        var user = (String) webRequest.getAttribute(WebConstant.USER,WebRequest.SCOPE_SESSION);
        var salarys = mgr.empSalary(user);
        model.addAttribute("salarys",salarys);
        return StringUtils.uncapitalize(category) + "/viewSalary";
    }

    //查看异动申请批复结果的处理方法
    @GetMapping("/viewAttendResult")
    public String viewAttendResult(Model model,WebRequest webRequest)
    {
        //获取HttpSession中的USER属性
        var user = (String) webRequest.getAttribute(WebConstant.USER,WebRequest.SCOPE_SESSION);
        var apps = mgr.findCheckBack(user);
        model.addAttribute("apps",apps);
        return "employee/viewAttendResult";
    }
}
