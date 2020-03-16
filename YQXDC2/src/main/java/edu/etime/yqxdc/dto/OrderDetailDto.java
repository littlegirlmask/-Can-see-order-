package edu.etime.yqxdc.dto;

import edu.etime.yqxdc.pojo.Goods;
/**
 * 订单明细数据传输对象
 * @author RL
 *
 */
public class OrderDetailDto extends Goods {
	//订单价格
	private Double odprice;
	//订单数量
	private Integer odcount;
	//订单id
	private String orderid;
	public Double getOdprice() {
		return odprice;
	}
	public void setOdprice(Double odprice) {
		this.odprice = odprice;
	}
	public Integer getOdcount() {
		return odcount;
	}
	public void setOdcount(Integer odcount) {
		this.odcount = odcount;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	
}
