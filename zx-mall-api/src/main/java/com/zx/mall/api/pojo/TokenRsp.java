package com.zx.mall.api.pojo;

import java.io.Serializable;

public class TokenRsp implements Serializable {

	private static final long serialVersionUID = -8831449357444295319L;

	private String access_token;
	private String expires_at;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getExpires_at() {
		return expires_at;
	}

	public void setExpires_at(String expires_at) {
		this.expires_at = expires_at;
	}

}