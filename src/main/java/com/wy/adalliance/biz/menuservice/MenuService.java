package com.wy.adalliance.biz.menuservice;

import com.wy.adalliance.dal.mybatis.model.MenuInfo;



public interface MenuService {

	/**
	 * 获取菜单
	 * @return
	 */
	public abstract String getMenu();

	public abstract MenuInfo getNodeById(String menuId);

	public abstract boolean updateNodeById(MenuInfo menuInfo);

	public abstract String addNode(MenuInfo menuInfo);

	public abstract void deleteNodeById(String menuId) throws Exception;

}