package com.wy.adalliance.biz.menuservice.impl;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wy.adalliance.biz.menuservice.MenuService;
import com.wy.base.BaseSpringContextTest;

public class MenuServiceImplTest extends BaseSpringContextTest{
	
	@Autowired
	private MenuService menuService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void getMenuTest(){
		System.out.println(menuService.getMenu());
	}
}
