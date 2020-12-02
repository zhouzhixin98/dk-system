package org.zzx.dksystem.dao;

import org.zzx.dksystem.domain.AttendType;

import java.util.List;

public interface AttendTypeMapper {
    /*
    * ����id��ȡ��������
    * @param id ��ȡ���ص�AttendType�����id
    * @result ָ��id��Ӧ��AttendType
    * */
    AttendType get(Integer id);

    /*
     * ��ѯȫ����������
     * @result ���еĿ�������
     * */
    List<AttendType> findAll();
}
