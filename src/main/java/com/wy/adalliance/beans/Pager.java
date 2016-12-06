/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 上午11:20:13 创建
 */
package com.wy.adalliance.beans;

import java.util.List;

/**
 * @Filename Pager.java
 *
 * @Description:页面返回列表
 *
 * @Version 1.0
 *
 * @Author jlcon
 *
 * @Email 
 *
 */
public class Pager<T> {
	
	private List<T> data;
	private int pageSize;
	private int pageNum;
	private long totalPage;
	private boolean success = true;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	@Override
	public String toString() {
		return "Pager [data=" + data + ", pageSize=" + pageSize + ", pageNum=" + pageNum
				+ ", totalPage=" + totalPage + ", success=" + success + "]";
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
}
