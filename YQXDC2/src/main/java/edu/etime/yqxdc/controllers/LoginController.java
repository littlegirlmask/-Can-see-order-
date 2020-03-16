package edu.etime.yqxdc.controllers;

import java.util.List;

import java.util.List;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.etime.yqxdc.dto.SysUserDto;
import edu.etime.yqxdc.pojo.SysRole;
import edu.etime.yqxdc.pojo.SysUser;
import edu.etime.yqxdc.services.interfaces.SysRoleService;
import edu.etime.yqxdc.services.interfaces.SysUserService;

/**
 * ��ɫ�����controller��
 * 
 * @author RL
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {

	// ����servcie��
	@Autowired
	private SysUserService service;

	/**
	 * ���뵽����ҳ��ķ���
	 * 
	 * @return
	 */
//	@RequestMapping("/tologin")
//	public String tologin() {
//		return "${pageContext.request.contextPath}/login";
//	}

	/**
	 * ����ϵͳ��ɫ ע�⣺����SysRole -->ҳ�����name���Ա���Ҫ��SysRole�е�����һ�¡�
	 * SpringMVC���ܽ�����������Զ�ע�뵽role������
	 */
	@RequestMapping("/login")
	public String login(String username, String password, Model model) {
		SysUser user = new SysUser();
		System.out.print("111");
		if (username != null && password != null) {
			user= service.selectUserByName(username,password);
		}
		if(user!=null && user.getUsername()!=null){
			System.out.print(user.getUsername());
			return "menu/menu";
		}
		JOptionPane.showMessageDialog(null, "登陆失败");
		System.out.print("222");
		return "login/login";
		
	}


}
