package org.zzx.dksystem.domain;

import java.io.Serializable;

public class Payment implements Serializable{
	private static final long serialVersionUID = 48L;
	
	//��ʶ����
	private Integer id;
	
	//��Ӧÿ�µĹ�����Ϣ���������ʵ��·ݣ��칤�ʵ�Ա��������������Ϣ.
	
	//�������·�
	private String payMonth;
	
	//��н������
	private double amout;
	
	//�칤�ʵ�Ա��
	private Employee empolyee;
	
	//�޲ι�����
	public Payment() {}

	//��ʼ�����г�Ա�����Ĺ�����
	public Payment(Integer id, String payMonth, double amout, Employee empolyee) {
		this.id = id;
		this.payMonth = payMonth;
		this.amout = amout;
		this.empolyee = empolyee;
	}

	//getter setter ����
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
