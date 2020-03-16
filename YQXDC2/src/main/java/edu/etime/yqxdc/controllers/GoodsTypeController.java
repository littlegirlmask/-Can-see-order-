package edu.etime.yqxdc.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.etime.yqxdc.pojo.GoodsType;
import edu.etime.yqxdc.services.interfaces.GoodsTypeService;

/**
 * 角色管理的controller层
 * @author RL
 *
 */
@Controller
@RequestMapping("/goods/goodstype")
public class GoodsTypeController {
	
	//依赖service层
	@Autowired
	private GoodsTypeService service;
	
	/**
	 * 进入到增加页面的方法
	 * @return
	 */
	@RequestMapping("/toadd")
	public String toadd() {
		return "goods/goodstype/add";
	}
	
	/**
	 * 增加菜品种类
	 * @param goodstype
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String add(GoodsType goodstype,Model model){
		//设置菜品种类的id属性
		goodstype.setGtid(UUID.randomUUID().toString());
		//保存菜品种类
		int rtn = service.add(goodstype);
		if(rtn > 0){
			return "redirect:/goods/goodstype/list";
		}else{
			model.addAttribute("msg", "增加菜品种类失败");
			return "goods/goodstype/add";
		}	
	}
	
	/**
	 * 查询角色列表controller
	 * @param gtname
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(String gtname,Model model){
		GoodsType gt = new GoodsType();
		if(gtname != null){
			gt.setGtname(gtname);
		}
		List<GoodsType> list = service.selectGoodsTypeByName(gt);
		model.addAttribute("list", list);
		return "goods/goodstype/list";
	}
	
	/**
	 * 初始化修改菜品种类页面方法
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toedit")
	public String toedit(String id,Model model){
		GoodsType goodstype = service.selectById(id);
		model.addAttribute("goodstype", goodstype);
		return "goods/goodstype/edit";
	}
	
	/**
	 * 修改菜品种类
	 * @param goodstype
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(GoodsType goodstype,Model model){
		int rtn = service.updateGoodsType(goodstype);
		//跳转到list页面（使用重定向）
		if(rtn > 0){
			return "redirect:/goods/goodstype/list";
		}
		else{
			return "goods/goodstype/edit";
		}
	}
}
