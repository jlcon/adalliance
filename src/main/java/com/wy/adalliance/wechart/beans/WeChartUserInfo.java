/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 上午11:42:56 创建
 */
package com.wy.adalliance.wechart.beans;

import java.util.HashSet;
import java.util.Set;

/**
 * @Filename WeChartUserInfo.java
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
public class WeChartUserInfo {
	
	private int errcode;
	private String errmsg;
	private String description;
	private String openid;
	private String country;
	private String province;
	private String city;
	private String nickname;
	private int sex = -1;
	private String headimgurl;
	private String language;
	private Set<String> privilege = new HashSet<String>();
	
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
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Set<String> getPrivilege() {
		return privilege;
	}
	public void setPrivilege(Set<String> privilege) {
		this.privilege = privilege;
	}
	@Override
	public String toString() {
		return "WeChartUserInfo [errcode=" + errcode + ", errmsg=" + errmsg + ", description="
				+ description + ", openid=" + openid + ", country=" + country + ", province="
				+ province + ", city=" + city + ", nickname=" + nickname + ", sex=" + sex
				+ ", headimgurl=" + headimgurl + ", language=" + language + ", privilege="
				+ privilege + "]";
	}
	public String getDescription() {
		return WeChartCode.getCode(errcode);
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
