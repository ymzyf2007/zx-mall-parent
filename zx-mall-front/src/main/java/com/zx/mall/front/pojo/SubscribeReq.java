package com.zx.mall.front.pojo;

public class SubscribeReq extends BaseReq {

	private Long userId; // 用户ID
	private String token; // 用户token
	private Long skuId; // 收藏关注的商品ID
	
	private Integer pageNo = 1; // 页码；不传默认1
	private Integer pageSize = 20; // 每页条数；不传默认20

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
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