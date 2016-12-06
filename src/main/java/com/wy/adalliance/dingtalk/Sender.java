/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 上午10:33:45 创建
 */
package com.wy.adalliance.dingtalk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @Filename Sender.java
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
public class Sender {
	
	/**
	 * 
	 * @Description: 发送POST请求
	 * @param url
	 * @param commond
	 * @return
	 */
	public static String sendCommond(String url,String commond){
		
		CloseableHttpClient hc = HttpClients.createDefault();  
		
		HttpPost post = new HttpPost(url); 
		post.setHeader("Content-Type","application/json");
		if(!StringUtils.isBlank(commond)){
			StringEntity params = new StringEntity(commond,"UTF-8");
			post.setEntity(params); 
		}
		
		try {
			
			org.apache.http.HttpResponse response = hc.execute(post);
			HttpEntity entity = response.getEntity();
			
			return EntityUtils.toString(entity);
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 
	 * @Description: 发送GET请求
	 * @param urlstr
	 * @return
	 */
	public static String sendGetCommond(String urlstr){
			
		try {
			URL url = new URL(urlstr);
			
			InputStream is = url.openStream();
			InputStreamReader reader = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(reader);
			StringBuffer sb = new StringBuffer();
			
			if(br.ready()){
				String temp = null;
				while((temp = br.readLine())!=null){
					sb.append(temp);
				}
			}
			
			reader.close();
			return sb.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @Description: 获取用户token 
	 * @return
	 */
	public static String getAccessToken(){
		try {
			URL url = new URL("https://oapi.dingtalk.com/gettoken?corpid=dingc3c79ca900eafeed&corpsecret=niHRMtx9VvhyyVq26IqkCa7udC9dABOC1CqGi3AWRy27nSJD6walBRhIsTEfCW5w");
			
			InputStream is = url.openStream();
			InputStreamReader reader = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(reader);
			StringBuffer sb = new StringBuffer();
			
			if(br.ready()){
				
				String temp = null;
				while((temp = br.readLine())!=null){
					sb.append(temp);
				}
			}
			
			reader.close();
			JSONObject jobject = JSONObject.parseObject(sb.toString());
			if(jobject.getIntValue("errcode") == 0){
				return jobject.getString("access_token");
			}else{
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @Description:根据钉钉用户手机号获取用户ID
	 * @param token
	 * @param phones
	 * @return
	 */
	@Deprecated
	public static GetUsersInfoResult getUsersId(String token,List<String> phones){
		JSONObject jobject = null;
		GetUsersInfoResult result = new GetUsersInfoResult();
		List<DingUser> users = new ArrayList<DingUser>();
		
		for(String phone:phones){
			String temp = Sender.sendGetCommond("https://oapi.dingtalk.com/user/get_by_mobile?access_token="+token+"&mobile="+phone);
			System.out.println(temp);
			jobject = JSONObject.parseObject(temp);
			
			if(jobject.getIntValue("errcode")!=0){
				result.setSuccess(false);
				result.setCode(String.valueOf(jobject.getIntValue("errcode")));
				result.setMsg(jobject.getString("errmsg"));
				return result;
			}
			
			DingUser user = new DingUser();
			user.setPhone("");
			user.setUserid("");
			user.setUsername("");
			
			users.add(user);
		}
		
		result.setSuccess(true);
		result.setCode("0");
		result.setMsg("success");
		result.setDingUsers(users);
		
		return result;
	}
	
	/**
	 * 获取公司员工信息
	 * @Description:
	 * @param token
	 * @return
	 */
	public static GetUsersInfoResult getCompanyUsers(String token){
		
		GetUsersInfoResult result = new GetUsersInfoResult();
		
		JSONObject jresult = JSONObject.parseObject(Sender.sendGetCommond("https://oapi.dingtalk.com/department/list?access_token="+token));
		List<DingUser> dingUserList = new ArrayList<DingUser>();
		if(jresult.getIntValue("errcode") == 0 ){
			JSONArray jarray = jresult.getJSONArray("department");
			for(Iterator<Object> jiter = jarray.iterator();jiter.hasNext();){
				JSONObject jobject = (JSONObject)jiter.next();
				JSONObject jur = JSONObject.parseObject(Sender.sendGetCommond("https://oapi.dingtalk.com/user/simplelist?access_token="+token+"&department_id="+jobject.getString("id")));
				if(jur.getIntValue("errcode") == 0){
					JSONArray userlist = jur.getJSONArray("userlist");
					for(Iterator<Object> userListIter = userlist.iterator();userListIter.hasNext();){
						JSONObject dingUser = (JSONObject)userListIter.next();
						
						DingUser duser = new DingUser();
						duser.setUserid(dingUser.getString("userid").trim());
						duser.setUsername(dingUser.getString("name").trim());
						
						dingUserList.add(duser);
					}
					
				}
			}
			result.setDingUsers(dingUserList);
			result.setSuccess(true);
			result.setCode("0");
			result.setMsg("获取用户列表成功");
		} else {
			result.setSuccess(false);
			result.setCode(jresult.getString("errcode"));
			result.setMsg(jresult.getString("errmsg"));
		}
		return result;
	}
	
	public static void main(String[] args) {
		String token = "f8d8c1faf75e379892fed51225f4c259";
		//技术部ID
		String techPartmentId = "2199527";
		DingTalk.notice("121726423818636276", "[2016/08/15]工作微博提醒：\n即将下班您还未提交工作微博。\n微博地址：http://172.16.81.64/index.php?app=public&mod=Index&act=index");
//		Sender.getCompanyUsers(token);
//		System.out.println(Sender.getAccessToken());
		
		
//		List<String> phones = new ArrayList<String>();
//		phones.add("15923325427");
		
		
//		System.out.println(Sender.getAccessToken());
//		Sender.getUsersId(token, phones);
		//获取部门信息
//		FormatUtil.printJson(Sender.sendGetCommond("https://oapi.dingtalk.com/department/list?access_token="+token));
		//获取部门人员信息
//		FormatUtil.printJson(Sender.sendGetCommond("https://oapi.dingtalk.com/user/simplelist?access_token="+token+"&department_id="+techPartmentId));
		//获取公司人员
//		System.out.println(Sender.getCompanyUsers(token).toString());
	}
}
