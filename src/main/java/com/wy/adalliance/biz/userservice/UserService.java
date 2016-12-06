package com.wy.adalliance.biz.userservice;

import java.util.List;

import com.wy.adalliance.dal.mybatis.model.UserInfo;

public interface UserService {

	/**
	 * @Description: 通过用户名获取用户信息，若没获取到或获取到多个用户信息都返回空值
	 * @param username: 用户名
	 * @return:用户信息
	 */
	public abstract UserInfo getUserByUserName(String username);

	/**
	 * @Description:通过用户ID获取资源列表
	 * @param userid
	 * @return
	 */
	public abstract List<String> getRolesByUserID(String userid);

	public abstract int addUser(UserInfo userinfo);
	
}
