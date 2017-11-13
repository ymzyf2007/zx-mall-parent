package com.zx.mall.api.pojo;

import java.io.Serializable;

public class TokenReq implements Serializable {

	private static final long serialVersionUID = -8990567310672005729L;

	private String timestamp; // 当前调用时间，格式为"2017-09-01 01:01:01”
	private String appId; // 调用渠道ID
	private String password; // 正式环境密码需加密，请勿明文
	private String sign; // 签名 签名规则：appId+password+timestamp+password，字符串MD5加密后转为小写。

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}