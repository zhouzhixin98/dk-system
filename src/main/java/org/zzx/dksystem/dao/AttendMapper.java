package org.zzx.dksystem.dao;

import java.util.List;

import org.zzx.dksystem.domain.Attend;
import org.zzx.dksystem.domain.AttendType;
import org.zzx.dksystem.domain.Employee;

public interface AttendMapper {
	/*
	 * ����id��ȡ���ڼ�¼
	 * @param id��ȡ���ص�Attend�����id
	 * @return ָ��id��Ӧ��Attend
	 * */
	Attend get(Integer id);
	
	/*
	 * ���濼�ڼ�¼
	 * @param attendҪ�����Attend����
	 * @return ��Attend�����id
	 * */
	Integer save(Attend attend);
	
	/*
	 * ���¿��ڼ�¼
	 * @param attend Ҫ�����Attend����
	 * @return ��Ӱ���Attend�ļ�¼��
	 * */
	Integer update(Attend attend);

	/*
	 * ����Ա��id��ѯ��Ա���Ŀ��ڼ�¼
	 * @param id Ա��id
	 * @return ��Ա����ȫ�����ڼ�¼
	 * */
	List<Attend> findByEmpId(Integer id);

	/*
	 * ����Ա�����·ݲ�ѯ��Ա���Ŀ��ڼ�¼
	 * @param empԱ��
	 * @param mouth �·ݣ��·�������2020-02��ʽ���ַ���
	 * @return ��Ա����ָ���·ݵ�ȫ�����ڼ�¼
	 * */
	List<Attend> findByEmpAndMonth(Employee emp, String month);
	
	/*
	 * ����Ա�������ڲ�ѯ��Ա���Ĵ򿨼�¼����
	 * @param empԱ��
	 * @param dutyDay����
	 * @return ��Ա��ĳ��Ĵ򿨼�¼����
	 * */
	List<Attend> findByEmpAndDutyDay(Employee emp, String dutyDay);
	
	/*
	 * ����Ա�������ڡ����°������ѯ��Ա���Ĵ򿨼�¼����
	 * @param empԱ��
	 * @param dutyDay����
	 * @param isCome�Ƿ��ϰ�
	 * @return ��Ա��ĳ���ϰ���°�Ĵ򿨼�¼
	 * */
	Attend findByEmpAndDutyDayAndCome(Employee emp, String dutyDay, boolean isCome);
	
	/*
	 * �鿴Ա��ǰ����ķ����������
	 * @param emp Ա��
	 * @return ��Ա��ǰ����ķ����������
	 * */
	List<Attend> findByEmpUnAttend(Employee emp, AttendType type);

}
