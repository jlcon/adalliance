/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 上午10:58:16 创建
 */
package com.wy.adalliance.biz.cl.order;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wy.adalliance.action.beans.cl.OrderInfo;
import com.wy.adalliance.beans.Pager;
import com.wy.adalliance.dal.mybatis.model.ClOrderInfo;
import com.wy.adalliance.dal.mybatis.model.ClOrderInfoExample;


/**
 * @Filename OrderService.java
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
public interface OrderService {

	public abstract Pager<ClOrderInfo> listOrder(int pageNum, int pageSize);

	public abstract boolean createOrder(OrderInfo orderinfo);
	
}
