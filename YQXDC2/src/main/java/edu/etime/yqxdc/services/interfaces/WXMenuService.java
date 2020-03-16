package edu.etime.yqxdc.services.interfaces;

import edu.etime.yqxdc.dto.WXMenuDto;
import edu.etime.yqxdc.pojo.Goods;
import edu.etime.yqxdc.pojo.GoodsType;

/**
 * 微信菜单接口
 * @author RL
 *
 */
public interface WXMenuService {
	/**
	 * 获取微信菜单接口方法
	 * @param goodstype 包含gtstate=1
	 * @param goods 包含gstate=1
	 * @return
	 */
	public WXMenuDto selectWXMenu(GoodsType goodstype,Goods goods);

}
