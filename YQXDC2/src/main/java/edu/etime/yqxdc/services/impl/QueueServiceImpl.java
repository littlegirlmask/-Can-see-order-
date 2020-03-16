package edu.etime.yqxdc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.etime.yqxdc.dao.CusOrdersMapper;
import edu.etime.yqxdc.dao.CustomerMapper;
import edu.etime.yqxdc.dao.OrderDetailMapper;
import edu.etime.yqxdc.dto.OrderDetailDto;
import edu.etime.yqxdc.dto.QueueDto;
import edu.etime.yqxdc.pojo.CusOrders;
import edu.etime.yqxdc.pojo.Customer;
import edu.etime.yqxdc.services.interfaces.QueueService;

/**
 * 客户队列实现
 * @author RL
 *
 */
@Service
public class QueueServiceImpl implements QueueService{
	@Autowired
	private CustomerMapper cusmapper;
	@Autowired
	private CusOrdersMapper ordermapper;
	@Autowired
	private OrderDetailMapper detailmapper;

	@Override
	public QueueDto selectQueue(String openid) {
		/**
		 * 1、根据openid获取cusid
		 * 2、根据cusid获取订单信息
		 * 3、根据订单的orderid获取订单明细
		 * 4、根据订单的下单时间获取队列信息
		 */
		QueueDto dto = null;
		//1、根据openid获取cusid
		List<Customer> cuslist = cusmapper.selectCustomerByOpenid(openid);
		if(cuslist.size()>0){
			Customer customer = cuslist.get(0);
			String cusid = customer.getCusid();
			//2、根据cusid获取订单信息
			List<CusOrders> orderlist = ordermapper.selectOrderByCusid(cusid);
			if(orderlist.size()>0){
				CusOrders order = orderlist.get(0);
				//3、根据订单的orderid获取订单明细
				List<OrderDetailDto> detaillist = detailmapper.selectOrderDetailByOrderId(order.getOrderid());
				//4、根据订单的下单时间获取队列信息
				dto = ordermapper.selectQueue(order.getOrdertime().toString());
				//将所有的信息放入到dto对象中
				dto.setOrderdetail(detaillist);
				dto.setOrders(order);
			}
		}
		return dto;
	}

}
