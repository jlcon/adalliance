/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 下午1:49:06 创建
 */
package com.wy.adalliance.dingtalk;

import java.util.List;

/**
 * @Filename GetUsersIdResult.java
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
public class GetUsersInfoResult extends DingTalkResult{

	private List<DingUser> dingUsers;
	
	public List<DingUser> getDingUsers() {
		return dingUsers;
	}

	public void setDingUsers(List<DingUser> dingUsers) {
		this.dingUsers = dingUsers;
	}
	
	@Override
	public String toString() {
		return "GetUsersIdResult [uids=" + dingUsers + "] "+super.toString();
	}
}
