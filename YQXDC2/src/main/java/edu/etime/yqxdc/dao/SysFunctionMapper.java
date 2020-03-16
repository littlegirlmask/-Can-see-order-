package edu.etime.yqxdc.dao;

import edu.etime.yqxdc.pojo.SysFunction;

public interface SysFunctionMapper {
    int deleteByPrimaryKey(String funid);

    int insert(SysFunction record);

    int insertSelective(SysFunction record);

    SysFunction selectByPrimaryKey(String funid);

    int updateByPrimaryKeySelective(SysFunction record);

    int updateByPrimaryKey(SysFunction record);
}