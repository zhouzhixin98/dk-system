package org.zzx.dksystem.domain;

import java.io.Serializable;
import java.util.List;

public class Manager extends Employee implements Serializable {
	private static final long serialVersionUID = 48L;
	//�þ������Ĳ���
	private String dept;
	//�þ����Ӧ������Ա��
	private List<Employee> employees;
	//�þ���ǩ�����������
	private List<CheckBack> checks;
	
	//�޲ι�����
	public Manager() {}
	
	//��ʼ�����г�Ա�����Ĺ�����
	public Manager(String dept, List<Employee> employees, List<CheckBack> checks) {
		super();
		this.dept = dept;
		this.employees = employees;
		this.checks = checks;
	}

	//����������getter��setter����	
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
