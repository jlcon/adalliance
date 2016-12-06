/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015-2016 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 下午2:45:21 创建
 */
package com.wy.adalliance.action.thinksns;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wy.adalliance.action.ExtAction;
import com.wy.adalliance.action.thinksns.beans.QueryWeiboBean;
import com.wy.adalliance.beans.Pager;
import com.wy.adalliance.dal.thinksns.maps.TsFeedDataMapper;

/**
 * @Filename ThinkSNSAction.java
 *
 * @Description:thinksns功能
 *
 * @Version 1.0
 *
 * @Author jlcon
 *
 * @Email 
 *
 */
@Controller
@RequestMapping("/thinksns")
public class ThinkSNSAction extends ExtAction{
	
	@Autowired
	private TsFeedDataMapper tsMapper;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 
	 * @Description:
	 * @return 查询页面路径
	 */
	@RequestMapping("/queryWeibo/toPage")
	public String queryWeiboPage(){
		return "thinksns/queryWeibo/queryWeibo";
	}
	
	/**
	 * 
	 * @Description:查询工作微博
	 * @param timeStart 微博开始时间
	 * @param timeEnd 微博截止时间
	 * @return json数据
	 */
	@RequestMapping("/queryWeibo/query")
	public String queryWeibo(QueryWeiboBean bean,ModelMap map){
		
		logger.debug("查询微博入参 {}",bean.toString());
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("timeStart", bean.getTimeStart());
		params.put("timeEnd", bean.getTimeEnd());
		params.put("selectedNames", bean.getSelectedNames());
		if(StringUtils.isNotBlank(bean.getUname())){
			params.put("theName", bean.getUname());
		}
		//带分页查询微博内容
		Page<Object> page = PageHelper.startPage(bean.getPage(), getPageSize());
		List<Map<String, String>> list = tsMapper.queryWeiboByDate(params);
		//封装页面Pager对象作页面返回数据
		Pager<Map<String,String>> pager = new Pager<Map<String,String>>();
		pager.setData(list);
		pager.setPageNum(bean.getPage());
		pager.setPageSize(getPageSize());
		pager.setTotalPage(page.getTotal());
		
		String result = JSONObject.toJSONString(pager);
		map.addAttribute("json", result);
		
		return "json";
	}
}