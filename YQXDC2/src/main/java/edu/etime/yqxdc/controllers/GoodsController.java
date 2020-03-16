package edu.etime.yqxdc.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.etime.yqxdc.dto.GoodsDto;
import edu.etime.yqxdc.pojo.Goods;
import edu.etime.yqxdc.pojo.GoodsType;
import edu.etime.yqxdc.services.interfaces.GoodsService;
import edu.etime.yqxdc.services.interfaces.GoodsTypeService;

/**
 * 商品管理控制层
 * @author RL
 *
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsTypeService gtservice;
	@Autowired
	private GoodsService service;
	
	/**
	 * 进入到增加商品页面的方法
	 * @param model
	 * @return
	 */
	@RequestMapping("/toadd")
	public String toadd(Model model){
		
		GoodsType goodstype = new GoodsType();
		goodstype.setGtstate(1);
		List<GoodsType> goodsTypeList = gtservice.selectGoodsType(goodstype);
		model.addAttribute("type", goodsTypeList);
		return "goods/goods/add";
	}
	
	/**
	 * 增加商品方法
	 * @param goods 商品对象 （缺少：gid,gimg）
	 * @param file 需要上传的图片
	 * @param request
	 * @return
	 */
	@RequestMapping("/add")
	public String add(Goods goods,@RequestParam("file") MultipartFile file,HttpServletRequest request,Model model){
		//1、上传图片
		if(file!=null && !file.isEmpty()){
			//获取文件的名称
			String oldname = file.getOriginalFilename();
			//获取文件的后缀名
			String sux = oldname.substring(oldname.lastIndexOf(".")); 
			//生成新的文件名
			String newname = UUID.randomUUID().toString()+sux;
			//获取文件上传的物理路径
			String upload = request.getServletContext().getRealPath("/file/")+newname;
			//上传图片
			try {
				file.transferTo(new File(upload));
				//上传文件之后，将文件名称放入到goods对象中
				goods.setGimg(newname);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		//2、为这个goods生成主键
		goods.setGid(UUID.randomUUID().toString());
		//3、保存
		int rtn = service.insertGoods(goods);
		//4、处理保存结果
		if(rtn>0){
			return "redirect:/goods/list";
		}else{
			model.addAttribute("msg", "保存商品失败");
			return "goods/goods/list";
		}
	}
	/**
	 * 查询商品列表
	 * @param gname
	 * @param gtid
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(String gname,String gtid,Model model){
	
		//1、初始化商品类别下拉列表
		GoodsType goodstype = new GoodsType();
		goodstype.setGtstate(1);
		List<GoodsType> goodsTypeList = gtservice.selectGoodsType(goodstype);
		model.addAttribute("goodstypelist", goodsTypeList);
		
		//2、查询商品列表
		Goods goods = new Goods();
		if(gname!=null){
			goods.setGname(gname);
		}
		if(gtid!=null){
			goods.setGtid(gtid);
		}
		List<GoodsDto> goodslist = service.selectGoods(goods);
		model.addAttribute("list", goodslist);
		//3、跳转到list.jsp
		return "goods/goods/list";
	}
	
	/**
	 * 初始化修改页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toedit")
	public String toedit(String id,Model model){
		//绑定商品的商品种类下拉列表
		GoodsType goodstype = new GoodsType();
		goodstype.setGtstate(1);
		List<GoodsType> goodsTypeList = gtservice.selectGoodsType(goodstype);
		model.addAttribute("type", goodsTypeList);
		
		Goods goods = service.selectGoodsById(id);
		model.addAttribute("goods", goods);
		return "/goods/goods/edit";
	}
	
	/**
	 * 修改商品
	 * @param goods
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(Goods goods,@RequestParam("file") MultipartFile file,HttpServletRequest request,Model model){
		//1、上传图片
		if(file!=null && !file.isEmpty()){
			//获取文件的名称
			String oldname = file.getOriginalFilename();
			//获取文件的后缀名
			String sux = oldname.substring(oldname.lastIndexOf(".")); 
			//生成新的文件名
			String newname = UUID.randomUUID().toString()+sux;
			//获取文件上传的物理路径
			String upload = request.getServletContext().getRealPath("/file/")+newname;
			//上传图片
			try {
				file.transferTo(new File(upload));
				//上传文件之后，将文件名称放入到goods对象中
				goods.setGimg(newname);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		System.out.println(goods.getGcontent());
		int rtn = service.updateGoods(goods);
		if(rtn>0){
			return "redirect:/goods/list";
		}else{
			model.addAttribute("msg", "修改商品失败");
			return "goods/goods/edit";
		}
	}
}
