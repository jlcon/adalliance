/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 下午3:53:18 创建
 */
package com.wy.adalliance.wechart.beans;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @Filename WeChartCode.java
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
public class WeChartCode {
	
	private static Properties p = new Properties();
	private static WeChartCode weChartCode = null;
	
	private WeChartCode(){
		try {
			p.load(new InputStreamReader(this.getClass().getResourceAsStream("/spring/wechartcode.properties"), "UTF-8"));  
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getCode(int errorCode){
		if(weChartCode == null)
			weChartCode = new WeChartCode();
		
		return (String)p.get(String.valueOf(errorCode));
	}
	
}
