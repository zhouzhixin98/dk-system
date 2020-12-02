package org.zzx.dksystem.dao;

import org.zzx.dksystem.domain.CheckBack;

import java.util.List;

public interface CheckBackMapper {
    /*
    * 保存批复
    * @param 批复内容
    * @result 保存批复条数
    * */
    Integer save(CheckBack checkBack);

    /*
     * 查询指定经理处理的批复
     * @param id 指定经理的id
     * @result 指定经理处理的批复
     * */
    List<CheckBack> findByMgrId(Integer id);

    /*
     * 根据员工查询他的申请批复
     * @param empName
     * @result 他的申请批复集合
     * */
    List<CheckBack> findAppED();
}
