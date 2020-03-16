package edu.etime.yqxdc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.etime.yqxdc.dao.SysUserMapper;
import edu.etime.yqxdc.dto.SysUserDto;
import edu.etime.yqxdc.pojo.SysUser;
import edu.etime.yqxdc.services.interfaces.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper mapper;
	
	@Override
	public int insertUser(SysUser user) {
		return mapper.insert(user);
	}

	@Override
	public List<SysUserDto> selectUser(SysUser user) {
		return mapper.selectUser(user);
	}

	@Override
	public SysUser selectUserById(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public SysUser selectUserByName(String username, String password) {
		return mapper.selectUserByName(username,password);
	}
	
	@Override
	public int updateUser(SysUser user) {
		return mapper.updateByPrimaryKeySelective(user);
	}
}
