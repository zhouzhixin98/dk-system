package org.zzx.dksystem.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Attend implements Serializable{
	private static final long serialVersionUID = 48L;
	
	//��ʶ����
	private Integer id;
	
	//��Ӧÿ��Ŀ��ڣ���������ʱ�䣬����Ա�����Ƿ��ϰ༰�������͵���Ϣ
	
	//����ʱ��
	private String dutyDay;
	//��ʱ��
	private Date punchTime;
	
	//���δ��Ƿ�Ϊ�ϰ��
	private boolean isCome;
	
	//��������
	private AttendType type;
	
	//����Ա��
	private Employee employee;

	//�޲ι�����
	public Attend() {}

	//��ʼ�����г�Ա�����Ĺ�����
	public Attend(Integer id, String dutyDay, Date punchTime, boolean isCome, AttendType type, Employee employee) {
		super();
		this.id = id;
		this.dutyDay = dutyDay;
		this.punchTime = punchTime;
		this.isCome = isCome;
		this.type = type;
		this.employee = employee;
	}

	//id,dutyday,punchTime,isCome��getter setter����
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

	
	//tyoe��getter setter����
	public AttendType getType() {
		return this.type;
	}

	public void setType(AttendType type) {
		this.type = type;
	}

	
	//employee��setter getter����
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	// ����employee��isCome��dutyDay����дhashCode()����
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dutyDay == null) ? 0 : dutyDay.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + (isCome ? 1231 : 1237);
		return result;
	}

	// ����employee��isCome��dutyDay����дequals()����
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
