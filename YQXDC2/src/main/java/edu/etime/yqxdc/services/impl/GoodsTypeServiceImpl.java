package edu.etime.yqxdc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.etime.yqxdc.dao.GoodsTypeMapper;
import edu.etime.yqxdc.pojo.GoodsType;
import edu.etime.yqxdc.services.interfaces.GoodsTypeService;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

	@Autowired
	private GoodsTypeMapper mapper;
	
	@Override
	public List<GoodsType> selectGoodsType(GoodsType gt) {
		return mapper.selectGoodsType(gt);
	}

	@Override
	public int add(GoodsType goodstype) {
		return mapper.insert(goodstype);
	}

	@Override
	public List<GoodsType> selectGoodsTypeByName(GoodsType gt) {
		return mapper.selectGoodsTypeByName(gt);
	}

	@Override
	public GoodsType selectById(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateGoodsType(GoodsType goodstype) {
		return mapper.updateByPrimaryKey(goodstype);
	}
}
