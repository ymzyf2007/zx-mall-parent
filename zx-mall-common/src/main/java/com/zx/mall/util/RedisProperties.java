package com.zx.mall.util;

import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 解析redis.properties配置文件
 *
 */
public class RedisProperties {

	private static Log log = LogFactory.getLog(RedisProperties.class);
	
	private static final String BUNDLE_NAME = "redis";
	
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	private RedisProperties() {
	}
	
	/**
	 * 根据key获取值，key不存在则返回null
	 * @param key
	 * @return
	 */
	public static String getValueFromConfig(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch(Exception e) {
			log.warn("读取配置文件出错：" + e.getMessage());
			return null;
		}
	}
	
}