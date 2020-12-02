package org.zzx.dksystem.domain;

import java.io.Serializable;

public class Application implements Serializable{
	private static final long serialVersionUID = 48L;

	//��ʶ����
	private Integer id;

	//��Ӧ��ͨԱ���Ŀ������룬�����������ɣ��Ƿ�����������ı�����͵�
	
	//��������
	private String reason;
	
	//�Ƿ�����
	private boolean result;
	
	//�����ĳ��ڼ�¼
	private Attend attend;
	
	//����ı������
	private AttendType type;

	//�޲ι�����
	public Application() {
		super();
	}

	//��ʼ�����г�Ա�����Ĺ�����
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
