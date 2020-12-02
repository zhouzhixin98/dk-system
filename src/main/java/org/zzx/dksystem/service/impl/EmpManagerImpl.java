package org.zzx.dksystem.service.impl;

import org.zzx.dksystem.dao.*;
import org.zzx.dksystem.domain.*;
import org.zzx.dksystem.service.EmpManager;
import org.zzx.dksystem.vo.AppBean;
import org.zzx.dksystem.vo.AttendBean;
import org.zzx.dksystem.vo.CheckBean;
import org.zzx.dksystem.vo.PaymentBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EmpManagerImpl implements EmpManager {

    private ApplicationMapper appMapper;
    private AttendMapper attendMapper;
    private AttendTypeMapper typeMapper;
    private CheckBackMapper checkMapper;
    private EmployeeMapper empMapper;
    private ManagerMapper mgrMapper;
    private PaymentMapper payMapper;

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
     * 以经理身份来验证登录
     * @param 登录的经理身份
     * @return 登录身份的确认，0-失败、1-员工、2-经理
     * */
    @Override
    public int validLogin(Manager mgr) {
        //如果是经理身份 以经理身份登录
        if (mgrMapper.findByNameAndPass(mgr).size() >= 1)
        {
            return LOGIN_MGR;
        }
        //如果是普通员工，以普通员工登录
        if (empMapper.findByNameAndPass(mgr).size() >= 1)
        {
            return LOGIN_EMP;
        }
        else
        {
            return LOGIN_FAIL;
        }
    }

    /*
     * 自动打卡
     * 周一到周五，早上7.00自动为每个员工插入旷工记录
     * */
    @Override
    public void autoPunch() {
        System.out.println("自动插入旷工记录");
        var emps = empMapper.findAll();
        //获取当前时间
        var dutyDay = new java.sql.Date(System.currentTimeMillis()).toString();
        for (var e : emps)
        {
            //获取旷工对应的考勤类型
            var atype = typeMapper.get(6);
            var a = new Attend();
            a.setDutyDay(dutyDay);
            a.setType(atype);
            //如果当前时间是早上，则对应上班打卡
            if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY ) < AM_LIMIT)
            {
                //上班打卡
                a.setIsCome(true);
            }
            else
            {
                //下班打卡
                a.setIsCome(false);
            }
            a.setEmployee(e);
            attendMapper.save(a);
        }
    }

    /*
     * 自动结算工资，每月1号结算上个月的工资
     * */
    @Override
    public void autoPay() {
        System.out.println("自动插入工资结算");
        var emps = empMapper.findAll();
        //获取上个月时间
        var c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH,-15);
        var sdf = new SimpleDateFormat("yyyy-MM");
        var payMonth = sdf.format(c.getTime());
        //为每个员工计算上个月的工资
        for (var e : emps){
            var pay = new Payment();
            //获取该员工的工资
            var amout = e.getSalary();
            //获取该员工上个月的考勤记录
            var attends = attendMapper.findByEmpAndMonth(e,payMonth);
            //用工资累积其考勤记录的工资
            for (var a : attends){
                amout += a.getType().getAmerce();
            }
            //添加工资结算
            pay.setPayMonth(payMonth);
            pay.setEmpolyee(e);
            pay.setAmout(amout);
            payMapper.save(pay);
        }
    }

    /*
     * 验证某个员工是否可以打卡
     * @param user 员工用户名
     * @param dutyDay打卡日期
     * @return 可打卡的类型
     * */
    @Override
    public int validPunch(String user, String dutyDay) {
        //不能查到对应用户，返回无法打卡
        var emp = empMapper.findByName(user);
        if (emp == null)
        {
            return NO_PUNCH;
        }
        //找到员工当前的考勤记录
        var attends = attendMapper.findByEmpAndDutyDay(emp,dutyDay);
        //系统没有为用户在当天插入空打卡记录，无法打卡
        if (attends == null || attends.size() <= 0)
        {
            return NO_PUNCH;
        }
        //开始上班打卡
        else  if (attends.size() == 1 && attends.get(0).getIsCome() && attends.get(0).getPunchTime() == null)
        {
            return COME_PUNCH;
        }
        else if (attends.size()==1 && attends.get(0).getPunchTime() == null)
        {
            return LEAVE_PUNCH;
        }
        else if (attends.size() == 2)
        {
            //可以上班，下班打卡
            if (attends.get(0).getPunchTime() == null
            && attends.get(1).getPunchTime() == null)
            {
                return BOTH_PUNCH;
            }
            //可以下班打卡
            else if (attends.get(1).getPunchTime() == null)
            {
                return LEAVE_PUNCH;
            }
            else
            {
                return NO_PUNCH;
            }
        }
        return NO_PUNCH;
    }

    /*
     * 打卡
     * @param user 员工用户名
     * @param dutyDay打卡日期
     * @param isCome 员工是否打卡上班
     * @return 打卡结果
     * */
    @Override
    public int punch(String user, String dutyDay, boolean isCome) {
        var emp = empMapper.findByName(user);
        if (emp == null)
        {
            return PUNCH_FAIL;
        }
        //找到员工本次打卡对应的考勤记录
        var attend = attendMapper.findByEmpAndDutyDayAndCome(emp,dutyDay,isCome);
        if (attend == null) {
            return PUNCH_FAIL;
        }
        //已经打卡
        if (attend.getPunchTime() != null)
        {
            return PUNCHED;
        }
        System.out.println("-------------打卡-------------");
        //获取打卡时间
        var punchHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        attend.setPunchTime(new Date());
        //上班打卡
        if (isCome)
        {
            //9.00之前算正常
            if (punchHour < COME_LIMIT)
            {
                attend.setType(typeMapper.get(1));
            }
            //9.00-11.00算迟到
            else if (punchHour < LATE_LIMIT)
            {
                attend.setType(typeMapper.get(4));
            }
            //11.00后视为旷工，无需做修改
        }
        //下班打卡
        else
        {
            //18.00后属于正常下班
            if (punchHour > LEAVE_LIMIT)
            {
                attend.setType(typeMapper.get(1));
            }
            //16.00-18.00算早退
            if (punchHour > EARLY_LIMIT) {
                attend.setType(typeMapper.get(5));
            }
        }
        attendMapper.update(attend);
        return PUNCH_SUCC;
    }

    /*
     * 根据员工浏览自己的工资
     * @param empName 员工用户名
     * @return 该员工的工资列表
     * */
    @Override
    public List<PaymentBean> empSalary(String empName) {
        var emp = empMapper.findByName(empName);
        //获取该员工的全部工资列表
        var pay = payMapper.findByEmp(emp);
        var result = new ArrayList<PaymentBean>();
        //封装PaymentBean集合
        for (var p : pay)
        {
            result.add(new PaymentBean(p.getPayMonth(),p.getAmout()));
        }
        return result;
    }

    /*
     * 员工查看自己的最近三天的打卡
     * @param empName 员工用户名
     * @return 员工最近三天的非正常打卡
     * */
    @Override
    public List<AttendBean> unAttend(String empName) {
        var emp = empMapper.findByName(empName);
        //找出正常上班的考勤类型
        var type = typeMapper.get(1);
        //找出非正常的上班考勤类型
        var attends = attendMapper.findByEmpUnAttend(emp,type);
        var result = new ArrayList<AttendBean>();
        //封装AttendBean集合
        for (var attend : attends)
        {
            result.add(new AttendBean(attend.getId(),attend.getDutyDay(),
                    attend.getType().getName(),attend.getPunchTime()));
        }
        return result;
    }

    /*
     * 返回所有出勤类型
     * @return 全部的出勤类型
     * */
    @Override
    public List<AttendType> getAllType() {
        return typeMapper.findAll();
    }

    /*
     * 添加申请
     * @param attId 申请的出勤id
     * @param typeId 申请的类型id
     * @param reason 申请的理由
     * @return 添加的结果
     * */
    @Override
    public boolean addApplication(int attId, int typeId, String reason) {
        //创建一个申请
        var app = new Application();
        //获取申请需要改变的考勤记录
        var att = attendMapper.get(attId);
        var type = typeMapper.get(typeId);
        app.setAttend(att);
        app.setType(type);
        if (reason == null)
        {
            app.setReason(reason);
        }
        appMapper.save(app);
        return true;
    }

    /*
     * 查询自己的申请批复结果
     * @param empName 对应申请的员工的名字
     * @return 查询的结果集
     * */
    @Override
    public List<CheckBean> findCheckBack(String empName)
    {
        ArrayList<CheckBean> result = new ArrayList<CheckBean>();
        var emp = empMapper.findByName(empName);
       //找到该员工的所有申请
        var apps = appMapper.findByEmp(emp);
        //遍历该员工的申请集合
        for (var app : apps)
        {
            //只封装已处理的申请
            if (app.isResult())
            {
                Attend attend = app.getAttend();
                result.add(new CheckBean(app.getId(),attend.getDutyDay(),
                        attend.getType().getName(),attend.getPunchTime(),app.isResult()));
            }
        }
        return result;
    }
}
