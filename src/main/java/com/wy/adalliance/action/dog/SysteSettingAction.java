/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 下午2:42:03 创建
 */
package com.wy.adalliance.action.dog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 *
 * @version 1.0
 *
 * @author jlcon
 *
 */
@Controller
@RequestMapping("setting")
public class SysteSettingAction {
	
	@RequestMapping("baseset")
	public String baseset(){
		return "/旺财狗/联盟设置/jbsz";
	}
	
	@RequestMapping("klsz")
	public String klsz(){
		return "/旺财狗/联盟设置/klsz";
	}
	
	@RequestMapping("fwqsz")
	public String fwqsz(){
		return "/旺财狗/联盟设置/fwqsz";
	}
	/**
	 * 
	 * @Description:邮箱设置
	 * @return
	 */
	@RequestMapping("yxsz")
	public String yxsz(){
		return "/旺财狗/联盟设置/yxsz";
	}
	
	/**
	 * 
	 * @Description:在线充值
	 * @return
	 */
	@RequestMapping("zxcz")
	public String zxcz(){
		return "/旺财狗/联盟设置/zxcz";
	}
	
	/**
	 * 
	 * @Description:财务相关
	 * @return
	 */
	@RequestMapping("cwxg")
	public String cwxg(){
		return "/旺财狗/联盟设置/cwxg";
	}
	
	/**
	 * 
	 * @Description:其他设置
	 * @return
	 */
	@RequestMapping("qtsz")
	public String qtsz(){
		return "/旺财狗/联盟设置/qtsz";
	}
}
