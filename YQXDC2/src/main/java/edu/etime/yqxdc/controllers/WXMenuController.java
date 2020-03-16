package edu.etime.yqxdc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.etime.yqxdc.dto.WXMenuDto;
import edu.etime.yqxdc.pojo.Goods;
import edu.etime.yqxdc.pojo.GoodsType;
import edu.etime.yqxdc.services.interfaces.WXMenuService;

/**
 * 微信菜单显示控制类
 * @author RL
 *
 */
@Controller
@RequestMapping("/wx")
public class WXMenuController {
	
	@Autowired
	private WXMenuService service;
	/**
	 * 查询菜单方法
	 * @return
	 */
	@RequestMapping("/menu")
	@ResponseBody
	public WXMenuDto menu(){
		//1、组织参数
		GoodsType goodstype = new GoodsType();
		goodstype.setGtstate(1);
		Goods goods = new Goods();
		goods.setGstate(1);
		WXMenuDto dto = service.selectWXMenu(goodstype, goods);
		return dto;
	}

}
