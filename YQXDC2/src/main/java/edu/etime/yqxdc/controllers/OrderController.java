package edu.etime.yqxdc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.etime.yqxdc.services.interfaces.OrderService;
import edu.etime.yqxdc.dto.OrderDetailDto;
import edu.etime.yqxdc.dto.OrderDto;
/**
 * 订单管理控制层
 * @author RL
 *
 */
@Controller
@RequestMapping("/sys/order")
public class OrderController {
	
	@Autowired
	private OrderService orderservice;
	
	/**
	 * 查询订单列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model){
		List<OrderDto> orderlist = orderservice.selectOrder();
		System.out.println(orderlist.size());//订单数量
		List<OrderDetailDto> orderdetaillist = orderservice.selectOrderDetail();
		System.out.println(orderdetaillist.size());//订单详情数量
		model.addAttribute("cusorderlist", orderlist);
		model.addAttribute("orderdetaillist", orderdetaillist);
		return "sys/order/list";
	}
	
	@RequestMapping("/stating")
	public String stating(String id,Model model){
		int rtn = orderservice.updateStatingByOrderId(id);
		if(rtn>0){
			List<OrderDto> orderlist = orderservice.selectOrder();
			System.out.println(orderlist.size()+111111);//订单数量
			List<OrderDetailDto> orderdetaillist = orderservice.selectOrderDetail();
			System.out.println(orderdetaillist.size()+1111111);//订单详情数量
			model.addAttribute("cusorderlist", orderlist);
			model.addAttribute("orderdetaillist", orderdetaillist);
			return "sys/order/list";
		}else{
			return "";
		}
	}
	
	@RequestMapping("/stated")
	public String stated(String id,Model model){
		int rtn = orderservice.updateStatedByOrderId(id);
		if(rtn>0){
			List<OrderDto> orderlist = orderservice.selectOrder();
			System.out.println(orderlist.size()+111111);//订单数量
			List<OrderDetailDto> orderdetaillist = orderservice.selectOrderDetail();
			System.out.println(orderdetaillist.size()+1111111);//订单详情数量
			model.addAttribute("cusorderlist", orderlist);
			model.addAttribute("orderdetaillist", orderdetaillist);
			return "sys/order/list";
		}else{
			return "";
		}
	}
	
	@RequestMapping("/nullstate")
	public String nullstate(String id,Model model){
		int rtn = orderservice.updatenullStateByOrderId(id);
		if(rtn>0){
			List<OrderDto> orderlist = orderservice.selectOrder();
			System.out.println(orderlist.size()+111111);//订单数量
			List<OrderDetailDto> orderdetaillist = orderservice.selectOrderDetail();
			System.out.println(orderdetaillist.size()+1111111);//订单详情数量
			model.addAttribute("cusorderlist", orderlist);
			model.addAttribute("orderdetaillist", orderdetaillist);
			return "sys/order/list";
		}else{
			return "";
		}
	}

}
