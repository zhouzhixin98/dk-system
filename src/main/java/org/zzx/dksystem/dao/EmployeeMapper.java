package org.zzx.dksystem.dao;

import org.zzx.dksystem.domain.CheckBack;
import org.zzx.dksystem.domain.Employee;

import java.util.List;

public interface EmployeeMapper {
    /*
    * ����Ա��
    * @param emp Ҫ�����Employee����
    * @result �±����Employee�����id
    * */
    Integer save (Employee emp);

    /*
     * ��ѯ����Ա��
     * @result ����Ա������
     * */
    List<Employee> findAll();

    /*
     * �����û����������ѯԱ��
     * @param emp ����ָ���û����������Ա��
     * @result ����ָ���û����������Ա������
     * */
    List<Employee> findByNameAndPass(Employee emp);

    /*
     * �����û�����ѯԱ��
     * @param name Ա�����û���
     * @result �����û�����Ա��
     * */
    Employee findByName(String name);

    /*
     * ���ݾ���id��ѯԱ������
     * @param id �����id
     * @result ָ�������µ�Ա������
     * */
    List<Employee> findByMgrId(Integer id);


}
