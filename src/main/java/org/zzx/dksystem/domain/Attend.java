package org.zzx.dksystem.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Attend implements Serializable{
	private static final long serialVersionUID = 48L;
	
	//标识属性
	private Integer id;
	
	//对应每天的考勤，包括考勤时间，考勤员工，是否上班及考勤类型等信息
	
	//考勤时间
	private String dutyDay;
	//打卡时间
	private Date punchTime;
	
	//本次打卡是否为上班打卡
	private boolean isCome;
	
	//考勤类型
	private AttendType type;
	
	//考勤员工
	private Employee employee;

	//无参构造器
	public Attend() {}

	//初始化所有成员变量的构造器
	public Attend(Integer id, String dutyDay, Date punchTime, boolean isCome, AttendType type, Employee employee) {
		super();
		this.id = id;
		this.dutyDay = dutyDay;
		this.punchTime = punchTime;
		this.isCome = isCome;
		this.type = type;
		this.employee = employee;
	}

	//id,dutyday,punchTime,isCome的getter setter方法
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDutyDay() {
		return dutyDay;
	}

	public void setDutyDay(String dutyDay) {
		this.dutyDay = dutyDay;
	}

	public Date getPunchTime() {
		return punchTime;
	}

	public void setPunchTime(Date punchTime) {
		this.punchTime = punchTime;
	}

	public boolean getIsCome() {
		return isCome;
	}

	public void setIsCome(boolean isCome) {
		this.isCome = isCome;
	}

	
	//tyoe的getter setter方法
	public AttendType getType() {
		return this.type;
	}

	public void setType(AttendType type) {
		this.type = type;
	}

	
	//employee的setter getter方法
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	// 根据employee、isCome、dutyDay来重写hashCode()方法
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dutyDay == null) ? 0 : dutyDay.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + (isCome ? 1231 : 1237);
		return result;
	}

	// 根据employee、isCome、dutyDay来重写equals()方法
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attend other = (Attend) obj;
		if (dutyDay == null) {
			if (other.dutyDay != null)
				return false;
		} else if (!dutyDay.equals(other.dutyDay))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (isCome != other.isCome)
			return false;
		return true;
	}
	
}
