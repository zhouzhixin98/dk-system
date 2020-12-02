package org.zzx.dksystem.domain;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;


public class Employee implements Serializable {
	private static final long serialVersionUID = 48L;
	//设置表示属性
	private Integer id;
	//员工姓名
	@NotBlank(message = "用户名不能为空",
			groups = {AddEmployee.class,Login.class})
	@Length(min = 4 , max = 25 ,
			message = "用户名在4-25个字符之间",
			groups = {AddEmployee.class,Login.class})
	private String name;
	
	//密码
	@NotBlank(message = "密码不能为空",
			groups = {AddEmployee.class,Login.class})
	@Length(min = 4 , max = 25 ,
			message = "密码在4-25个字符之间",
			groups = {AddEmployee.class,Login.class})
	private String pass;
	
	//工资信息
	@NotNull(message = "工资不能为空",
			groups = AddEmployee.class)
	@Range(min = 3000 , max = 6000 ,
			message = "每月工资在3K-6K之间",
			groups = AddEmployee.class)
	private double salary;
	
	//员工对应的经理信息
	private Manager manager;
	
	//员工对应的出勤记录
	private List<Attend> attends;
	
	//员工对应的工资支付记录
	private List<Payment> payments;

	//无参构造器
	public Employee() {}
	
	//初始化构造器
	public Employee(Integer id, String name, String pass, double salary, Manager manager, List<Attend> attends,
			List<Payment> payments) {
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.salary = salary;
		this.manager = manager;
		this.attends = attends;
		this.payments = payments;
	}

	//getter、setter方法
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	//manager��getter��setter����
	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	
	//attends��getter��setter����
	public List<Attend> getAttends() {
		return this.attends;
	}

	public void setAttends(List<Attend> attends) {
		this.attends = attends;
	}

	
	//payments��getter��setter����
	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	
	//����name��pass����дhashCode����
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1 ;
		result = prime * result + (name == null ? 0:name.hashCode());
		result = prime * result + (pass == null ? 0:pass.hashCode());
		return result;
	}
	
	//根据name、pass重写equals方法
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (this == null) return false;
		if (getClass()!=obj.getClass()) return false;
		Employee other = (Employee) obj;
		if (name == null) 
		{
			if (other.name != null ) return false;
		}
		else if (!name.equals(other.name)) return false;
		if(pass == null )
		{
			if (other.pass != null ) return false;
		}
		else if (!pass.equals(other.pass)) return false;
		return true;
	}
}
