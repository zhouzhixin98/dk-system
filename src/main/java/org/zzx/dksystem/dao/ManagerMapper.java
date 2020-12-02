package org.zzx.dksystem.dao;

import org.zzx.dksystem.domain.Employee;
import org.zzx.dksystem.domain.Manager;

import java.util.List;

public interface ManagerMapper {
    /*
    * �����û����������ѯ����
    * @param emp����ָ���û���������ľ���
    * @result ����ָ���û���������ľ���
    * */
    List<Manager> findByNameAndPass(Manager mgr);

    /*
     * �����û�����ѯ����
     * @param name ���������
     * @result ����ָ���û����ľ���
     * */
    Manager findByName(String name);
}
