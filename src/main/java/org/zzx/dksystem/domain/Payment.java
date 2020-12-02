package org.zzx.dksystem.domain;

import java.io.Serializable;

public class Payment implements Serializable{
	private static final long serialVersionUID = 48L;
	
	//标识属性
	private Integer id;
	
	//对应每月的工资信息，包括工资的月份，领工资的员工及工资数等信息.
	
	//发工资月份
	private String payMonth;
	
	//发薪的数量
	private double amout;
	
	//领工资的员工
	private Employee empolyee;
	
	//无参构造器
	public Payment() {}

	//初始化所有成员变量的构造器
	public Payment(Integer id, String payMonth, double amout, Employee empolyee) {
		this.id = id;
		this.payMonth = payMonth;
		this.amout = amout;
		this.empolyee = empolyee;
	}

	//getter setter 方法
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPayMonth() {
		return this.payMonth;
	}

	public void setPayMonth(String payMonth) {
		this.payMonth = payMonth;
	}

	public double getAmout() {
		return this.amout;
	}

	public void setAmout(double amout) {
		this.amout = amout;
	}

	public Employee getEmpolyee() {
		return this.empolyee;
	}
 
	public void setEmpolyee(Employee empolyee) {
		this.empolyee = empolyee;
	}
	
	
	
}
