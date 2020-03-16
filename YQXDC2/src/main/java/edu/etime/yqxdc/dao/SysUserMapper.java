package edu.etime.yqxdc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.etime.yqxdc.dto.SysUserDto;
import edu.etime.yqxdc.pojo.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String userid);
    
    SysUser selectUserByName(@Param("username")String username, @Param("password")String password);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    /**
     * 用户列表
     * @param user
     * @return
     */
    List<SysUserDto> selectUser(SysUser user);
    
}