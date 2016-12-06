/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 上午10:39:08 创建
 */
package com.wy.adalliance.action.thinksns.beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * @Filename QueryWeiboBean.java
 *
 * @Description:查询微博内容bean
 *
 * @Version 1.0
 *
 * @Author jlcon
 *
 * @Email jlcon@qq.com
 *
 */
public class QueryWeiboBean {
	
	private String timeStart;
	private String timeEnd;
	private String uname=null;
	private boolean check = false;
	private List<String> selectedNames = new ArrayList<String>();
	private int page = 0;
	
	//获取当前时间
	private Date currentDate = Calendar.getInstance().getTime();
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	public String getTimeStart() {
		if(StringUtils.isBlank(this.timeStart))
			return format.format(currentDate);
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeEnd() {
		if(StringUtils.isBlank(this.timeEnd))
			return format.format(currentDate);
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	public List<String> getSelectedNames() {
		return selectedNames;
	}
	public void setSelectedNames(List<String> selectedNames) {
		this.selectedNames = selectedNames;
	}
	@Override
	public String toString() {
		return "QueryWeiboBean [timeStart=" + timeStart + ", timeEnd=" + timeEnd + ", uname="
				+ uname + ", check=" + check + ", selectedNames=" + selectedNames + ", page="
				+ page + ", currentDate=" + currentDate + "]";
	}
}
