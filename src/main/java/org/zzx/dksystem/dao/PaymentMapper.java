package org.zzx.dksystem.dao;

import org.zzx.dksystem.domain.Employee;
import org.zzx.dksystem.domain.Payment;

import java.util.List;

public interface PaymentMapper {
    /*
     * �����¹���
     * @param paymentҪ�����Payment����
     * @result �±����Payment�����id
     * */
    Integer save(Payment payment);

    /*
     * ����Ա��id��ѯ�½Ṥ�ʼ���
     * @param id ��ӦԱ����id
     * @result ��Ա����Ӧ���½Ṥ�ʼ���
     * */
     List<Payment> findByEmpId(Integer id);

    /*
     * ����Ա����ѯ�½Ṥ��
     * @param emp Ҫ��ѯ�Ķ�ӦԱ��
     * @result ��Ա����Ӧ���½Ṥ�ʼ���
     * */
    List<Payment> findByEmp(Employee emp);

    /*
     * ����Ա���ͷ������·�����ѯ�½Ṥ��
     * @param emp�칤�ʵ�Ա��
     * @param payMonth�������·�
     * @result ָ��Ա����ָ���·ݵĹ���
     * */
    Payment findByMonthAndEmp(String payMonth,Employee emp);
}
