package com.wy.adalliance.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import com.alibaba.fastjson.JSON;
import com.wy.adalliance.beans.FormData;
import com.wy.adalliance.component.setting.SettingComponent;

public class ExtAction {
	
	@Autowired
	private SettingComponent settingComponent;
	
	private FormData fd = new FormData();
	
	protected int getPageSize(){
		String pageStrSize = settingComponent.getProperty("pageSize");
		return pageStrSize==null?30:Integer.parseInt(pageStrSize);
	}
	
	protected void initParams(ModelMap map){
		map.put("pageSize", getPageSize());
	}

	protected String buildForm(Object formdate,boolean isSuccess){
		
		fd.resetForm();
		fd.setData(formdate);
		fd.setSuccess(isSuccess);
		
		return JSON.toJSONString(fd);
	}
	
	protected String formFail(String errormsg){
		
		fd.resetForm();
		fd.setSuccess(false);
		fd.setErrorMessage(errormsg);
		
		return JSON.toJSONString(fd);
	}
	
	protected String formSuccess(String msg){
		
		fd.resetForm();
		fd.setSuccess(true);
		fd.setMsg(msg);
		
		return JSON.toJSONString(fd);
	}
	
	protected String formSuccess(){
		
		fd.resetForm();
		fd.setSuccess(true);
		
		return JSON.toJSONString(fd);
	}
}
