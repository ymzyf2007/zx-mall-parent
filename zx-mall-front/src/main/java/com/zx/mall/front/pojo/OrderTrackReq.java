package com.zx.mall.front.pojo;

public class OrderTrackReq extends BaseReq {

	private Integer userId; // 用户ID
	private String token; // TOKEN
	private Integer type = 1; // 订单类型【1：主单，2：分单】
	private String orderNo; // 订单编号[查询主单订单轨迹传入这个]
	private String splitNo;	// 分单号[查询分单订单传入这个]

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getSplitNo() {
		return splitNo;
	}

	public void setSplitNo(String splitNo) {
		this.splitNo = splitNo;
	}
	
}