/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 上午11:07:01 创建
 */
package com.wy.adalliance.action.beans.cl;

import java.util.Date;

/**
 * @Filename OrderInfo.java
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
public class OrderInfo {
	
	private String orderId;
	private String orderNo;
	private Long amount;
	private String status;
	private Date rowAddTime;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRowAddTime() {
		return rowAddTime;
	}
	public void setRowAddTime(Date rowAddTime) {
		this.rowAddTime = rowAddTime;
	}
	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", orderNo=" + orderNo + ", amount=" + amount
				+ ", status=" + status + ", rowAddTime=" + rowAddTime + "]";
	}
}
