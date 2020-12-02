package org.zzx.dksystem.dao;

import java.util.List;

import org.zzx.dksystem.domain.Application;
import org.zzx.dksystem.domain.Employee;

public interface ApplicationMapper {
	/*
	 * 保存异动申请
	 * @param application 要保存的Application对象
	 * @return 新Application对象的id
	 * */
	Integer save(Application application);
	
	/*
	 * 更新异动申请
	 * @param application 要保存的Application对象
	 * @return 受影响的Application的记录数
	 * */
	Integer update(Application application);
	
	/*
	 * 根据id获取异动申请
	 * @param id 获取加载的application对象的id
	 * @return 指定id对应的Application
	 * */
	Application get(Integer id);
	
	/*
	 * 根据员工查询未处理的异动申请
	 * @param emp 需要查询的员工
	 * @return 该员工对应的未处理的异动申请
	 * */
	List<Application> findByEmp(Employee emp);
}
