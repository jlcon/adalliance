/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 下午4:00:15 创建
 */
package com.wy.adalliance.util.mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

/**
 * @Filename Main.java
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
public class Main {
	
	/**
	 * @Description:
	 * @param args
	 */
	public static void main(String[] args) {
		SimpleMailSender sender = new SimpleMailSender("smtp.mxhichina.com", "tom@unknowntech.cn", "Jlcon123456");
		try {
			sender.send("jlcon@qq.com", "[2016/8/9]工作微博提醒", "hi：秦爽<br>今天的工作微博还未提交，请勿忘记");
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
}
