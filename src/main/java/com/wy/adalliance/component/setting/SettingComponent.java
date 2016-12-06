package com.wy.adalliance.component.setting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



/**
 * 系统设置组件
 * @author jlcon
 *
 */
@Component
public class SettingComponent {

	private final String default_config = "/spring/setting.properties";
	private HashMap<String, Properties> properties = new HashMap<String, Properties>();
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private static final HashMap<String, String> dbProperties  = new HashMap<String, String>();
	/** DB配置说明查询 */
	private static final HashMap<String, String> dbPropertiesIllustate  = new HashMap<String, String>();
	
	/**
	 * 获取默认配置名称集合
	 * @return
	 */
	public Set<String> getPropertyKey(){
		Properties p = getProperties();
		return p.stringPropertyNames();
	}
	
	/**
	 * 获取自定义配置集合
	 * @param path
	 * @return
	 */
	public Set<String> getPropertyKey(String path){
		Properties p = getProperties(path);
		return p.stringPropertyNames();
	}
	

	/**
	 * 设置默认配置
	 * @param key
	 * @param value
	 */
	public void setProperty(String key,String value){
		setProperty(key,value,default_config);
	}
	
	/**
	 * 根据指定配置文件设置配置
	 * @param key
	 * @param value
	 * @param path
	 */
	public void setProperty(String key,String value,String path){
		Properties p = getProperties(path);
		p.setProperty(key, value);
		saveProperties(p,path);
	}
	

	/**
	 * 删除默认属性
	 * @param key
	 */
	public void removeProperty(String key){
		Properties p = getProperties(default_config);
		p.remove(key);
		saveProperties(p,default_config);
	}
	
	/**
	 * 删除指定配置属性
	 * @param key
	 * @param path
	 */
	public void removeProperty(String key,String path){
		Properties p = getProperties(path);
		p.remove(key);
		saveProperties(p,path);
	}
	
	public String getProperty(String key){
		return getProperty(key,default_config);
	}
	
	public String getProperty(String key,String path){
		Properties p = getProperties(path);
		return p.getProperty(key);
	}
	
	/**
	 * 保存配置p到路径path
	 * @param p
	 * @param path
	 * @return 保存后的配置对象
	 */
	private Properties saveProperties(Properties p,String path){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String propertypath = SettingComponent.class.getResource(path).getPath();
		Writer writer = null;
		try {
			logger.info("配置文件保存在：{}",propertypath);
			writer = new FileWriter(new File(propertypath));
			p.store(writer, "Updated at time:" + format.format(Calendar.getInstance().getTime()));
	
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(writer!=null){
				try {
					writer.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		return p;
	}
	
	/**
	 * 获取默认文件配置
	 * @return 配置对象
	 */
	private Properties getProperties(){
		return getProperties(default_config);
	}
	
	/**
	 * 获取文件path配置
	 * 
	 * @param path
	 * @return 配置对象
	 */
	private Properties getProperties(String path){
		if(properties.get(path)==null){
			Properties p = new Properties();
			InputStream in = null;
			try {
				in = SettingComponent.class.getResourceAsStream(path);
				p.load(in);
				properties.put(path, p);
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(null != in){
							in.close() ;
					}
				} catch (IOException e) {
					logger.error("关闭输入错误e:{}",e);
				}
			}
			return p;
		} else {
			return properties.get(path);
		}
		
	}
	
	/**
	 * 刷新缓存
	 * 因为查询缓存时，如果未命中则加载配置，因此这儿只需要清空缓存即可
	 */
	public void reflesh(){
		clean();
	}

	/**
	 * 清空缓存
	 */
	private void clean() {
		
		properties.clear();
		dbProperties.clear();
		dbPropertiesIllustate.clear();
		
	}
	
}
