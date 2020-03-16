package edu.etime.yqxdc.dto;

import edu.etime.yqxdc.pojo.CusOrders;

public class OrderDto extends CusOrders{
	private String nickname;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
