package edu.etime.yqxdc.dao;

import java.util.List;

import edu.etime.yqxdc.pojo.SysRole;

public interface SysRoleMapper {
    int deleteByPrimaryKey(String roleid);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String roleid);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
    
    /**
     *查询角色列表的接口方法
     * @param role 查询条件（主要包含：角色名称）
     * @return
     */
    List<SysRole> selectSysRole(SysRole role);
    
    
}