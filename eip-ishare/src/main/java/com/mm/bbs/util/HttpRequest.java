package com.mm.bbs.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;

import com.mm.bbs.wexi.WechatTemplate;

import net.sf.json.JSONObject;

public class HttpRequest {
	private static Logger log = Logger.getLogger(HttpRequest.class);
	 //HTTP请求
    public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) throws Exception  {
    	JSONObject jsonObject = null; 
      try { 
          URL url = new URL(requestUrl);    
          HttpURLConnection conn = (HttpURLConnection) url.openConnection();    
            
          conn.setDoOutput(true);    
          conn.setDoInput(true);    
          conn.setUseCaches(false);    
          // 设置请求方式（GET/POST）    
          conn.setRequestMethod(requestMethod);    
          conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");    
          // 当outputStr不为null时向输出流写数据    
          if (null != outputStr) {    
              OutputStream outputStream = conn.getOutputStream();    
              // 设置编码格式    
              outputStream.write(outputStr.getBytes("UTF-8"));    
              outputStream.close();    
          }    
          // 从输入流读取返回内容    
          InputStream inputStream = conn.getInputStream();    
          InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");    
          BufferedReader bufferedReader = new BufferedReader(inputStreamReader);    
          String str = null;  
          StringBuffer buffer = new StringBuffer();    
          while ((str = bufferedReader.readLine()) != null) {    
              buffer.append(str);    
          }    
          // 释放资源    
          bufferedReader.close();    
          inputStreamReader.close();    
          inputStream.close();    
          inputStream = null;    
          conn.disconnect(); 
          jsonObject = JSONObject.fromObject(buffer.toString());  
          return buffer.toString();    
      } catch (ConnectException ce) {    
          log.error("连接超时：",ce); 
          throw new Exception("连接超时");
      } catch (Exception e) {    
    	  log.error("https请求异常：",e);
    	  throw new Exception("https请求异常");
      }
    }
    
    
    public  static String sendTemplateMessage(String appid,String appsecret,String requestData){
    	   try {
    		   
               String access_token = HttpRequest.getAccessToken(appid, appsecret);
               System.out.println("access_token:"+access_token);
               //获取openId
               String response =  HttpRequest.sendOpenId(access_token, "");
               JSONObject object = JSONObject.fromObject(response);
               System.out.println("返回结果：{}"+object.toString());
               
               return object.toString();
           } catch (Exception e) {
               e.printStackTrace();
               return e.toString();
           }
    }
    
    /** 
     * 获得ACCESS_TOKEN 
     * @param appid 
     * @param secret 
     * @return ACCESS_TOKEN 
     */  
    public static String getAccessToken(String appid, String appsecret) {  
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+appsecret;
        JSONObject jsonObject = null;
		try {
			String request = HttpRequest.httpsRequest(url, "GET", null);
			
			jsonObject = JSONObject.fromObject(request.toString());
			System.out.println("响应值:"+jsonObject.toString());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
         
        return jsonObject.getString("access_token");  
    }  
    
    /**
     * 获取关注者openId
     * @Title: sendOpenId
     * @Description: TODO
     * @param access_token
     * @param msg
     * @return
     * @return: String
     */
    public static String sendOpenId(String access_token,String msg) {
//    	String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+access_token+"&next_openid="+2;
//    	String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+access_token;
    	
    	String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+access_token+"&next_openid=NEXT_OPENID";
    	
    	try {
			String responseData = HttpRequest.httpsRequest(url, "GET",null);
			System.out.println("获取openId列表"+responseData);
			return responseData;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.toString();
		}
    }
      
}

