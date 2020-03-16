package edu.etime.yqxdc.dao;

import java.util.List;

import edu.etime.yqxdc.pojo.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey(String cusid);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(String cusid);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    /**
     * 根据openid获取用户的信息（用于用户登录）。
     * @param openid
     * @return 如果由用户，那么返回的list中有一条记录，如果没有则返回list.size==0
     */
    List<Customer> selectCustomerByOpenid(String openid);
}