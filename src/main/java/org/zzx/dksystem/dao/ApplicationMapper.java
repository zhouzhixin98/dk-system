package org.zzx.dksystem.dao;

import java.util.List;

import org.zzx.dksystem.domain.Application;
import org.zzx.dksystem.domain.Employee;

public interface ApplicationMapper {
	/*
	 * �����춯����
	 * @param application Ҫ�����Application����
	 * @return ��Application�����id
	 * */
	Integer save(Application application);
	
	/*
	 * �����춯����
	 * @param application Ҫ�����Application����
	 * @return ��Ӱ���Application�ļ�¼��
	 * */
	Integer update(Application application);
	
	/*
	 * ����id��ȡ�춯����
	 * @param id ��ȡ���ص�application�����id
	 * @return ָ��id��Ӧ��Application
	 * */
	Application get(Integer id);
	
	/*
	 * ����Ա����ѯδ������춯����
	 * @param emp ��Ҫ��ѯ��Ա��
	 * @return ��Ա����Ӧ��δ������춯����
	 * */
	List<Application> findByEmp(Employee emp);
}
