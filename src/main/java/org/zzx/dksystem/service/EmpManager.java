package org.zzx.dksystem.service;

import org.zzx.dksystem.domain.AttendType;
import org.zzx.dksystem.domain.CheckBack;
import org.zzx.dksystem.domain.Employee;
import org.zzx.dksystem.domain.Manager;
import org.zzx.dksystem.vo.AttendBean;
import org.zzx.dksystem.vo.CheckBean;
import org.zzx.dksystem.vo.PaymentBean;

import java.util.Date;
import java.util.List;

public interface EmpManager {
    /*实现功能
    * 员工：自动完成员工每天上下班的考勤记录，包括迟到、早退、旷工。
    * 员工可以查看本人最近3天的考勤情况。
    * 若考勤记录与实际不符，可提出申请修改，若经理批准，则申请自动生效，系统将考勤系统修改为实际情况。
    * 员工可以查看自己的工资记录
    */

    //登录失败
    int LOGIN_FAIL = 0;
    //以员工身份登录
    int LOGIN_EMP = 1;
    //以经理身份登录
    int LOGIN_MGR = 2;

    // 不能打卡
    int NO_PUNCH = 0;
    // 只能上班打卡
    int COME_PUNCH = 1;
    // 只能下班打卡
    int LEAVE_PUNCH = 2;
    // 既可以上班，也可以下班打卡
    int BOTH_PUNCH = 3;

    // 打卡失败
    int PUNCH_FAIL = 0;
    // 已经打卡
    int PUNCHED = 1;
    // 打卡成功
    int PUNCH_SUCC = 2;

    // 以上午11点为上午时间
    int AM_LIMIT = 11;
    // 以上午9点之前为正常上班
    int COME_LIMIT = 9;
    // 以上午9~11点之间算迟到
    int LATE_LIMIT = 11;
    // 以下午18点之后算正常下班
    int LEAVE_LIMIT = 18;
    // 以下午16~18点之间算早退
    int EARLY_LIMIT = 16;

    /*
    * 以经理身份来验证登录
    * @param 登录的经理身份
    * @return 登录身份的确认，0-失败、1-员工、2-经理
    * */
    int validLogin(Manager mgr);

    /*
    * 自动打卡
    * 周一到周五，早上7.00自动为每个员工插入旷工记录
    * */
    void autoPunch();

    /*
    * 自动结算工资，每月1号结算上个月的工资
    * */
    void autoPay();

    /*
    * 验证某个员工是否可以打卡
    * @param user 员工用户名
    * @param dutyDay打卡日期
    * @return 可打卡的类型
    * */
    int validPunch(String user, String dutyDay);

    /*
     * 打卡
     * @param user 员工用户名
     * @param dutyDay打卡日期
     * @param isCome 员工是否打卡上班
     * @return 打卡结果
     * */
    int punch(String user,String dutyDay,boolean isCome);

    /*
    * 根据员工浏览自己的工资
    * @param empName 员工用户名
    * @return 该员工的工资列表
    * */
    List<PaymentBean> empSalary(String empName);

    /*
    * 员工查看自己的最近三天的打卡
    * @param empName 员工用户名
    * @return 员工最近三天的非正常打卡
    * */
    List<AttendBean> unAttend(String empName);

    /*
    * 返回所有出勤类型
    * @return 全部的出勤类型
    * */
    List<AttendType> getAllType();

    /*
    * 添加申请
    * @param attId 申请的出勤id
    * @param typeId 申请的类型id
    * @param reason 申请的理由
    * @return 添加的结果
    * */
    boolean addApplication(int attId,int typeId,String reason);

    /*
    * 查询自己的申请批复结果
    * @param empName 对应申请的员工的名字
    * @return 查询的结果集
    * */
    List<CheckBean> findCheckBack(String empName);

}
