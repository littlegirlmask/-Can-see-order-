package edu.etime.yqxdc.services.interfaces;

import edu.etime.yqxdc.dto.QueueDto;

/**
 * 客户队列接口
 * @author RL
 *
 */
public interface QueueService {
	/**
	 * 获取客户的订单信息
	 * @param openid
	 * @return 如果返回null，那么说明用户还没有订单在队列中
	 */
	public QueueDto selectQueue(String openid);

}
