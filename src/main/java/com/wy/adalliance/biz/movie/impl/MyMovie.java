/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 下午2:51:36 创建
 */
package com.wy.adalliance.biz.movie.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wy.adalliance.biz.movie.bean.Movie;
import com.wy.adalliance.biz.movie.bean.MovieInfo;

/**
 * @Filename MyMovie.java
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
public class MyMovie {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public ArrayList<Movie> getMovieList() {
		ArrayList<Movie> movielist = new ArrayList<Movie>();
		Document document = null;
		try {
			document = Jsoup.connect("https://cq.nuomi.com/pcindex/main/filmlist?type=1").userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36").timeout(30000).ignoreHttpErrors(true).get();
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
			return null;
		}
		for(Iterator<Element> itor = document.select("a.item").iterator();itor.hasNext();){
			Element element = itor.next();
			Movie movie = new Movie();
			movie.setName(element.attr("title").replaceAll("\\s*", ""));
			movie.setUrl("https://cq.nuomi.com"+element.attr("href"));
			movielist.add(movie);
		}
		return movielist;
	}
	
	public MovieInfo getMovieDetail(String url){
		Document document = null;
		try {
			document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36").timeout(30000).ignoreHttpErrors(true).get();
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
			return null;
		}
		String title = document.select("div.content").select("h2").select("a").first().text().trim().replaceAll("\\s*", "");
		String pic = document.select("img.cinema-img").first().attr("src");
		
		Element infos = document.select("div.content").select("div.de").first();
		String introduce = infos.select("p.intro").select("span.c").first().text().trim();
		String director = infos.select("p").first().ownText();
		MovieInfo movieInfo = new MovieInfo();
		movieInfo.setDescription(introduce);
		movieInfo.setDirector(director);
		movieInfo.setName(title);
		movieInfo.setPic(pic);
		return movieInfo;
	}
	
	public Map<String,String> searchMovie(String moviename) {
		HashMap<String, String> pianyuan = new HashMap<String, String>();
		Document document = null;
		try {
			document = Jsoup.connect("http://pianyuan.net/search?q="+moviename)
					.cookie("PHPSESSID", "4frkqr7ubmj99uv2o0aqnc3m87")
					.cookie("py_loginauth", "WyJqbGNvbkBxcS5jb20iLDE0ODA5MDQ0NDYsIjVkNjBlMzlhNDBlZTBiMTEiXQ%3D%3D")
					.userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.87 Safari/537.36").timeout(30000).ignoreHttpErrors(true).get();
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
			return null;
		}
		for(Iterator<Element> itor = document.select("div.minfo").select("td.nobr").select("a").iterator();itor.hasNext();){
			Element infoele = itor.next();
			pianyuan.put(infoele.text(), infoele.attr("href"));
		}
		return pianyuan;
	}
}
