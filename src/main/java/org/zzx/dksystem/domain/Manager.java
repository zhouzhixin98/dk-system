package org.zzx.dksystem.domain;

import java.io.Serializable;
import java.util.List;

public class Manager extends Employee implements Serializable {
	private static final long serialVersionUID = 48L;
	//该经理管理的部门
	private String dept;
	//该经理对应的所有员工
	private List<Employee> employees;
	//该经理签署的所有批复
	private List<CheckBack> checks;
	
	//无参构造器
	public Manager() {}
	
	//初始化所有成员变量的构造器
	public Manager(String dept, List<Employee> employees, List<CheckBack> checks) {
		super();
		this.dept = dept;
		this.employees = employees;
		this.checks = checks;
	}

	//三个变量的getter、setter方法	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<CheckBack> getChecks() {
		return checks;
	}

	public void setChecks(List<CheckBack> checks) {
		this.checks = checks;
	}
	
	
}
