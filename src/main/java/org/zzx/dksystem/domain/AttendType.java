package org.zzx.dksystem.domain;

import java.io.Serializable;

public class AttendType implements Serializable{
	private static final long serialVersionUID = 48L;
	
	//标识属性
	private Integer id;
	//对应考勤的类型，包括考勤的名称，如迟到、早退,此类出勤对应的罚款等
	
	//出勤类型的名称
	private String name;
	
	//此类出勤对应的处罚罚款
	private double amerce;
	
	//无参构造器
	public AttendType() {
		super();
	}

	//初始化所有成员变量的构造器
	public AttendType(Integer id, String name, double amerce) {
		super();
		this.id = id;
		this.name = name;
		this.amerce = amerce;
	}

	//getter setter 
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmerce() {
		return this.amerce;
	}

	public void setAmerce(double amerce) {
		this.amerce = amerce;
	}
	

	
	
}
