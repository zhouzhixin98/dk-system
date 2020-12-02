package org.zzx.dksystem.service;

import org.zzx.dksystem.domain.Employee;
import org.zzx.dksystem.domain.Manager;
import org.zzx.dksystem.vo.AppBean;
import org.zzx.dksystem.vo.EmpBean;
import org.zzx.dksystem.vo.SalaryBean;

import java.util.List;

public interface MgrManager {

    /*
    * 经理：包括普通员工的功能。
    * 签核员工申请，对新增员工的查看和查看员工上月工资等。
    * 经理无法对考勤修改提出申请
    * */

    /*
    * 新增员工
    * @param emp 新增的员工
    * @param mgr 员工所属的经理的name
    * */
    void addEmp(Employee emp , String mgr);

    /*
    * 根据经理返回所有的部门上个月的工资
    * @param mgr 新增员工的用户名
    * @return 部门上个月的工资
    * */
    List<SalaryBean> getSalaryByMgr(String mgr);

    /*
    * 根据经理返回该部门的员工
    * @param mgr 经理名
    * @return 经理的全部下属
    * */
    List<EmpBean> getEmpsByMgr(String mgr);

    /*
    * 根据经理返回该部门的没有批复的申请
    * @parame mgr 经理名
    * @return 该部门的全部申请
    * */
    List<AppBean> getAppByMgr(String mgr);

    /*
    * 处理申请
    * @param appId 申请id
    * @param mgrName 经理名字
    * @param result 是否通过
    * */
    void check(Integer appId,String mgrName,boolean result);
}
