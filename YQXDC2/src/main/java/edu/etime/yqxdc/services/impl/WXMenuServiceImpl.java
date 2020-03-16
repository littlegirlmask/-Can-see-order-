package edu.etime.yqxdc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.etime.yqxdc.dao.GoodsMapper;
import edu.etime.yqxdc.dao.GoodsTypeMapper;
import edu.etime.yqxdc.dto.GoodsDto;
import edu.etime.yqxdc.dto.WXMenuDto;
import edu.etime.yqxdc.pojo.Goods;
import edu.etime.yqxdc.pojo.GoodsType;
import edu.etime.yqxdc.services.interfaces.WXMenuService;

/**
 * 微信菜单接口实现类
 * @author RL
 *
 */
@Service
public class WXMenuServiceImpl implements WXMenuService{

	@Autowired
	private GoodsTypeMapper goodstypemapper;
	@Autowired
	private GoodsMapper goodsmapper;
	@Override
	public WXMenuDto selectWXMenu(GoodsType goodstype, Goods goods) {
		
		List<GoodsType> goodstypelist = goodstypemapper.selectGoodsType(goodstype);
		List<GoodsDto> goodslist = goodsmapper.selectGoods(goods);
		WXMenuDto dto = new WXMenuDto();
		dto.setGoodstypelist(goodstypelist);
		dto.setGoodslist(goodslist);
		return dto;
	}
}
