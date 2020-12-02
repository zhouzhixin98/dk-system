package org.zzx.dksystem.dao;

import org.zzx.dksystem.domain.AttendType;

import java.util.List;

public interface AttendTypeMapper {
    /*
    * 根据id获取考勤类型
    * @param id 获取加载的AttendType对象的id
    * @result 指定id对应的AttendType
    * */
    AttendType get(Integer id);

    /*
     * 查询全部考勤类型
     * @result 所有的考勤类型
     * */
    List<AttendType> findAll();
}
