package com.zx.mall.interceptors;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class Request {
	private String requestURI;
	private Map<String, String> parameterMap;

	public Request() {
	}

	public Request(String requestURI) {
		this.requestURI = requestURI;
		parameterMap = new HashMap<String, String>();
	}

	public Request(String requestURI, Map<String, String> parameterMap) {
		this.requestURI = requestURI;
		this.parameterMap = parameterMap;
	}

	/**
	 * 获得指定名称的参数
	 * 
	 * @param name
	 * @return
	 */
	public String getParameter(String name) {
		String values = parameterMap.get(name);
		return values;
	}

	/**
	 * 获得所有的参数名称
	 * 
	 * @return
	 */
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(parameterMap.keySet());
	}

	/**
	 * 获得指定名称的参数值(多个)
	 * 
	 * @param name
	 * @return
	 */
	public String getParameterValues(String name) {
		return parameterMap.get(name);
	}

	/**
	 * 获得请求的url地址
	 * 
	 * @return
	 */
	public String getRequestURI() {
		return requestURI;
	}

	/**
	 * 获得 参数-值Map
	 * 
	 * @return
	 */
	public Map<String, String> getParameterMap() {
		return parameterMap;
	}

	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append("{");
		buf.append("\n  url = ").append(this.requestURI);
		buf.append("\n  paramsMap = {");
		if (this.parameterMap.size() > 0) {
			for (Map.Entry<String, String> e : this.parameterMap.entrySet()) {
				buf.append(e.getKey()).append("=").append(e.getValue()).append(",");
			}
			buf.deleteCharAt(buf.length() - 1);
		}
		buf.append("}\n}");
		return buf.toString();
	}

	public String getParamsJsonStr() {
		StringBuilder buf = new StringBuilder();
		buf.append("{");
		if (this.parameterMap.size() > 0) {
			for (Map.Entry<String, String> e : this.parameterMap.entrySet()) {
				buf.append(e.getKey()).append("=").append(e.getValue()).append(",");
			}
			buf.deleteCharAt(buf.length() - 1);
		}
		buf.append("}");
		return buf.toString();
	}
}