package com.wy.adalliance.action.wechart;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wy.adalliance.wechart.beans.WeChartUserInfo;

/**
 * @Filename HelloWechartAction.java
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
public class HelloWechartAction {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * @Description:访问地址为：http://172.16.51.139/anon/wechart/hello.htm
	 * @param code
	 * @return
	 */
	@RequestMapping("/anon/wechart/hello")
	public String toPage(HttpSession session,ModelMap map){
		WeChartUserInfo weChartUserInfo = (WeChartUserInfo)session.getAttribute("weChartUserInfo");
		map.put("name", weChartUserInfo.getNickname());
		map.put("openid", weChartUserInfo.getOpenid());
		map.put("country", weChartUserInfo.getCountry());
		map.put("province", weChartUserInfo.getProvince());
		map.put("city", weChartUserInfo.getCity());
		map.put("language", weChartUserInfo.getLanguage());
		map.put("sex", weChartUserInfo.getSex());
		map.put("headimgurl", weChartUserInfo.getHeadimgurl());
		logger.debug(weChartUserInfo.toString());
		return "/hellowechart";
	}
	
}