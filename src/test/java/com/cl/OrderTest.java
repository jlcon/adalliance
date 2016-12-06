/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 上午11:30:11 创建
 */
package com.cl;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wy.adalliance.action.beans.cl.OrderInfo;
import com.wy.adalliance.beans.Pager;
import com.wy.adalliance.biz.cl.order.OrderService;
import com.wy.adalliance.dal.mybatis.model.ClOrderInfo;
import com.wy.base.BaseSpringContextTest;

/**
 * @Filename OrderTest.java
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
public class OrderTest extends BaseSpringContextTest{
	
	@Autowired
	private OrderService orderservice;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void createOrderTest(){
		OrderInfo orderinfo = new OrderInfo();
		
		orderinfo.setAmount(10000L);
		orderinfo.setOrderNo("10030293");
		orderinfo.setRowAddTime(Calendar.getInstance().getTime());
		orderinfo.setStatus("2222");
		
		boolean result = orderservice.createOrder(orderinfo);
		Assert.assertTrue(result);
	}
	
	@Test
	public void listOrderTest(){
		Pager<ClOrderInfo> pager = orderservice.listOrder(0, 8);
		logger.info(pager.toString());

		Assert.assertEquals(8, pager.getData().size());
		Assert.assertEquals(1, pager.getPageNum());
		Assert.assertEquals(8, pager.getPageSize());
	}
}
