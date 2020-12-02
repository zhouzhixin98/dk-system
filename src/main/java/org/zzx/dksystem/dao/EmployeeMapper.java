package org.zzx.dksystem.dao;

import org.zzx.dksystem.domain.CheckBack;
import org.zzx.dksystem.domain.Employee;

import java.util.List;

public interface EmployeeMapper {
    /*
    * 保存员工
    * @param emp 要保存的Employee对象
    * @result 新保存的Employee对象的id
    * */
    Integer save (Employee emp);

    /*
     * 查询所有员工
     * @result 所有员工集合
     * */
    List<Employee> findAll();

    /*
     * 根据用户名和密码查询员工
     * @param emp 包含指定用户名，密码的员工
     * @result 符合指定用户名和密码的员工集合
     * */
    List<Employee> findByNameAndPass(Employee emp);

    /*
     * 根据用户名查询员工
     * @param name 员工的用户名
     * @result 符合用户名的员工
     * */
    Employee findByName(String name);

    /*
     * 根据经理id查询员工集合
     * @param id 经理的id
     * @result 指定经理下的员工集合
     * */
    List<Employee> findByMgrId(Integer id);


}
