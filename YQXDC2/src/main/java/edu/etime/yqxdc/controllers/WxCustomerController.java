package edu.etime.yqxdc.controllers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import edu.etime.yqxdc.pojo.Customer;
import edu.etime.yqxdc.services.interfaces.CustomerService;


/**
 * 微信客户管理，包含客户的注册和openid获取
 * @author RL
 *
 */
@Controller
@RequestMapping("/wx/customer")
public class WxCustomerController {

	/**
	 * 获取客户openid的方法  
	 * 说明：@ResponseBody 注解：
	 * 表示这个方法返回的内容就是需要响应到客户端的内容，而不需要进行视图解析
	 * @param code
	 * @return
	 */
	@RequestMapping("/getopenid")
	@ResponseBody
	public String login(String code) {
		/**
		 * appid=wx39b65e2fe27c73b8(每个人的密钥，需要到微信小程序平台中去获取)
		 * secret=cc5d91cdb82286014d396e791bd38f62
		 * js_code:小程序传递过来的code属性
		 */
		String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=wx39b65e2fe27c73b8&secret=cc5d91cdb82286014d396e791bd38f62&js_code="
				+ code + "&grant_type=authorization_code";
		String returnvalue = GET(WX_URL);
        JSONObject json = JSONObject.parseObject(returnvalue);
        String openid = json.get("openid").toString();
        System.out.println(openid);
		return openid;
	}
	
	// 发起get请求的方法
	public static String GET(String url) {
		String result = "";
		BufferedReader in = null;
		InputStream is = null;
		InputStreamReader isr = null;
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.connect();
			Map<String, List<String>> map = conn.getHeaderFields();
			is = conn.getInputStream();
			isr = new InputStreamReader(is);
			in = new BufferedReader(isr);
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			// 异常记录
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (is != null) {
					is.close();
				}
				if (isr != null) {
					isr.close();
				}
			} catch (Exception e2) {
				// 异常记录
			}
		}
		return result;
	}
	
	@Autowired
	private CustomerService service;
	
	/**
	 * 客户登录注册方法
	 * @param cus
	 * @return 0:注册失败；1:登录/注册成功
	 */
	@RequestMapping("/login")
	@ResponseBody
	public String login(Customer cus){
		List<Customer> list = service.selectCustomerByOpenid(cus.getOpenid());
		Integer rtn = 1;
		if(list.size()>0){
			//用户已在数据库中存在，这里不需要做其他的处理
		}else{
			//用户不存在，那么需要将用户保存到数据库中
			cus.setCusid(UUID.randomUUID().toString());
			rtn = service.insertCustomer(cus);
		}
		return rtn.toString();
	}
}
