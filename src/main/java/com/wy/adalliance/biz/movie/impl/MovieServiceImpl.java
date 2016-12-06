/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 下午2:37:32 创建
 */
package com.wy.adalliance.biz.movie.impl;

import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.wy.adalliance.biz.movie.bean.Movie;
import com.wy.adalliance.biz.movie.bean.MovieInfo;
import com.wy.adalliance.dal.mybatis.maps.SupermanMovieMapper;
import com.wy.adalliance.dal.mybatis.model.SupermanMovie;

/**
 * @Filename MovieServiceImpl.java
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
@Service
public class MovieServiceImpl {
	
	private MyMovie movie = new MyMovie();
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SupermanMovieMapper mapper;
	
	public boolean updateMovie2db(){
		List<Movie> baidumovie = null;
		try {
			baidumovie = movie.getMovieList();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			return false;
		}
		
		for(Movie tmp:baidumovie){
			SupermanMovie supermanMovie = new SupermanMovie();
			supermanMovie.setMovieName(tmp.getName());
			supermanMovie.setRowAddTime(Calendar.getInstance().getTime());
			
			MovieInfo movieInfo = movie.getMovieDetail(tmp.getUrl());
			
			supermanMovie.setMovieDescription(movieInfo.getDescription());
			supermanMovie.setMoviePicPath(movieInfo.getPic());
			supermanMovie.setMovieDirector(movieInfo.getDirector());
			
			try {
				mapper.insertSelective(supermanMovie);
			} catch (DuplicateKeyException e) {
				logger.warn("电影["+tmp+"]已经存在数据库中。");
			}
		}
		
		return true;
	}
}
