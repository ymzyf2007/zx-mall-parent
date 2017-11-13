package com.zx.mall.common;

public class Constants {
	public static final String SERVER_PREFIX_URI = "http://39.108.149.156:8080/";
	public static final String PREFIX_URI = "http://39.108.149.156:8080/upload/upload/images/op/";
	
	public static final int SUCCESS_CODE = 200; // 成功 -通用
	public static final String SUCCESS_MSG = "success";
	
	public static final int FAIL_CODE = 500;	// 失败-通用
	public static final String FAIL_MSG = "fail";
	
	public static final int AUTHCODE_ERR = 5000;	// 无效验证码
	public static final String AUTHCODE_ERR_MSG = "无效的短信验证码!";
	
	public static final int INVAILD_MOBILE = 5001;	// 无效的手机号
	public static final String INVAILD_MOBILE_MSG = "无效的手机号码!";
	
	public static final int SMS_ERR_SEND = 5002;	// 短信发送失败
	public static final String SMS_ERR_SEND_MSG = "短信发送失败，请重试!";
	
	public static final int USER_EXIST_ERR = 5003;	// 用户已经存在
	public static final String USER_EXIST_ERR_MSG = "用户已经存在!";
	
	public static final int USER_NOTEXIST_ERR = 5004;	// 用户不存在
	public static final String USER_NOTEXIST_ERR_MSG = "用户不存在!";
	
	public static final int USER_UN_LOGIN = 5005;	// 失败-用户未登录
	public static final String USER_UN_LOGIN_MSG = "用户未登录!";
	
	public static final int REGISTER_FAIL = 5006;	// 用户注册失败
	public static final String REGISTER_FAIL_MSG = "用户注册失败!";
	
	public static final int USER_EXPIRE = 5007;	// 用户无效
	public static final String USER_EXPIRE_MSG = "用户无效!";
	
}