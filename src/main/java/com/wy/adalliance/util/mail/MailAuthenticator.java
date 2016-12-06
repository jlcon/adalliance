/*
 * CHONGQING XYZ TECH CO.,LTD
 * Copyright (c) 2015 All Rights Reserved.
 */

/*
 * 修订记录：
 * jlcon 下午3:37:06 创建
 */
package com.wy.adalliance.util.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @Filename MailAuthenticator.java
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
public class MailAuthenticator extends Authenticator {
	/**
     * 用户名（登录邮箱）
     */
    private String username;
    /**
     * 密码
     */
    private String password;
  
    /**
     * 初始化邮箱和密码
     * 
     * @param username 邮箱
     * @param password 密码
     */
    public MailAuthenticator(String username, String password) {
    this.username = username;
    this.password = password;
    }
  
    String getPassword() {
    return password;
    }
  
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
    	return new PasswordAuthentication(username, password);
    }
  
    String getUsername() {
    return username;
    }
  
    public void setPassword(String password) {
    this.password = password;
    }
  
    public void setUsername(String username) {
    this.username = username;
    }
}
