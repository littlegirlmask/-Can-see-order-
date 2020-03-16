package edu.etime.yqxdc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.etime.yqxdc.dao.GoodsMapper;
import edu.etime.yqxdc.dto.GoodsDto;
import edu.etime.yqxdc.pojo.Goods;
import edu.etime.yqxdc.services.interfaces.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper mapper;
	
	@Override
	public int insertGoods(Goods goods) {
		return mapper.insertSelective(goods);
	}

	@Override
	public List<GoodsDto> selectGoods(Goods goods) {
		return mapper.selectGoods(goods);
	}

	@Override
	public Goods selectGoodsById(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateGoods(Goods goods) {
		return mapper.updateByPrimaryKey(goods);
	}

}
