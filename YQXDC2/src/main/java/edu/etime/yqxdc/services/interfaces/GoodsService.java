package edu.etime.yqxdc.services.interfaces;

import java.util.List;

import edu.etime.yqxdc.dto.GoodsDto;
import edu.etime.yqxdc.pojo.Goods;

/**
 * 商品管理接口
 * @author RL
 *
 */
public interface GoodsService {

	/**
	 * 保存商品方法
	 * @param goods
	 * @return
	 */
	public int insertGoods(Goods goods);
	/**
	 * 查询商品列表
	 * @param goods
	 * @return
	 */
	public List<GoodsDto> selectGoods(Goods goods);
	
	/**
	 * 根据id查询商品的详细信息
	 * @param id
	 * @return
	 */
	Goods selectGoodsById(String id);
	
	/**
	 * 修改商品方法
	 * @param goods
	 * @return
	 */
	int updateGoods(Goods goods);
}
