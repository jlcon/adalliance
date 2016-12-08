package com.wy.adalliance.action.wechart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/anon/wechart/hello")
	public String toPage(){
		logger.info("hello wechart");
		return "/hellowechart";
	}
	
}