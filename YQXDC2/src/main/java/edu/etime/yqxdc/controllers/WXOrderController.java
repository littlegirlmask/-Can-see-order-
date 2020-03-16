package edu.etime.yqxdc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.etime.yqxdc.dto.GoodsDto;
import edu.etime.yqxdc.dto.QueueDto;
import edu.etime.yqxdc.services.interfaces.OrderService;
import edu.etime.yqxdc.services.interfaces.QueueService;

/**
 * 微信端的订单接口
 * @author RL
 *
 */
@Controller
@RequestMapping("/wx/order")
public class WXOrderController {
	
	@Autowired
	public OrderService service;
	@Autowired
	public QueueService queueservice;
	
	/**
	 * 新增订单方法
	 * @param list
	 * @param openid
	 * @param totalprice
	 * @return
	 */
	@RequestMapping(method={RequestMethod.POST},value="/add")
	@ResponseBody
	public int addorder(@RequestBody List<GoodsDto> list,String openid,String totleprice){
		return service.insertOrder(list, openid, Double.parseDouble(totleprice));
	}
	
	/**
	 * 获取订单队列
	 * @param openid
	 * @return
	 */
	@RequestMapping("/queue")
	@ResponseBody
	public QueueDto queue(String openid){
		return queueservice.selectQueue(openid);
	}
	
	/**
	 * 根据orderid修改订单状态，以达到取消订单
	 * @param orderid
	 * @return
	 */
	@RequestMapping("/cancel")
	@ResponseBody
	public int Cancel(String orderid){
		return service.updateOrderState(orderid);
	}
	
	/**
	 * 根据orderid修改订单状态，以达到支付成功
	 * @param orderid
	 * @return
	 */
	@RequestMapping("/payoff")
	@ResponseBody
	public int payoff(String orderid){
		return service.updateOrderSta(orderid);
	}
}
