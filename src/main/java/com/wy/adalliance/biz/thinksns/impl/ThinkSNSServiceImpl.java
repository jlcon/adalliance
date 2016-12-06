/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 下午5:00:14 创建
 */
package com.wy.adalliance.biz.thinksns.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wy.adalliance.biz.thinksns.ThinkSNSService;
import com.wy.adalliance.dal.thinksns.maps.TsFeedDataMapper;

/**
 * @Filename ThinkSNSServiceImpl.java
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
@Service
public class ThinkSNSServiceImpl implements ThinkSNSService{
	@Autowired
	private TsFeedDataMapper tsMapper;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	
	
	@Override
	public List<Map<String,String>> checkWeiboCurrentDay(){
		return checkWeibo(null,null);
	}
	
	@Override
	public List<Map<String,String>> checkWeibo(String timeStart, String timeEnd){
		logger.debug("查询未写微博同学入参：{},{}",timeStart,timeEnd);
		Date date = Calendar.getInstance().getTime();
		//参赛如果为空设置默认当天
		if (StringUtils.isBlank(timeStart)) {
			timeStart = dateformat.format(date);
		}
		if (StringUtils.isBlank(timeEnd)) {
			timeEnd = dateformat.format(date);
		}
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("timeStart", timeStart);
		params.put("timeEnd", timeEnd);
		params.put("check", "true");
		List<Map<String,String>> list = tsMapper.queryWeiboByDate(params);
		logger.debug("查询未写微博同学结果列表：{}",list);
		return list;
	}
}
