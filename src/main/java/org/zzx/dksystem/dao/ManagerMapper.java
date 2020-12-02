package org.zzx.dksystem.dao;

import org.zzx.dksystem.domain.Employee;
import org.zzx.dksystem.domain.Manager;

import java.util.List;

public interface ManagerMapper {
    /*
    * 根据用户名和密码查询经理
    * @param emp包含指定用户名、密码的经理
    * @result 符合指定用户名和密码的经理
    * */
    List<Manager> findByNameAndPass(Manager mgr);

    /*
     * 根据用户名查询经理
     * @param name 经理的名字
     * @result 符合指定用户名的经理
     * */
    Manager findByName(String name);
}
