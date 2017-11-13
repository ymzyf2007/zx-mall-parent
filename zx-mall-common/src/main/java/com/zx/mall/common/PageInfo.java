package com.zx.mall.common;

import java.util.List;

public class PageInfo<T> {
	private int page = 1;
	private int pageSize = 20;
	private int totalCount;
	private List<T> list;
	
	public PageInfo() {
	}
	
	public PageInfo(int page, int pageSize, int totalCount, List<T> list) {
		this.page = page;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.list = list;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}