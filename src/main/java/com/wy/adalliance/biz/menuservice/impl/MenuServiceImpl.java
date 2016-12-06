package com.wy.adalliance.biz.menuservice.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.wy.adalliance.biz.menuservice.MenuService;
import com.wy.adalliance.biz.menuservice.TreeNode;
import com.wy.adalliance.dal.mybatis.maps.MenuInfoMapper;
import com.wy.adalliance.dal.mybatis.model.MenuInfo;
import com.wy.adalliance.dal.mybatis.model.MenuInfoExample;

@Service
@Transactional(value="localdb")
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuInfoMapper menuInfoMapper;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public String getMenu(){
		MenuInfoExample menuInfoExample = new MenuInfoExample();
		List<MenuInfo> list = menuInfoMapper.selectByExample(menuInfoExample);
		return JSONArray.toJSONString(menuformat(list));
	}
	
	public List<TreeNode> menuformat(List<MenuInfo> list){
		
		List<TreeNode> rootnodes = new ArrayList<TreeNode>();
		
		for(MenuInfo nodedo:list){
			if(nodedo.getParentId() == null){
				TreeNode rootnode = new TreeNode();
				try {
					BeanUtils.copyProperties(rootnode, nodedo);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				rootnodes.add(nodebuild(rootnode,list));
			}
		}
		return rootnodes;
	}
	
	private TreeNode nodebuild(TreeNode pnode,List<MenuInfo> list){
		for(MenuInfo nodedo:list){
			if(nodedo.getParentId()!=null&&nodedo.getParentId().equals(pnode.getMenuId())){
				TreeNode node = new TreeNode();
				try {
					BeanUtils.copyProperties(node, nodedo);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
				pnode.getChildren().add(node);
				nodebuild(node,list);
			}
		}
		return pnode;
	}
	
	@Override
	public MenuInfo getNodeById(String menuId){
		return menuInfoMapper.selectByPrimaryKey(menuId);
	}
	
	@Override
	public boolean updateNodeById(MenuInfo menuInfo){
		if(menuInfoMapper.updateByPrimaryKey(menuInfo) != 1)
			return false;
		else
			return true;
	}
	
	@Override
	public String addNode(MenuInfo menuInfo){
		if(menuInfoMapper.insert(menuInfo)>0){
			return menuInfo.getMenuId();
		} else {
			return null;
		}
	}
	
	@Override
	public void deleteNodeById(String menuId) throws Exception{
		try {
			menuInfoMapper.deleteByPrimaryKey(menuId);
		} catch (Exception e) {
			throw e;
		}
	}
}
