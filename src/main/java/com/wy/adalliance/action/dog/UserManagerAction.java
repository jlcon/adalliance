/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 下午1:42:41 创建
 */
package com.wy.adalliance.action.dog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * 跳转页面有：
 * 	1、会员管理页面：/user/stationmaster.htm
 *
 * @version 1.0
 *
 * @author jlcon
 *
 */
@Controller
@RequestMapping("/user")
public class UserManagerAction {
	
	
	/**
	 * 跳转会员管理页面
	 * @Description:
	 * @return
	 */
	@RequestMapping("/stationmaster")
	public String toStationMasterPage(){
		
		
		return "/旺财狗/会员管理/zzgl";
	}
	
	/**
	 * 跳转广告商管理页面
	 * @Description:
	 * @return
	 */
	@RequestMapping("/advertiser")
	public String toAdvertiserPage(){
		
		
		return "/旺财狗/会员管理/ggsgl";
	}
	
	/**
	 * 跳转客服管理页面
	 * @Description:
	 * @return
	 */
	@RequestMapping("/customerservice")
	public String toCustomerServicePage(){
		
		return "/旺财狗/会员管理/kfgl";
	}
	
	/**
	 * 跳转商务管理页面
	 * @Description:
	 * @return
	 */
	@RequestMapping("/bizer")
	public String toBizerPage(){
		
		return "/旺财狗/会员管理/swgl";
	}
	
	/**
	 * 跳转站长用户组页面
	 * @Description:
	 * @return
	 */
	@RequestMapping("/managergroup")
	public String toManagerGroupPage(){
		
		return "/旺财狗/会员管理/zzyhz";
	}
}
