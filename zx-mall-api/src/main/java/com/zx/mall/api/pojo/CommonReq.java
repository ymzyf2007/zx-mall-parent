package com.zx.mall.api.pojo;

import java.io.Serializable;

public class CommonReq implements Serializable {

	private static final long serialVersionUID = -3466033051837434325L;

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}