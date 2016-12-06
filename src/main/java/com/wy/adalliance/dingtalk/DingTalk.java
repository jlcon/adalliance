/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 下午12:19:50 创建
 */
package com.wy.adalliance.dingtalk;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @Filename DingTalk.java
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
public class DingTalk {
	public static String token = "f8d8c1faf75e379892fed51225f4c259";
	private static DingTalkResult dingResult = new DingTalkResult();
	private static Logger logger = LoggerFactory.getLogger(DingTalk.class);
	
	/**
	 * 
	 * @Description: 发送通知
	 * @param toUser 员工id列表（消息接收者，多个接收者用|分隔）
	 * @param msg 通知内容
	 * @return 发送结果
	 */
	public static DingTalkResult notice(String toUser,String msg){
		if(token == null){
			token = Sender.getAccessToken();
		}
		String result = Sender.sendCommond("https://oapi.dingtalk.com/message/send?access_token="+token, "{\"agentid\":\"4436643\",\"touser\":\""+toUser+"\",\"msgtype\":\"text\",text:{content:\""+msg+"\"}}");
		JSONObject jobject = JSONObject.parseObject(result);
		if(jobject.getIntValue("errcode")==40014){
			token = Sender.getAccessToken();
			result = Sender.sendCommond("https://oapi.dingtalk.com/message/send?access_token="+token, "{\"agentid\":\"4436643\",\"touser\":\""+toUser+"\",\"msgtype\":\"text\",text:{content:\""+msg+"\"}}");
			jobject = JSONObject.parseObject(result);
		}
		if(jobject.getIntValue("errcode")==0){
			dingResult.setSuccess(true);
		} else {
			dingResult.setSuccess(false);
		}
		dingResult.setCode(jobject.getString("errcode"));
		dingResult.setMsg(jobject.getString("errmsg"));
		logger.info("钉钉发送通知 结果：{}",dingResult.toString());
		return dingResult;
	}
	
	/**
	 * 
	 * @Description: 根据微博用户信息获取钉钉用户信息
	 * @param unames 微博用户名 String
	 * @return 钉钉用户信息
	 */
	public static List<DingUser> getDingUserByWeiboName(List<String> unames){
		GetUsersInfoResult userInfoResult = Sender.getCompanyUsers(token);
		ArrayList<DingUser> dingUserList = new ArrayList<DingUser>();
		
		if (userInfoResult.getCode().equalsIgnoreCase("40014")) {
			token = Sender.getAccessToken();
			userInfoResult = Sender.getCompanyUsers(token);
		}
		if(userInfoResult.getCode().equals("0")){
			logger.debug("钉钉总用户：{}",userInfoResult.getDingUsers());
			for(int i = 0;i<unames.size();i++){
				String uname = unames.get(i);
				//微博姓名横划线分隔在下面处理
				String[] temp = uname.split("-");
				String realname;
				if(temp.length == 2){
					realname = temp[1].trim();
				} else if(temp.length == 1){
					//横线处理END
					//微博姓名下划线分隔在下面处理
					temp = uname.split("_");
					if(temp.length == 2){
						realname = temp[1].trim();
						//处理IOS和JAVA同名杨康
						if(realname.equalsIgnoreCase("杨康")){
							if(temp[0].trim().equalsIgnoreCase("IOS"))
								realname += "（IOS）";
						}
						//处理JAVA和市场郭靖同名问题
						if(realname.equalsIgnoreCase("郭靖")){
							realname += "(技术部）";
						}
						//处理JAVA和市场郭靖同名问题
						if(realname.equalsIgnoreCase("李昊")){
							realname = "李洪";
						}
					}
					 else{
						 logger.warn("微博用户[{}]未能获取成功真实姓名。",uname);
						 continue;
					 }
				} else {
					 logger.warn("微博用户[{}]未能获取成功真实姓名。",uname);
					 continue;
				}
				
				logger.info("获取微博用户名：{}、{}",i+1,realname);
				
				for(DingUser dingUser:userInfoResult.getDingUsers()){
					if(dingUser.getUsername().equalsIgnoreCase(realname)){
						dingUserList.add(dingUser);
						continue;
					}
				}
			}
			return dingUserList;
		}
		logger.error("获取钉钉用户数据失败：{}",userInfoResult.toString());
		return null;
	}
	
	/**
	 * @Description:
	 * @param args
	 */
	public static void main(String[] args) {
		DingTalk.notice("121726423818636276", "测试内容");
	}
	
}
