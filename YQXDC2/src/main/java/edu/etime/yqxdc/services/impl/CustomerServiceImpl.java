package edu.etime.yqxdc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.etime.yqxdc.dao.CustomerMapper;
import edu.etime.yqxdc.pojo.Customer;
import edu.etime.yqxdc.services.interfaces.CustomerService;

/**
 * 客户管理接口实现类
 * @author RL
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper mapper;
	
	@Override
	public List<Customer> selectCustomerByOpenid(String openid) {
		return mapper.selectCustomerByOpenid(openid);
	}

	@Override
	public int insertCustomer(Customer cus) {
		return mapper.insert(cus);
	}

}
