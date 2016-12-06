/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 下午5:02:34 创建
 */
package com.wy.adalliance.biz.thinksns;

import java.util.List;
import java.util.Map;

/**
 * @Filename ThinkSNSService.java
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
public interface ThinkSNSService {

	public abstract List<Map<String,String>> checkWeibo(String timeStart, String timeEnd);

	public abstract List<Map<String,String>> checkWeiboCurrentDay();
	
}
