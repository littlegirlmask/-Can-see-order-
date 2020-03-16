package edu.etime.yqxdc.services.interfaces;

import java.util.List;

import edu.etime.yqxdc.dto.SysUserDto;
import edu.etime.yqxdc.pojo.SysUser;

/**
 * 系统用户管理接口
 * @author RL
 *
 */
public interface SysUserService {
	/**
	 * 增加用户
	 * @param user
	 * @return
	 */
	public int insertUser(SysUser user);
	/**
	 * 查询用户
	 * @param user
	 * @return
	 */
	public List<SysUserDto> selectUser(SysUser user);
	/**
	 * 根据id查询用户的详细信息
	 * @param id
	 * @return
	 */
	SysUser selectUserById(String id);
	/**
	 * 根据用户名和密码查询用户的详细信息
	 * @param id
	 * @return
	 */
	SysUser selectUserByName(String username, String password);
	/**
	 * 修改用户的方法
	 * @param user
	 * @return
	 */
	int updateUser(SysUser user);
	
}
