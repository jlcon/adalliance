/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 下午2:25:37 创建
 */
package com.cl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.wy.adalliance.biz.thinksns.ThinkSNSService;
import com.wy.adalliance.dal.thinksns.maps.TsFeedDataMapper;
import com.wy.base.BaseSpringContextTest;

/**
 * @Filename ThinkSNSMultiple.java
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
public class ThinkSNSMultipleDateSourceTest extends BaseSpringContextTest{
	
	@Autowired
	private TsFeedDataMapper tsMapper;
	@Autowired
	private ThinkSNSService tinkService;
	
	@Test
	@Transactional(value="thinksns")
	public void queryWeiboByDateTest(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("timeStart", "2016-08-10");
		params.put("timeEnd", "2016-08-10");
		List<Map<String, String>> result = tsMapper.queryWeiboByDate(params);
		System.out.println(result.toString());
	}
	
	@Test
	@Transactional(value="thinksns")
	public void checkWeiboCurrentDayTest(){
		tinkService.checkWeiboCurrentDay();
	}
}
