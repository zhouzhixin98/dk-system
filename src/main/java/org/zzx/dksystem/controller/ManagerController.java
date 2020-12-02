package org.zzx.dksystem.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;

import org.zzx.dksystem.domain.Employee;
import org.zzx.dksystem.domain.AddEmployee;
import org.zzx.dksystem.service.MgrManager;

@Controller
public class ManagerController
{
	@Resource(name = "mgrManager")
	private MgrManager mgr;

	//查看部门出粮记录的处理方法
	@GetMapping("/viewDeptSal")
	public String  viewDeptSal(Model model,WebRequest webRequest)
		{
		//获取HttpSession的user属性
		var user = (String) webRequest.getAttribute(WebConstant.USER,WebRequest.SCOPE_SESSION);
		// 获取需要被当前经理所在部门的全部发薪记录
		model.addAttribute("sals",mgr.getSalaryByMgr(user));
		return "manager/viewSalary";
	}

	//查看员工考勤更改申请的方法
	@GetMapping("/viewApps")
	public String viewApps(Model model,WebRequest webRequest)
	{
		//获取HttpSession的user属性
		var user = (String) webRequest.getAttribute(WebConstant.USER,WebRequest.SCOPE_SESSION);
		//获取当前收到的所有员工的考勤更改申请
		model.addAttribute("apps",mgr.getAppByMgr(user));
		return "manager/viewApps";
	}

	//查看部门员工的处理方法
	@GetMapping("/viewEmps")
	public String viewEmps(Model model,WebRequest webRequest)
	{
		//获取HttpSession的user属性
		var user = (String) webRequest.getAttribute(WebConstant.USER,WebRequest.SCOPE_SESSION);
		//获取当前收到的所有员工的考勤更改申请
		model.addAttribute("emps",mgr.getEmpsByMgr(user));
		return "manager/viewEmp";
	}

	//进入添加员工的页面的处理方法
	@GetMapping("/addEmp")
	public String addEmp()
	{
		return "manager/addEmp";
	}

	//处理签核申请的处理方法
	@GetMapping("/checkApp")
	public String checkApp(Integer appId,String result,
						   Model model,WebRequest webRequest)
	{
		//获取HttpSession的user属性
		var mgrName = (String) webRequest.getAttribute(WebConstant.USER,
				WebRequest.SCOPE_SESSION);
		//通过申请
		if (result.equals("pass"))
		{
			mgr.check(appId,mgrName,true);
		}
		//拒绝申请
		else if (result.equals("deny"))
		{
			mgr.check(appId,mgrName,false);
		}
		else
		{
			throw new RuntimeException("参数丢失");
		}
		return "redirect:/viewApps";
	}

	//新增员工的处理方法
	@PostMapping("/processAdd")
	public String processAdd(@Validated(AddEmployee.class) Employee emp,
							 BindingResult result,RedirectAttributes attrs,
							 WebRequest webRequest)
	{
		if (result.getErrorCount() > 0)
		{
			return "manager/addEmp";
		}
		//获取HttpSession中的user属性
		var mgrName = (String)webRequest.getAttribute(WebConstant.USER,WebRequest.SCOPE_SESSION);
		//添加新用户
		mgr.addEmp(emp,mgrName);
		attrs.addFlashAttribute("tip","新增员工成功");
		return "manager/index";
	}

}
