package org.zzx.dksystem.dao;

import java.util.List;

import org.zzx.dksystem.domain.Attend;
import org.zzx.dksystem.domain.AttendType;
import org.zzx.dksystem.domain.Employee;

public interface AttendMapper {
	/*
	 * 根据id获取考勤记录
	 * @param id获取加载的Attend对象的id
	 * @return 指定id对应的Attend
	 * */
	Attend get(Integer id);
	
	/*
	 * 保存考勤记录
	 * @param attend要保存的Attend对象
	 * @return 新Attend对象的id
	 * */
	Integer save(Attend attend);
	
	/*
	 * 更新考勤记录
	 * @param attend 要保存的Attend对象
	 * @return 受影响的Attend的记录数
	 * */
	Integer update(Attend attend);

	/*
	 * 根据员工id查询该员工的考勤记录
	 * @param id 员工id
	 * @return 该员工的全部考勤记录
	 * */
	List<Attend> findByEmpId(Integer id);

	/*
	 * 根据员工、月份查询该员工的考勤记录
	 * @param emp员工
	 * @param mouth 月份，月份是形如2020-02格式的字符串
	 * @return 该员工、指定月份的全部考勤记录
	 * */
	List<Attend> findByEmpAndMonth(Employee emp, String month);
	
	/*
	 * 根据员工、日期查询该员工的打卡记录集合
	 * @param emp员工
	 * @param dutyDay日期
	 * @return 该员工某天的打卡记录集合
	 * */
	List<Attend> findByEmpAndDutyDay(Employee emp, String dutyDay);
	
	/*
	 * 根据员工、日期、上下班情况查询该员工的打卡记录集合
	 * @param emp员工
	 * @param dutyDay日期
	 * @param isCome是否上班
	 * @return 该员工某天上班或下班的打卡记录
	 * */
	Attend findByEmpAndDutyDayAndCome(Employee emp, String dutyDay, boolean isCome);
	
	/*
	 * 查看员工前三天的非正常打卡情况
	 * @param emp 员工
	 * @return 该员工前三天的非正常打卡情况
	 * */
	List<Attend> findByEmpUnAttend(Employee emp, AttendType type);

}
