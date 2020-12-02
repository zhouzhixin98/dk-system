package org.zzx.dksystem.schedule;

import org.zzx.dksystem.service.EmpManager;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


public class PayJob extends QuartzJobBean
{
	// 判断作业是否执行的旗标
	private boolean isRunning = false;
	// 该作业类所依赖的业务逻辑组件
	private EmpManager empMgr;
	public void setEmpMgr(EmpManager empMgr)
	{
		this.empMgr = empMgr;
	}
	// 定义任务执行体
	public void executeInternal(JobExecutionContext ctx)
		throws JobExecutionException
	{
		if (!isRunning)
		{
			System.out.println("开始调度自动结算工资");
			isRunning = true;
			// 调用业务逻辑方法
			empMgr.autoPay();
			isRunning = false;
		}
	}
}