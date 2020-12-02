package org.zzx.dksystem.dao;

import org.zzx.dksystem.domain.Employee;
import org.zzx.dksystem.domain.Payment;

import java.util.List;

public interface PaymentMapper {
    /*
     * 保存月工资
     * @param payment要保存的Payment对象
     * @result 新保存的Payment对象的id
     * */
    Integer save(Payment payment);

    /*
     * 根据员工id查询月结工资集合
     * @param id 对应员工的id
     * @result 该员工对应的月结工资集合
     * */
     List<Payment> findByEmpId(Integer id);

    /*
     * 根据员工查询月结工资
     * @param emp 要查询的对应员工
     * @result 该员工对应的月结工资集合
     * */
    List<Payment> findByEmp(Employee emp);

    /*
     * 根据员工和发工资月份来查询月结工资
     * @param emp领工资的员工
     * @param payMonth发工资月份
     * @result 指定员工、指定月份的工资
     * */
    Payment findByMonthAndEmp(String payMonth,Employee emp);
}
