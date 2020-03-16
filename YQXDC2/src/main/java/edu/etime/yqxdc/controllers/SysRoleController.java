package edu.etime.yqxdc.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.etime.yqxdc.pojo.SysRole;
import edu.etime.yqxdc.services.interfaces.SysRoleService;

/**
 * 角色管理的controller层
 * @author RL
 *
 */
@Controller
@RequestMapping("/sys/role")
public class SysRoleController {

	//依赖service层
	@Autowired
	private SysRoleService service;

	/**
	 * 进入到增加页面的方法
	 * @return
	 */
	@RequestMapping("/toadd")
	public String toadd() {
		return "sys/role/add";
	}

	/**
	 * 增加系统角色
	 * 注意SysRole-->页面表单的name属性必须要和SysRole中的属性一致
	 * SpringMVC才能将输入的数据自动注入到role对象中
	 * @param role
	 * @return
	 */
	@RequestMapping("/add")
	public String add(SysRole role,Model model) {
		//设置角色的roleId属性
		role.setRoleid(UUID.randomUUID().toString());
		//保存角色
		int rtn = service.add(role);
		if (rtn > 0) {
			return "redirect:/sys/role/list";
		} else {
			model.addAttribute("msg", "增加角色失败");
			return "sys/role/add";
		}
	}

	/**
	 * 查询角色列表的controller
	 * @param rolename
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(String rolename, Model model) {

		SysRole role = new SysRole();
		if (rolename != null) {
			role.setRolename(rolename);
		}
		List<SysRole> list = service.selectRole(role);
		model.addAttribute("list", list); //将数据放入模型，通过模型将数据传到页面上
		return "sys/role/list";

	}

	/**
	 * 初始化修改页面方法
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/toedit")
	public String toedit(String id, Model model) {

		SysRole role = service.selectById(id);
		model.addAttribute("role", role);
		return "sys/role/edit";
	}

	/**
	 * 修改系统角色
	 * @param role
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(SysRole role, Model model) {

		int rtn = service.updateRole(role);
		// 跳转到list页面（使用重定向到list）
		if (rtn > 0) {
			return "redirect:/sys/role/list";
		} else {
			model.addAttribute("msg", "修改角色失败");
			return "sys/role/edit";
		}
	}

}
