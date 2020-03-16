package edu.etime.yqxdc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.etime.yqxdc.dao.SysRoleMapper;
import edu.etime.yqxdc.pojo.SysRole;
import edu.etime.yqxdc.services.interfaces.SysRoleService;

/**
 * 角色管理的实现类（受spring管理）
 * @author RL
 *
 */
@Service
public class SysRoleServcieImpl implements SysRoleService {

	@Autowired
	private SysRoleMapper mapper;
	
	@Override
	public int add(SysRole role) {
		return mapper.insert(role);
	}

	@Override
	public List<SysRole> selectRole(SysRole role) {
		return mapper.selectSysRole(role);
	}

	@Override
	public SysRole selectById(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateRole(SysRole role) {
		return mapper.updateByPrimaryKey(role);
	}

}
