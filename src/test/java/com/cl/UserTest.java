/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 上午10:39:17 创建
 */
package com.cl;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wy.adalliance.biz.userservice.UserService;
import com.wy.adalliance.dal.mybatis.model.UserInfo;
import com.wy.base.BaseSpringContextTest;

/**
 * @Filename UserTest.java
 *
 * @Description:
 *
 * @Version 1.0
 *
 * @Author jlcon
 *
 * @Email 
 *
 */
public class UserTest extends BaseSpringContextTest{
	
	@Autowired
	private UserService userService;
	
	@Test
	public void addUserTest(){
		UserInfo userinfo = new UserInfo();
		userinfo.setNickName("jlcon");
		userinfo.setPasswd("123456");
		userinfo.setRowAddTime(Calendar.getInstance().getTime());
		userinfo.setUserName("jianglu");
		Assert.assertEquals(1, userService.addUser(userinfo)); ;
	}
}
