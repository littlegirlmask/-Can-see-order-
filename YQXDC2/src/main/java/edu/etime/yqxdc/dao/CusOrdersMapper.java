package edu.etime.yqxdc.dao;

import java.util.List;

import edu.etime.yqxdc.dto.OrderDto;
import edu.etime.yqxdc.dto.QueueDto;
import edu.etime.yqxdc.pojo.CusOrders;

public interface CusOrdersMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(CusOrders record);

    int insertSelective(CusOrders record);

    CusOrders selectByPrimaryKey(String orderid);

    int updateByPrimaryKeySelective(CusOrders record);

    int updateByPrimaryKey(CusOrders record);
    
    /**
     * 根据客户id查询该客户正在队列中的订单信息
     * @param cusid
     * @return
     */
    List<CusOrders> selectOrderByCusid(String cusid);

    /**
     * 查询队列信息
     * @param date
     * @return
     */
    QueueDto selectQueue(String date);
    
    /**
     * 查询订单列表信息
     * @return
     */
    List<OrderDto> selectOrder();
    
    int updateStatingByOrderId(String id);
    
    int updateStatedByOrderId(String id);
    
    int updatenullStateByOrderId(String id);
    
    /**
     * 更新订单状态
     * @param orderid
     * @return
     */
    int updateOrderState(String orderid);
    
    int updateOrderSta(String orderid);
}