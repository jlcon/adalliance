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
import com.wy.adalliance.wechart.beans.WeChartCode;
import com.wy.adalliance.wechart.beans.WeChartResult;
import com.wy.adalliance.wechart.beans.WeChartUserInfo;

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
	//code通过客户端访问获取
	private String code = "031fDVNP1gRdD61sgXOP1TGQNP1fDVNs";
	
	private String openid = "o9sJHt1ZiuxwKmtYUEwQMTz0PSzg";
	private String access_token = "wjRataiL8BTSybtJQ-BWu8F4E-Hl76taLWf9Xw8Pxl-vECGSM1mtupJ8t2cfHZQIQQ4G2C4ZjN8WRTfZxG6xzKCNbS8E4tiJk_p9FZkjedc";
	private String refreshToken = "m6BdliA_QwejBDK3b9JuzOWL4XfHfuMA_XjQ6xXquHzUqtVhMalE9rH8AhLCliw_c3JStm5LHD2KZiWY_RvcBAIUqJ9SW-xEIoRWER1d4Ck";
	
	public void buildDefaultMenu(){
		System.out.println(weChart.buildDefaultMenu().toString());
	}
	
	public void getCode(){
		weChart.getCode("http://172.16.51.139/anon/wechart/hello.htm");
	}
	
	public void getToken(){
		System.out.println(weChart.getWebAccessToken(code));
	}
	
	public void refreshToken(){
		System.out.println(weChart.refreshToken(refreshToken));
	}
	
	@Test
	public void getUserInfo(){
		WeChartUserInfo weChartUserInfo = weChart.getUserInfo(access_token, openid);
		if(weChartUserInfo.getErrcode()==40001){
			WeChartResult weChartResult = weChart.refreshToken(refreshToken);
			weChartUserInfo = weChart.getUserInfo(weChartResult.getAccessToken(), openid);
			System.out.println("token超时，新获取token为："+weChartResult.getAccessToken());
		}
		System.out.println(weChartUserInfo);
	}
	
	public void WeChartCodeTest(){
		System.out.println(WeChartCode.getCode(-1));
	}
}
