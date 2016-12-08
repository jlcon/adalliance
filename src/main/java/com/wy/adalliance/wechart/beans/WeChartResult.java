/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 上午11:23:19 创建
 */
package com.wy.adalliance.wechart.beans;

/**
 * @Filename CmdResult.java
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
public class WeChartResult {
	
	private int errcode;
	private String errmsg;
	private String description;
	private int expiresIn;
	private String accessToken;
	private String openid;
	private String refreshToken;
	
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
		this.description = WeChartCode.getCode(errcode);
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	@Override
	public String toString() {
		return "WeChartResult [errcode=" + errcode + ", errmsg=" + errmsg + ", description="
				+ description + ", expiresIn=" + expiresIn + ", accessToken=" + accessToken
				+ ", openid=" + openid + ", refreshToken=" + refreshToken + "]";
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getDescription() {
		return WeChartCode.getCode(errcode);
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
