package edu.etime.yqxdc.services.interfaces;

import java.util.List;

import edu.etime.yqxdc.pojo.SysRole;

/**
 * 系统角色管理接口
 * @author RL
 *
 */
public interface SysRoleService {

	/**
	 * 增加系统角色
	 * @param role 角色对象
	 * @return
	 */
	public int add(SysRole role);
	
	/**
	 * 查询角色列表
	 * @param role 可能的参数：rolename
	 * @return
	 */
	public List<SysRole> selectRole(SysRole role);
	
	/**
	 * 根据id获取角色的详细信息
	 * @param id
	 * @return
	 */
	public SysRole selectById(String id);
	
	/**
	 * �修改角色的方法
	 * @param role
	 * @return
	 */
	public int updateRole(SysRole role);
	
}
