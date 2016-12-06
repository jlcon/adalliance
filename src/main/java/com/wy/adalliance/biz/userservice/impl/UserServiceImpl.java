package com.wy.adalliance.biz.userservice.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wy.adalliance.biz.userservice.UserService;
import com.wy.adalliance.dal.mybatis.maps.UserInfoMapper;
import com.wy.adalliance.dal.mybatis.model.UserInfo;
import com.wy.adalliance.dal.mybatis.model.UserInfoExample;

@Service
@Transactional(value="localdb")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * @Description: 通过用户名获取用户信息，若没获取到或获取到多个用户信息都返回空值
	 * @param username: 用户名
	 * @return:用户信息
	 */
	@Override
	public UserInfo getUserByUserName(String username){
		UserInfoExample userInfoExample = new UserInfoExample();
		userInfoExample.or().andUserNameEqualTo(username);
		List<UserInfo> userinfos = null;
		try {
			userinfos = userInfoMapper.selectByExample(userInfoExample);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(userinfos.size() != 1){
			logger.error("用户数量异常，找到{}个用户。",userinfos.size());
			return null;
		}
		
		UserInfo userInfo = userinfos.get(0);
		
		return userInfo;
	}
	
	/**
	 * @Description:通过用户ID获取资源列表
	 * @param userid
	 * @return
	 */
	@Override
	public List<String> getRolesByUserID(String userid){
		List<HashMap<String, Object>> list = userInfoMapper.getRolesByUserID(userid);
		List<String> list1 = new ArrayList<String>();
		
		list.forEach(hashmap->{
			list1.add((String)hashmap.get("resource"));
		});
		
		return list1;
	}
	
	@Override
	public int addUser(UserInfo userinfo){
		return userInfoMapper.insert(userinfo);
	}
}
