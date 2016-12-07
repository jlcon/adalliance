/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 上午10:56:33 创建
 */
package com.wechart;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.wy.adalliance.wechart.WeChart;
import com.wy.adalliance.wechart.beans.WeChartResult;

/**
 * @Filename WechartTest.java
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
public class WechartTest {
	
	public static String token ;
	
	private static WeChart weChart = new WeChart();
	
	@BeforeClass
	public static void getToken(){
		WeChartResult weChartResult = weChart.getToken();
		token = weChartResult.getAccessToken();
		Assert.assertNotNull(token);
	}
	
	@Test
	public void buildDefaultMenu(){
		System.out.println(weChart.buildDefaultMenu(token).toString());
	}
}
