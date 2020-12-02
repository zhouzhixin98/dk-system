package org.zzx.dksystem.service.impl;

import org.zzx.dksystem.dao.*;
import org.zzx.dksystem.domain.*;
import org.zzx.dksystem.expection.authorityException;
import org.zzx.dksystem.service.MgrManager;
import org.zzx.dksystem.vo.AppBean;
import org.zzx.dksystem.vo.EmpBean;
import org.zzx.dksystem.vo.SalaryBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.SimpleFormatter;

public class MgrMapperImpl implements MgrManager {

    private ApplicationMapper appMapper;
    private AttendMapper attendMapper;
    private AttendTypeMapper typeMapper;
    private EmployeeMapper empMapper;
    private ManagerMapper mgrMapper;
    private PaymentMapper payMapper;
    private CheckBackMapper checkMapper;

    //Mapper组件的setter方法
    public void setAppMapper(ApplicationMapper appMapper) {
        this.appMapper = appMapper;
    }

    public void setAttendMapper(AttendMapper attendMapper) {
        this.attendMapper = attendMapper;
    }

    public void setTypeMapper(AttendTypeMapper typeMapper) {
        this.typeMapper = typeMapper;
    }

    public void setEmpMapper(EmployeeMapper empMapper) {
        this.empMapper = empMapper;
    }

    public void setMgrMapper(ManagerMapper mgrMapper) {
        this.mgrMapper = mgrMapper;
    }

    public void setPayMapper(PaymentMapper payMapper) {
        this.payMapper = payMapper;
    }

    public void setCheckMapper(CheckBackMapper checkMapper) {
        this.checkMapper = checkMapper;
    }

    /*
     * 新增员工
     * @param emp 新增的员工
     * @param mgr 员工所属的经理
     * */
    @Override
    public void addEmp(Employee emp, String mgr) {
        var manager = mgrMapper.findByName(mgr);
        if (manager == null)
        {
            throw new authorityException("对不起，您不是经理，没有权限进行操作。");
        }
        emp.setManager(manager);
        empMapper.save(emp);
    }

    /*
     * 根据经理返回所有的部门上个月的工资
     * @param mgr 经理的用户名
     * @return 部门上个月的工资
     * */
    @Override
    public List<SalaryBean> getSalaryByMgr(String mgr) {
        var manager = mgrMapper.findByName(mgr);
        if (manager == null)
        {
            throw new authorityException("对不起，您不是经理，没有权限进行操作。");
        }
        //查询该经理对应的全部员工
        var emps = manager.getEmployees();
        //部门还没有员工
        if (emps == null)
        {
            throw new authorityException("对不起，您的部门还没有员工，没有权限进行操作");
        }
        //获取上个月的时间
        var c = Calendar.getInstance();
        c.add(Calendar.MONTH,-1);
        var sdf = new SimpleDateFormat("yyyy-MM");
        var payMonth = sdf.format(c.getTime());
        var result = new ArrayList<SalaryBean>();
        //遍历本部门员工
        for (var emp : emps)
        {
            var p = payMapper.findByMonthAndEmp(payMonth,emp);
            System.out.println("----------------" + p);
            if (p != null)
            {
                //封装SalaryBean集合
                result.add(new SalaryBean(emp.getName(),p.getAmout()));
            }
        }
        return result;
    }

    /*
     * 根据经理返回该部门的员工
     * @param mgr 经理名
     * @return 经理的全部下属
     * */
    public List<EmpBean> getEmpsByMgr(String mgr)
    {
        var manager = mgrMapper.findByName(mgr);
        if (manager == null)
        {
            throw new authorityException("对不起，您不是经理，没有权限进行操作。");
        }
        //查询该经理对应的全部员工
        var emps = manager.getEmployees();
        //部门还没有员工
        if (emps == null)
        {
            throw new authorityException("对不起，您的部门还没有员工");
        }
        //有员工 返回他的全部下属
        var result = new ArrayList<EmpBean>();
        for (var emp : emps)
        {
            result.add(new EmpBean(emp.getName(), emp.getPass(),emp.getSalary()));
        }
        return result;
    }

    /*
     * 根据经理返回该部门的没有批复的申请
     * @parame mgr 经理名
     * @return 该部门的全部申请
     * */
    @Override
    public List<AppBean> getAppByMgr(String mgr) {
        var manager = mgrMapper.findByName(mgr);
        var result = new ArrayList<AppBean>();
        if (manager == null)
        {
            throw new authorityException("对不起，您不是经理，没有权限进行操作。");
        }
        //查询该经理对应的全部员工
        var emps = manager.getEmployees();
        //部门还没有员工
        if (emps == null)
        {
            throw new authorityException("对不起，您的部门还没有员工，没有权限进行操作");
        }
        //遍历该部门的员工
        for (var emp : emps)
        {
            //查看该员工的所有申请
            var apps = appMapper.findByEmp(emp);
            //遍历该员工的所有申请
            for (var app : apps )
            {
                //只封装未处理的申请
                if (!app.isResult())
                {
                    Attend attend = app.getAttend();
                    result.add(new AppBean(app.getId(),emp.getName(),attend.getType().getName(),
                            app.getType().getName(),app.getReason()));
                }
            }
        }
        return result;
    }

    /*
     * 处理申请
     * @param appId 申请id
     * @param mgrName 经理名字
     * @param result 是否通过
     * */
    @Override
    public void check(Integer appId, String mgrName, boolean result) {

        var app = appMapper.get(appId);
        var check = new CheckBack();
        check.setApp(app);
        var mgr = mgrMapper.findByName(mgrName);
        if (mgr == null)
        {
            throw new authorityException("对不起，您不是经理，没有权限进行操作。");
        }
        //该申请是哪个经理签署的
        check.setManager(mgr);
        //同意通过申请
        if (result)
        {
            //设置通过申请
            check.setResult(true);
            //修改申请已经批复
            app.setResult(true);
            appMapper.update(app);
            //修改出勤类型
            var attend = app.getAttend();
            attend.setType(app.getType());
            attendMapper.update(attend);
        }
        //没有通过申请
        else
        {
            check.setResult(false);
            app.setResult(true);
            appMapper.update(app);
        }
        //保存申请批复
        checkMapper.save(check);
    }


}
