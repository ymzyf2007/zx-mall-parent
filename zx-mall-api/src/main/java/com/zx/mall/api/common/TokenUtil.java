package com.zx.mall.api.common;

public class TokenUtil {
	
	private TokenUtil() {
	}
	
	/**
	 * 获取token，测试阶段，写死token
	 * @return
	 */
	public static String getToken() {
		return "74b09b0f78154334aac2e57567e5ddf9"/*UUID.randomUUID().toString().replace("-", "")*/;
	}
	
	public static void main(String[] args) {
		System.out.println(getToken());
	}

}