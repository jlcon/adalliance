package com.wy.adalliance.biz.security;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.wy.adalliance.biz.userservice.UserService;
import com.wy.adalliance.dal.mybatis.model.UserInfo;
@Transactional(value="localdb")
public class ShiroDataBaseRealm extends AuthorizingRealm{
	
	@Autowired
	private UserService userService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * URL链接的权限验证
	 * @param principals
	 * @return
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		Subject cuser = SecurityUtils.getSubject();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		UserInfo userinfo = (UserInfo)cuser.getSession().getAttribute("userinfo");
		List<String> roles = userService.getRolesByUserID(userinfo.getUserId());
		logger.info("打印用户资源");
		roles.forEach(role -> {
			info.addStringPermission(role);
			logger.info("用户{}拥有资源{}",userinfo.getUserName(),role);
		});
		return info;
	}

	/**
	 * 登陆验证
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePwdToken = (UsernamePasswordToken) token;
		String username = usernamePwdToken.getUsername();
		if(username == null){
			logger.warn("账号为空");
			throw new AuthenticationException("账号为空");
		}
		UserInfo user = userService.getUserByUserName(username);
		
		if(user == null){
			logger.warn("未找到相应用户");
			throw new AuthenticationException("未找到相应用户");
		}
		if(!user.getPasswd().equals(new String(usernamePwdToken.getPassword()))){
			logger.warn("用户密码错,用户输入密码：{}，数据库密码：{}",user.getPasswd(),new String(usernamePwdToken.getPassword()));
			throw new AuthenticationException("用户密码错");
		}
		logger.info("用户{}验证通过，允许登录。",username);
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute("userinfo", user);
		return new SimpleAuthenticationInfo(user,user.getPasswd(),getName());
	}
}
