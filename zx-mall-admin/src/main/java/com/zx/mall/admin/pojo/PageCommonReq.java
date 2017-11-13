package com.zx.mall.admin.pojo;

public class PageCommonReq {

	private Integer pageNo = 1; // 页码，不传值默认1
	private Integer pageSize = 20; // 每页条数，不传值默认20

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}