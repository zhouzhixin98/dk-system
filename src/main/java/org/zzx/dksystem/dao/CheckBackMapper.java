package org.zzx.dksystem.dao;

import org.zzx.dksystem.domain.CheckBack;

import java.util.List;

public interface CheckBackMapper {
    /*
    * ��������
    * @param ��������
    * @result ������������
    * */
    Integer save(CheckBack checkBack);

    /*
     * ��ѯָ�������������
     * @param id ָ�������id
     * @result ָ�������������
     * */
    List<CheckBack> findByMgrId(Integer id);

    /*
     * ����Ա����ѯ������������
     * @param empName
     * @result ����������������
     * */
    List<CheckBack> findAppED();
}
