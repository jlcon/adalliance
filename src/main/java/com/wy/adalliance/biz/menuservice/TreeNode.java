package com.wy.adalliance.biz.menuservice;

import java.util.HashSet;
import java.util.Set;

public class TreeNode{

	private String menuId;
    /**code*/
    private String code;
    
    private String url;
    /**icon*/
    private String icon;
    /**leaf*/
    private String leaf;
    /**text*/
    private String text;
    /**admin.user*/
    private String type;
    
    private String system;
    
    private String expanded;
    
    private String parentId;
    
    private Set<TreeNode> children = new HashSet<TreeNode>();
    
    
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Set<TreeNode> getChildren() {
		return children;
	}
	public void setChildren(Set<TreeNode> children) {
		this.children = children;
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
	@Override
	public String toString() {
		return "TreeNode [menuId=" + menuId + ", code=" + code + ", url=" + url
				+ ", icon=" + icon + ", leaf=" + leaf + ", text=" + text
				+ ", type=" + type + ", expanded=" + expanded + ", parentId="
				+ parentId + ", children=" + children + "]";
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getLeaf() {
		return leaf;
	}
	public void setLeaf(String leaf) {
		this.leaf = leaf;
	}
	public String getExpanded() {
		return expanded;
	}
	public void setExpanded(String expanded) {
		this.expanded = expanded;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
}
