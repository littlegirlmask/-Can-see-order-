package edu.etime.yqxdc.dao;

import java.util.List;

import edu.etime.yqxdc.dto.OrderDetailDto;
import edu.etime.yqxdc.pojo.OrderDetail;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(String odid);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(String odid);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
    
    /**
     * 根据orderid获取订单明细
     * @param orderid
     * @return
     */
    List<OrderDetailDto> selectOrderDetailByOrderId(String orderid);

	List<OrderDetailDto> selectOrderDetail();
}