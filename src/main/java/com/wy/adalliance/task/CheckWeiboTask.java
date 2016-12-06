/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 上午11:13:58 创建
 */
package com.wy.adalliance.task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.wy.adalliance.biz.thinksns.ThinkSNSService;
import com.wy.adalliance.dingtalk.DingTalk;
import com.wy.adalliance.dingtalk.DingTalkResult;
import com.wy.adalliance.dingtalk.DingUser;
import com.wy.adalliance.dingtalk.Sender;

/**
 * @Filename MyTestServiceImpl.java
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
public class CheckWeiboTask {
	
	@Autowired
	private ThinkSNSService thinkService;
//	private SimpleMailSender mailSender = new SimpleMailSender("smtp.mxhichina.com", "tom@unknowntech.cn", "Jlcon123456");
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	
	@Scheduled(cron="0 25 17 ? * MON-FRI")
    public void checkWeiboTask(){
		Date date = Calendar.getInstance().getTime();
		List<Map<String, String>> list = thinkService.checkWeiboCurrentDay();
		List<String> sendlist = new ArrayList<String>();
		for(Map<String,String> result:list){
			String temp = result.get("name");
			if(StringUtils.isNotBlank(temp)){
				sendlist.add(temp.toLowerCase().trim());
			}
		}
		logger.info("发送提醒给：{}",sendlist);
		DingTalk.token = Sender.getAccessToken();
		//通过微博姓名获取钉钉用户信息
		List<DingUser> dingUsers = DingTalk.getDingUserByWeiboName(sendlist);
		StringBuilder successList = new StringBuilder();
		StringBuilder failList = new StringBuilder();
		
		for(int j=0;j<dingUsers.size();j++){
			DingUser tempUser = dingUsers.get(j);
			logger.info("发送钉钉用户：{}",j+"、"+tempUser.toString());
			DingTalkResult dingTalkResult =DingTalk.notice(tempUser.getUserid(), "["+format.format(date)+"]工作微博提醒：\n即将下班您还未提交工作微博。\n微博地址：http://172.16.81.64/index.php?app=public&mod=Index&act=index");
			if(dingTalkResult.getCode().equalsIgnoreCase("0")){
				successList.append(" "+tempUser.getUsername());
			} else {
				failList.append(" "+tempUser.getUsername());
			}
		}
		
		
		DingTalk.notice("121726423818636276", "["+format.format(date)+"]工作微博提醒：\n工作微博提醒已发送。发送给了："+successList.toString()+" "+dingUsers.size()+"位同学。" + (failList.length()>0?"发送失败："+failList.toString():""));
    }
}