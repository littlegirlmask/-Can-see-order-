package edu.etime.yqxdc.services.interfaces;

import java.util.List;

import edu.etime.yqxdc.pojo.GoodsType;

/**
 * 商品类别管理
 * @author RL
 *
 */
public interface GoodsTypeService {

	/**
	 * 查询商品类别列表
	 * @param gt
	 * @return
	 */
	public List<GoodsType> selectGoodsType(GoodsType gt);
	
	public List<GoodsType> selectGoodsTypeByName(GoodsType gt);
	
	/**
	 * 增加菜品种类
	 * @param goodstype 菜品种类对象
	 * @return
	 */
	public int add(GoodsType goodstype);
	
	/**
	 * 根据id获取菜品种类的详细信息
	 * @param id
	 * @return
	 */
	public GoodsType selectById(String id);
	
	/**
	 * 修改菜品种类
	 * @param goodstype
	 * @return
	 */
	public int updateGoodsType(GoodsType goodstype);
	
}
