package com.blossom.site.base.utils.security;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * @description md5加密
 * @author Blossom
 * @DateTime 2017/3/23 12:02
 */
public class Md5Utils {

	/**
	 * @description
	 * @author Blossom
	 * @DateTime 2017/3/23 12:02
	 * @param password 加密明文
	 */
	public static String getMd5(String password){
		String str = "";
		if(password !=null && !password.equals("")){
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				BASE64Encoder base = new BASE64Encoder();
				//加密后的字符串
				str = base.encode(md.digest(password.getBytes("utf-8")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return str;
	}
	public static void main(String[] args) {
		System.err.println(getMd5("root"));
	}
}
