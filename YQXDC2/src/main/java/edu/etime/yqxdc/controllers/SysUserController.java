package edu.etime.yqxdc.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.etime.yqxdc.dto.SysUserDto;
import edu.etime.yqxdc.pojo.SysRole;
import edu.etime.yqxdc.pojo.SysUser;
import edu.etime.yqxdc.services.interfaces.SysRoleService;
import edu.etime.yqxdc.services.interfaces.SysUserService;

@Controller
@RequestMapping("/sys/user")
public class SysUserController {

	@Autowired
	private SysRoleService roleservice;
	@Autowired
	private SysUserService service;
	
	/**
	 *进入到增加页面的方法
	 * @return
	 */
	@RequestMapping("/toadd")
	public String toadd(Model model){
		//先要查询系统角色，并将其传递到add.jsp页面
		//查询的角色必须是可用的
		SysRole role = new SysRole();
		role.setRolestate(1);
		List<SysRole> list = roleservice.selectRole(role);
		model.addAttribute("list",list);
		return "sys/user/add";
	}
	
	/**
	 * 增加用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/add")
	public String add(SysUser user,Model model){
		user.setUserid(UUID.randomUUID().toString());
		int rtn = service.insertUser(user);
		if(rtn>0){
			return "redirect:/sys/user/list";
		}else{
			model.addAttribute("msg", "保存用户失败");
			return "sys/user/add";
		}
	}
	
	/**
	 * 查询用户列表的controller
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(SysUser user,Model model){
		//初始化下拉列表
		SysRole role = new SysRole();
		role.setRolestate(1);
		List<SysRole> rolelist = roleservice.selectRole(role);
		model.addAttribute("rolelist",rolelist);
		
		//初始化列表数据
		List<SysUserDto> list = service.selectUser(user);
		model.addAttribute("list", list);
		return "sys/user/list";
	}
	
	/**
	 * 初始化修改页面
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toedit")
	public String toedit(String id,Model model){
		//绑定用户角色下拉列表
		SysRole role = new SysRole();
		role.setRolestate(1);
		List<SysRole> rolelist = roleservice.selectRole(role);
		model.addAttribute("list",rolelist);
		
		SysUser user = service.selectUserById(id);
		model.addAttribute("user", user);
		return "/sys/user/edit";
	}
	
	/**
	 * 修改用户
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(SysUser user ,Model model){
		
		int rtn = service.updateUser(user);
		if(rtn>0){
			return "redirect:/sys/user/list";
		}else{
			model.addAttribute("msg", "修改用户失败");
			return "sys/user/edit";
		}
		
	}
	
}
