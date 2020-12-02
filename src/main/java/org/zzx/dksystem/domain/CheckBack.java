package org.zzx.dksystem.domain;

import java.io.Serializable;

public class CheckBack implements Serializable {
	private static final long serialVersionUID = 48L;

	// 标识属性
	private Integer id;

	// 该批复对应的申请
	private Application app;

	// 是否同意申请
	private boolean result;

	// 批复理由
	private String reason;

	// 批复的经理
	private Manager manager;


	// 无参数的构造器
	public CheckBack() {
		super();
	}

	// 初始化全部成员变量的构造器
	public CheckBack(Integer id, Application application, boolean result, String reason, Manager manager) {
		super();
		this.id = id;
		this.app = application;
		this.result = result;
		this.reason = reason;
		this.manager = manager;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Application getApp() {
		return this.app;
	}

	public void setApp(Application application) {
		this.app = application;
	}

	public boolean isResult() {
		return this.result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	
}
