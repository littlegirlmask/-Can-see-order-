package edu.etime.yqxdc.services.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.etime.yqxdc.dao.CusOrdersMapper;
import edu.etime.yqxdc.dao.CustomerMapper;
import edu.etime.yqxdc.dao.OrderDetailMapper;
import edu.etime.yqxdc.dto.GoodsDto;
import edu.etime.yqxdc.dto.OrderDetailDto;
import edu.etime.yqxdc.dto.OrderDto;
import edu.etime.yqxdc.pojo.CusOrders;
import edu.etime.yqxdc.pojo.Customer;
import edu.etime.yqxdc.pojo.OrderDetail;
import edu.etime.yqxdc.services.interfaces.OrderService;

/**
 * 订单管理服务层的实现类
 * @author RL
 *
 */
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private CustomerMapper cusmapper;
	@Autowired
	private CusOrdersMapper ordermapper;
	@Autowired
	private OrderDetailMapper orderdetailmapper;
	
	/**
	 * 下订单实现
	 * 1、根据openid获取cusid
	 * 2、保存订单信息cusorders
	 * 3、遍历保存orderdetail
	 * 4、返回值：1-成功；0-失败；2-用户未注册
	 */
	@Override
	public int insertOrder(List<GoodsDto> goodslist, String openid, double totalprice) {
		
		int rtn = 1;
		
		//1、根据openid获取cusid
		List<Customer> cuslist = cusmapper.selectCustomerByOpenid(openid);
		if(cuslist.size()>0){
			Customer cus = cuslist.get(0);
			String cusid = cus.getCusid();
			String orderid = UUID.randomUUID().toString();
			//2、保存订单信息
			CusOrders orders = new CusOrders();
			orders.setOrderid(orderid);
			orders.setCusid(cusid);
			orders.setOrderstate(1);
			orders.setOrdertotleprice(new BigDecimal(totalprice));
			orders.setOrdertime(new Date());
			rtn = ordermapper.insert(orders);
			if(rtn>0){
				//3、保存订单明细
				for(GoodsDto goods:goodslist){
					if(goods.getGcount()>0){
						OrderDetail detail = new OrderDetail();
						detail.setGid(goods.getGid());
						detail.setOrderid(orderid);
						detail.setOdid(UUID.randomUUID().toString());
						detail.setOdprice(goods.getGprice());
						detail.setOdcount(new BigDecimal(goods.getGcount()));
						rtn = orderdetailmapper.insert(detail);
						if(rtn<1){
							break;
						}
					}
				}
			}
		}else{
			//没有用户
			rtn = 2;
		}
		return rtn;
	}
	
	/**
	 * 获取订单列表
	 */
	@Override
	public List<OrderDto> selectOrder() {
		return ordermapper.selectOrder();
	}
	/**
	 * 获取订单详情
	 */
	@Override
	public List<OrderDetailDto> selectOrderDetail() {
		return orderdetailmapper.selectOrderDetail();
	}

	@Override
	public int updateStatingByOrderId(String id) {
		return ordermapper.updateStatingByOrderId(id);
	}

	@Override
	public int updateStatedByOrderId(String id) {
		return ordermapper.updateStatedByOrderId(id);
	}

	@Override
	public int updatenullStateByOrderId(String id) {
		return ordermapper.updatenullStateByOrderId(id);
	}

	/**
	 * 更新订单状态
	 */
	@Override
	public int updateOrderState(String orderid) {
		return ordermapper.updateOrderState(orderid);
	}

	@Override
	public int updateOrderSta(String orderid) {
		return ordermapper.updateOrderSta(orderid);
	}

}
