package edu.etime.yqxdc.dao;

import java.util.List;

import edu.etime.yqxdc.dto.OrderDetailDto;
import edu.etime.yqxdc.pojo.GoodsType;

public interface GoodsTypeMapper {
    int deleteByPrimaryKey(String gtid);

    int insert(GoodsType record);

    int insertSelective(GoodsType record);

    GoodsType selectByPrimaryKey(String gtid);

    int updateByPrimaryKeySelective(GoodsType record);

    int updateByPrimaryKey(GoodsType record);
    
    /**
     * 查询商品类别列表的接口方法
     * @param gt 查询条件（包含：菜品种类状态）
     * @return
     */
    List<GoodsType> selectGoodsType(GoodsType gt); 
    
    /**
     * 查询商品类别列表的接口方法
     * @param gt 查询条件（包含：菜品种类名称）
     * @return
     */
    List<GoodsType> selectGoodsTypeByName(GoodsType gt);
    
    /**
     * 查询所有订单明细
     * @return
     */
    List<OrderDetailDto> selectOrderDetail();

    
}