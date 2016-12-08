/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 上午10:56:33 创建
 */
package com.wechart;

import org.junit.Test;

import com.wy.adalliance.wechart.WeChart;

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
	
	
	private static WeChart weChart = new WeChart();
	
	public void buildDefaultMenu(){
		System.out.println(weChart.buildDefaultMenu().toString());
	}
	
	@Test
	public void getCode(){
		weChart.getCode("http://172.16.51.139/anon/wechart/hello.htm");
	}
}
