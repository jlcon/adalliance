package com.wy.adalliance.wechart;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class WechatComunication {

	/**
	 * 微信操作命令发送
	 * @param url 微信命令接收地址
	 * @param commond 微信指令
	 * @return 执行结果
	 */
	public static String sendCommond(String url,String commond){
		
		CloseableHttpClient hc = HttpClients.createDefault();  
		
		HttpPost post = new HttpPost(url); 
		if(StringUtils.isNotBlank(commond)){
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
	
	public static String getCommandFromFile(String path){
		InputStream is = WechatComunication.class.getResourceAsStream(path);
		BufferedInputStream bis = new BufferedInputStream(is);
		byte[] cache = new byte[10];
		ArrayList<Byte> cache1 = new ArrayList<Byte>();
		try {
			int i = 0;
			while((i = bis.read(cache, 0, cache.length))!=-1){
				for(int j = 0;j<i;j++){
					cache1.add(cache[j]);
				}
			}
			byte[] c = new byte[cache1.size()];
			for(int ii = 0;ii<c.length;ii++){
				c[ii] = cache1.get(ii);
			}
			return new String(c);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		byte[] cache = new byte[1024];
//		ByteBuffer bb = ByteBuffer.allocate(cache.length);
//		for(int offset = 0,readed = 0; readed != -1; offset += readed){
//			try {
//				readed = is.read(cache, offset, cache.length);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			bb.put(cache);
//		}
//		return new String(bb.array());
		return null;
	}
	
	public static void main(String[] args) {
		String gettoken = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx145659715302f44f&secret=0d3a8a0c30388e9ef4286fe9708446a9";
		String addmenu = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=2-2OCPpOk6l8ShtJUF_togcQ3eJE7ckiEonqQ34AIVUKjwQXa7FL4JdB6GdtW8MIxlWaWZqmjNx_325I55erOqr-5ObOPPetZBreqDan7TXQq8S9BfP5LdgFVcCJNxQOMYOfAJAQCS";
		String getCode = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx46ea5801e420f10a&redirect_uri=http://fx.yijifu.net/anon/wechat/getUserOpenId.htm&response_type=code&scope=snsapi_base#wechat_redirect";
		System.out.println(WechatComunication.sendCommond(addmenu
//				,null));
				,WechatComunication.getCommandFromFile("/com/yjf/easyexchange/web/wechat/yjh/testbutton1")));
/*		try {
			System.out.println(URLEncoder.encode("http://fx.yijifu.net/anon/wechat/getUserOpenId.htm", "utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
