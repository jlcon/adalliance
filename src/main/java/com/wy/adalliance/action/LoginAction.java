package com.wy.adalliance.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginAction {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 测试使用地址：http://127.0.0.1:8080/index.htm
	 * @Description:
	 * @return
	 */
	@RequestMapping("/index")
	public String homewy(){
		
		return "/indexwy";
	}
	
	@RequestMapping("/anon/loginwy")
	public String loginwy(String username,String password,ModelMap model){
		Subject cuser = SecurityUtils.getSubject();
		
		if(!cuser.isAuthenticated()){
			UsernamePasswordToken token = new UsernamePasswordToken(username,password,"manager");
			try {
				cuser.login(token);
				logger.info("用户：{}已经登录，系统超时时间是：{}分钟。",username);
			}catch (AuthenticationException e) {
				model.put("msg", e.getMessage());
				logger.warn(e.getMessage());
				return "fail";
			}
		}
		
		return "manager/index";
	}
}
