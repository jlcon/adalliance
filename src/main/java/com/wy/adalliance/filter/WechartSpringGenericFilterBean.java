/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 下午2:30:59 创建
 */
package com.wy.adalliance.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.GenericFilterBean;

import com.wy.adalliance.wechart.WeChart;
import com.wy.adalliance.wechart.beans.WeChartResult;
import com.wy.adalliance.wechart.beans.WeChartUserInfo;

/**
 * @Filename WechartSpringGenericFilterBean.java
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
public class WechartSpringGenericFilterBean extends GenericFilterBean{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
																								throws IOException,
																								ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		String code = request.getParameter("code");
		String getCodeUrl = null;
		WeChart weChart = new WeChart();
		HttpSession session = request.getSession();
		WeChartUserInfo weChartUserInfo = (WeChartUserInfo)session.getAttribute("weChartUserInfo");
		
		logger.debug("页面访问：code-{},userinfo:{}",code,weChartUserInfo);
		if(weChartUserInfo != null){
			chain.doFilter(arg0, arg1);
		}else if(StringUtils.isNotBlank(code)&&weChartUserInfo == null){
			logger.debug("获取访问token入参-code:{}",code);
			WeChartResult weChartResult = weChart.getWebAccessToken(code);
			logger.debug("获取访问token出参:{}",weChartResult);
			weChartUserInfo = weChart.getUserInfo(weChartResult.getAccessToken(), weChartResult.getOpenid());
			logger.debug("获取用户信息出参:{}",weChartUserInfo);
			session.setAttribute("weChartUserInfo", weChartUserInfo);
			chain.doFilter(arg0, arg1);
		} else {
			try {
				getCodeUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+weChart.appid+"&redirect_uri="+URLEncoder.encode(request.getRequestURL().toString(), "utf-8")+"&response_type=code&scope=snsapi_base#wechat_redirect";
			} catch (UnsupportedEncodingException e) {
				logger.error(e.getMessage(),e);
			}
			
			response.sendRedirect(getCodeUrl);
		}
	}
	
}
