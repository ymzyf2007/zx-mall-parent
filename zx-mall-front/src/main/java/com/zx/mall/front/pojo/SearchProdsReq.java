package com.zx.mall.front.pojo;

/**
 * 搜索商品请求入参
 * 
 */
public class SearchProdsReq extends BaseReq {

	private String keyword;
	private Integer pageNo = 1; // 页码；不传默认1
	private Integer pageSize = 20; // 每页条数；不传默认20

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

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