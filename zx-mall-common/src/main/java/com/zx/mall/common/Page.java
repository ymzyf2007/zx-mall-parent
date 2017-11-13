package com.zx.mall.common;

public class Page {

	private int current;// 第几页
	private int pageSize;// 一页几条

	// SQL中用#{begin}获取
	public int getBegin() {
		int begin = (current - 1) * pageSize;
		return begin;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}