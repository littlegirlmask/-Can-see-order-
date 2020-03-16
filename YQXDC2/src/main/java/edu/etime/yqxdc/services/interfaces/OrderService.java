package edu.etime.yqxdc.services.interfaces;

import java.util.List;

import edu.etime.yqxdc.dto.GoodsDto;
import edu.etime.yqxdc.dto.OrderDetailDto;
import edu.etime.yqxdc.dto.OrderDto;
/**
 * 订单处理接口
 * @author RL
 *
 */
public interface OrderService {
	/**
	 * 下订单接口
	 * @param goodslist
	 * @param openid
	 * @param totalprice
	 * @return
	 */
	public int insertOrder(List<GoodsDto> goodslist,String openid,double totalprice);
	
	/**
	 * 查询订单列表接口
	 * @return
	 */
	public List<OrderDto> selectOrder();

	/**
	 * 查询订单详情接口
	 * @param orderid
	 * @return
	 */
	public List<OrderDetailDto> selectOrderDetail();
	
	/**
	 * 跟新订单状态
	 * @return
	 */
	public int updateOrderState(String orderid);
	
	public int updateOrderSta(String orderid);
	
	
	public int updateStatingByOrderId(String id);
	
	public int updateStatedByOrderId(String id);
	
	public int updatenullStateByOrderId(String id);

}
