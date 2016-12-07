/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 上午11:17:41 创建
 */
package com.wy.adalliance.action.movie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Filename MovieAction.java
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
@Controller
@RequestMapping("/movie") 
public class MovieAction {
	
	@RequestMapping("/toPage")
	public String toPage(){
		return "movie/movie";
	}
	
	
}
