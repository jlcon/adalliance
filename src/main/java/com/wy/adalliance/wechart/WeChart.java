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
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.wy.adalliance.wechart.beans.WeChartResult;
import com.wy.adalliance.wechart.beans.WeChartUserInfo;


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

	public String appid = "wxd7c999686574d0b9";
	public String appsecret = "5e7fecd478c066b286c803d91ac23b8e";
	public String gettoken = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+appsecret;
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
		System.out.println(WechatComunication.getCommond(getCodeUrl));
		return null;
	}
	
	/**
	 * @Description:获取web网页访问的token
	 * @param code
	 * @return
	 */
	public WeChartResult getWebAccessToken(String code){
		WeChartResult weChartResult = new WeChartResult();
		String getWebToken = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+appsecret+"&code="+code+"&grant_type=authorization_code";
		JSONObject object = JSONObject.parseObject(WechatComunication.sendCommond(getWebToken));
		weChartResult.setErrcode(object.getIntValue("errcode"));
		weChartResult.setErrmsg(object.getString("errmsg"));
		weChartResult.setAccessToken(object.getString("access_token"));
		weChartResult.setOpenid(object.getString("openid"));
		weChartResult.setRefreshToken(object.getString("refresh_token"));
		weChartResult.setExpiresIn(object.getIntValue("expires_in"));
		return weChartResult;
	}
	
	/**
	 * @Description: 刷新token
	 * @param refreshTokenCode
	 * @return
	 */
	public WeChartResult refreshToken(String refreshTokenCode){
		WeChartResult weChartResult = new WeChartResult();
		String refreshToken = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid="+appid+"&grant_type=refresh_token&refresh_token="+refreshTokenCode;
		JSONObject object = JSONObject.parseObject(WechatComunication.sendCommond(refreshToken));
		weChartResult.setErrcode(object.getIntValue("errcode"));
		weChartResult.setErrmsg(object.getString("errmsg"));
		weChartResult.setAccessToken(object.getString("access_token"));
		weChartResult.setOpenid(object.getString("openid"));
		weChartResult.setRefreshToken(object.getString("refresh_token"));
		weChartResult.setExpiresIn(object.getIntValue("expires_in"));
		return weChartResult;
	}
	
	/**
	 * @Description:通过 accessToken 和 openid 获取微信用户信息
	 * @param accessToken
	 * @param openid
	 * @return
	 */
	public WeChartUserInfo getUserInfo(String accessToken,String openid){
		String userinfostr = "https://api.weixin.qq.com/sns/userinfo?access_token="+accessToken+"&openid="+openid+"&lang=zh_CN";
		JSONObject object = JSONObject.parseObject(WechatComunication.getCommond(userinfostr));
		WeChartUserInfo weChartUserInfo = new WeChartUserInfo();
		weChartUserInfo.setCountry(object.getString("country"));
		weChartUserInfo.setProvince(object.getString("province"));
		weChartUserInfo.setCity(object.getString("city"));
		weChartUserInfo.setOpenid(object.getString("openid"));
		weChartUserInfo.setNickname(object.getString("nickname"));
		weChartUserInfo.setSex(object.getIntValue("sex"));
		weChartUserInfo.setHeadimgurl(object.getString("headimgurl"));
		weChartUserInfo.setLanguage(object.getString("language"));
		weChartUserInfo.setErrmsg(object.getString("errmsg"));
		weChartUserInfo.setErrcode(object.getIntValue("errcode"));
		if(object.getJSONArray("privilege")!=null){
			for(Iterator<Object> iter = object.getJSONArray("privilege").iterator();iter.hasNext();){
				weChartUserInfo.getPrivilege().add((String)iter.next());
			}
		}
		return weChartUserInfo;
	}
}
