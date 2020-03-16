package edu.etime.yqxdc.services.interfaces;

import java.util.List;

import edu.etime.yqxdc.pojo.Customer;

/**
 * 客户管理接口
 * @author RL
 *
 */
public interface CustomerService {

	/**
	 * 根据openid获取客户信息
	 * @param openid
	 * @return
	 */
	public List<Customer> selectCustomerByOpenid(String openid);
	
	/**
	 * 增加客户方法
	 * @param cus
	 * @return
	 */
	public int insertCustomer(Customer cus);
}
