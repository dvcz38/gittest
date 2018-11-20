package com.mm.bbs.util;



import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 加密
 * 
 * @author maojiajie
 *
 */
@SuppressWarnings("all")
public class CryptographyUtil {
	/**
	 * 采用Base64加密
	 * 
	 * @param str
	 * @return
	 */
	public static String encBase64(String str) {

		return Base64.encodeToString(str.getBytes());
	}

	/**
	 * 采用Base64解密
	 * 
	 * @param str
	 * @return
	 */
	public static String decBase64(String str) {

		return Base64.decodeToString(str.getBytes());
	}

	/**
	 * 采用MD5加密(没解码)
	 * 
	 * @param str
	 * @param salt
	 * @return
	 */
	public static String md5(String str, String salt) {
		
		System.out.println("管理者密码:"+new Md5Hash(str, salt).toString());

		return new Md5Hash(str, salt).toString();
	}
}
