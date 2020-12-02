package org.zzx.dksystem.domain;

import java.io.Serializable;

public class Application implements Serializable{
	private static final long serialVersionUID = 48L;

	//标识属性
	private Integer id;

	//对应普通员工的考勤申请，包括申请理由，是否被批复及申请改变的类型等
	
	//申请理由
	private String reason;
	
	//是否被批复
	private boolean result;
	
	//关联的出勤记录
	private Attend attend;
	
	//申请改变的类型
	private AttendType type;

	//无参构造器
	public Application() {
		super();
	}

	//初始化所有成员变量的构造器
	public Application(Integer id, String reason, boolean result, Attend attend, AttendType type) {
		super();
		this.id = id;
		this.reason = reason;
		this.result = result;
		this.attend = attend;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public boolean isResult() {
		return this.result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public Attend getAttend() {
		return this.attend;
	}

	public void setAttend(Attend attend) {
		this.attend = attend;
	}

	public AttendType getType() {
		return this.type;
	}

	public void setType(AttendType type) {
		this.type = type;
	}
	
	
	
}
