/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 下午4:08:34 创建
 */
package com.wy.adalliance.action.manager.menu.beans;

import java.io.Serializable;

/**
 * @Filename TreeNode.java
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
public class TreeNode implements Serializable{
	private static final long serialVersionUID = 2716853281173128423L;
	private String menuId;
	/**
	 * @mbggenerated
	 */
	private String text;
	/**
	 * @mbggenerated
	 */
	private String parentId;
	/**
	 * @mbggenerated
	 */
	private boolean expanded;
	/**
	 * @mbggenerated
	 */
	private String code;
	/**
	 * @mbggenerated
	 */
	private String url;
	/**
	 * @mbggenerated
	 */
	private String leaf;
	/**
	 * @mbggenerated
	 */
	private String system;
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLeaf() {
		return leaf;
	}
	public void setLeaf(String leaf) {
		this.leaf = leaf;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
}
