package com.mm.bbs.test;

import com.mm.bbs.util.HttpRequest;

public class wexiTest {
	
	public static void main(String[] args) {
		
//		https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID
		String appid = "wx4ac3fed7633c6c19";
        String appsecret = "50d888c5f66b32f718d13630da763d8e";
//        String access_token = "6_MIi_wdHHGK4rMpDPG-JbXFGgJl5EVa51PMNx2COM1xYs-zfzaqFFaXb3_2bvJ8Ydatipn7T1aUrMfdh2emoZG4PxA64kB6fNytmyeTXH1ic1JyjxWTLfvnlO9fmc7rTpVfm7dGGPrBOnr0BPTZTiADAMSM";
        String openid = "";
        String data = "{"+
                "\"touser\":\""+openid+"\","+
                "\"msgtype\":\"text\","+
                "\"text\":"+
                "{"+
                "\"content\":\""+"hello word"+"\""+
                "}"+
                "}";
        
        String access_token = HttpRequest.getAccessToken(appid, appsecret);
        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/typing?access_token="+access_token;
        
//		 HttpRequest.sendTemplateMessage(appid, appsecret, data);
 
        try {
			String response = HttpRequest.httpsRequest(url, "POST", data);
			System.out.println("响应信息"+response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
}
