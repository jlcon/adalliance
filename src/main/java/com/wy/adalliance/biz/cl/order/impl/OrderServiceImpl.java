/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 上午10:57:53 创建
 */
package com.wy.adalliance.biz.cl.order.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wy.adalliance.action.beans.cl.OrderInfo;
import com.wy.adalliance.beans.Pager;
import com.wy.adalliance.biz.cl.order.OrderService;
import com.wy.adalliance.dal.mybatis.maps.ClOrderInfoMapper;
import com.wy.adalliance.dal.mybatis.model.ClOrderInfo;
import com.wy.adalliance.dal.mybatis.model.ClOrderInfoExample;

/**
 * @Filename OrderServiceImpl.java
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
@Transactional(value="localdb")
public class OrderServiceImpl implements OrderService{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ClOrderInfoMapper ordermapper;
	
	/**
	 * 
	 * @Description:创建订单
	 * @param orderinfo
	 * @return
	 */
	@Override
	public boolean createOrder(OrderInfo orderinfo){
		logger.info("创建订单，入参：{}",orderinfo.toString());
		ClOrderInfo corderinfo = new ClOrderInfo();
		try {
			BeanUtils.copyProperties(corderinfo, orderinfo);
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage(),e);
			return false;
		} catch (InvocationTargetException e) {
			logger.error(e.getMessage(),e);
			return false;
		}
		if(ordermapper.insert(corderinfo)>0)
			return true;
		else
			return false;
	}
	
	/**
	 * 
	 * @Description:订单列表，暂无查询条件
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public Pager<ClOrderInfo> listOrder(int pageNum,int pageSize){
		Pager<ClOrderInfo> pager = new Pager<ClOrderInfo>();
		Page<ClOrderInfo> page = PageHelper.startPage(pageNum, pageSize);
		ClOrderInfoExample example = new ClOrderInfoExample();
		List<ClOrderInfo> dblist = ordermapper.selectByExample(example);
		
		pager.setData(dblist);
		pager.setPageNum(page.getPageNum());
		pager.setPageSize(page.getPageSize());
		pager.setTotalPage(page.getTotal());
		return pager;
	}
}
