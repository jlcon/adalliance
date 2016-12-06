/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 下午2:49:04 创建
 */
package com.movie;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wy.adalliance.biz.movie.impl.MovieServiceImpl;
import com.wy.adalliance.biz.movie.impl.MyMovie;
import com.wy.base.BaseSpringContextTest;

/**
 * @Filename MovieTest.java
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
public class MovieTest extends BaseSpringContextTest{
	@Autowired
	private MovieServiceImpl movieServiceImpl;
	
	public void updatemovie2db(){
		movieServiceImpl.updateMovie2db();
	}
	
	public void getMovieDetail(){
		MyMovie mm = new MyMovie();
		System.out.println(mm.getMovieDetail("https://cq.nuomi.com/film/63062"));
	}
	
	public void getMovieList(){
		MyMovie mm = new MyMovie();
		System.out.println(mm.getMovieList());
	}
	
	@Test
	public void searchMovie(){
		MyMovie mm = new MyMovie();
		System.out.println(mm.searchMovie("环太平洋"));
	}
}
