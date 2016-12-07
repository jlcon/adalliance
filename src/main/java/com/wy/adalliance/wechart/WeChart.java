/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 上午10:50:00 创建
 */
package com.wy.adalliance.wechart;

import com.alibaba.fastjson.JSONObject;
import com.wy.adalliance.wechart.beans.WeChartResult;


/**
 * @Filename WeChart.java
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
public class WeChart {

	String appid = "wxd7c999686574d0b9";
	String appsecret = "5e7fecd478c066b286c803d91ac23b8e";
	String gettoken = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+appsecret;
	
	
	public WeChartResult getToken(){
		String result = WechatComunication.sendCommond(gettoken, null);
		WeChartResult weChartResult = new WeChartResult();
		JSONObject object = JSONObject.parseObject(result);
		weChartResult.setAccessToken(object.getString("access_token"));
		weChartResult.setExpiresIn(object.getIntValue("expires_in"));
		return weChartResult;
	}
	
	public WeChartResult buildDefaultMenu(String token){
		JSONObject object = JSONObject.parseObject(WechatComunication.sendCommond("https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+token, WechatComunication.getCommandFromFile("/wechart/testbutton1")));
		WeChartResult weChartResult = new WeChartResult();
		weChartResult.setErrcode(object.getIntValue("errcode"));
		weChartResult.setErrmsg(object.getString("errmsg"));
		return weChartResult;
	}
}
