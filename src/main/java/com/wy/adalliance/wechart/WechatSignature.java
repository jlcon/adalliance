package com.wy.adalliance.wechart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 微信签名验证
 * @author jlcon_000
 *
 */
@Controller
@RequestMapping("/anon/wechat")
public class WechatSignature {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/messagelistener")
	public void messagelistener(String signature,String timestamp,String nonce,String echostr,
			HttpServletResponse response,HttpServletRequest request) throws IOException{
		logger.info("微信验证入参：signature={}&timestamp={}&nonce={}&echostr={}",
				new Object[]{signature,timestamp,nonce,echostr});
		
		OutputStream os = response.getOutputStream();
		InputStream is = request.getInputStream();
		
		boolean isSuccess = false;
		
		if(StringUtils.isBlank(signature)||StringUtils.isBlank(timestamp)||
				StringUtils.isBlank(nonce)||StringUtils.isBlank(echostr)){
			
			os.write("false".getBytes());
			os.flush();
			os.close();
		}
		
		String[] arr = new String[] { "jlcon", timestamp, nonce };
		Arrays.sort(arr);
		
		StringBuilder content = new StringBuilder();  

        for (int i = 0; i < arr.length; i++) {  
            content.append(arr[i]);  
        }
        
        MessageDigest md = null;  
        String tmpStr = null;  

        try {  

            md = MessageDigest.getInstance("SHA-1");  
            // 将三个参数字符串拼接成一个字符串进行sha1加密  
            byte[] digest = md.digest(content.toString().getBytes());  
            tmpStr = byteToStr(digest);  

        } catch (NoSuchAlgorithmException e) {  

            e.printStackTrace();  

        }  

        content = null;  

        // 将sha1加密后的字符串可与signature对比，标识该请求来源于微信  

        isSuccess = tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false; 
        
        logger.info("微信签名验证结果：{}",isSuccess?"验证成功":"验证失败");
        
        String wechatmsg = InputStreamToString(is);
		logger.info("接收微信返回异步通知：\n\r{}",wechatmsg);
		
		if(isSuccess){
			os.write(echostr.getBytes());
		} else {
			os.write("false".getBytes());
		}
		os.flush();
		os.close();
	}
	
	
	/**
	 * 将字节数组转换为十六进制字符串 
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray) {  

        String strDigest = "";  

        for (int i = 0; i < byteArray.length; i++) {  
            strDigest += byteToHexStr(byteArray[i]);  
        }

        return strDigest;  

    }  
	
	/**
	 * 将字节转换为十六进制字符串 
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte) {  

        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };  
        char[] tempArr = new char[2];  

        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];  
        tempArr[1] = Digit[mByte & 0X0F];  

        String s = new String(tempArr);  

        return s;  

    }
	
	private String InputStreamToString(InputStream is) {
		StringBuilder sb = new StringBuilder();
		String readline = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			while ((readline = br.readLine()) != null) {
				sb.append(readline).append("\n");
			}
			br.close();
		} catch (IOException ie) {
			System.out.println("converts failed.");
		}
		return sb.toString();
	}
}
