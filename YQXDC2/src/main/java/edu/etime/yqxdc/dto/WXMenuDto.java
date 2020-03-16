package edu.etime.yqxdc.dto;

import java.util.List;

import edu.etime.yqxdc.pojo.GoodsType;

/**
 * 微信小程序菜单数据传输对象
 * 包含商品类型列表和商品列表
 * @author RL
 *
 */
public class WXMenuDto {

	private List<GoodsType> goodstypelist;
	
	private List<GoodsDto> goodslist;

	public List<GoodsType> getGoodstypelist() {
		return goodstypelist;
	}

	public void setGoodstypelist(List<GoodsType> goodstypelist) {
		this.goodstypelist = goodstypelist;
	}

	public List<GoodsDto> getGoodslist() {
		return goodslist;
	}

	public void setGoodslist(List<GoodsDto> goodslist) {
		this.goodslist = goodslist;
	}
}
