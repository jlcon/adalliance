/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 上午10:50:00 创建
 */
package com.wy.adalliance.wechart;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private static String accessToken = "GRBptfbKixXuHQZGQSMiW3fth2QUW1wZscI6Iwr0dkvE-czAcKjKEbnjru1-DznuOQ2bVPKAkC2DbqvG8HWkfEf_FW-6OEml4F3QYTv3ikOlZ297npzqlTcBD60peNXaQDYdABAMZU";
	
	private Logger logger = LoggerFactory.getLogger(WeChart.class);
	
	
	public WeChartResult getToken(){
		String result = WechatComunication.sendCommond(gettoken, null);
		WeChartResult weChartResult = new WeChartResult();
		JSONObject object = JSONObject.parseObject(result);
		weChartResult.setAccessToken(object.getString("access_token"));
		weChartResult.setExpiresIn(object.getIntValue("expires_in"));
		return weChartResult;
	}
	
	public WeChartResult buildDefaultMenu(){
		if(StringUtils.isBlank(accessToken)){
			accessToken = getToken().getAccessToken();
			logger.warn("access token 为空，重新获取token:{}",accessToken);
		}
		JSONObject object = JSONObject.parseObject(WechatComunication.sendCommond("https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+accessToken, WechatComunication.getCommandFromFile("/wechart/testbutton1")));
		System.out.println(object.toJSONString());
		WeChartResult weChartResult = new WeChartResult();
		weChartResult.setErrcode(object.getIntValue("errcode"));
		weChartResult.setErrmsg(object.getString("errmsg"));
		if(weChartResult.getErrcode()==42001){
			accessToken = getToken().getAccessToken();
			logger.warn("access token 超时，重新获取token:{}",accessToken);
			return buildDefaultMenu();
		}
		return weChartResult;
	}
	
	public WeChartResult getCode(String url){
		String getCodeUrl = null;
		WeChartResult weChartResult = new WeChartResult();
		try {
			getCodeUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid+"&redirect_uri="+URLEncoder.encode(url, "utf-8")+"&response_type=code&scope=snsapi_base#wechat_redirect";
			System.out.println(getCodeUrl);
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage(),e);
			weChartResult.setErrmsg(e.getMessage());
			weChartResult.setErrcode(-1);
			return weChartResult;
		}
//		JSONObject object = JSONObject.parseObject(WechatComunication.sendCommond(getCodeUrl, null));
		System.out.println(WechatComunication.sendCommond(getCodeUrl, null));
		return null;
	}
}
