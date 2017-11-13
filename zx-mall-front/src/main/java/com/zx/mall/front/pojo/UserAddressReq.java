package com.zx.mall.front.pojo;

public class UserAddressReq extends BaseReq {

	private String token;
	
	private Long receiverId;
	private Integer userId;
	private String receiveName;
	private String receiveMobile;
	private String receiveProvince;
	private String receiveCity;
	private String receiveArea;
	private String receiveAddress;
	private Integer defaultAddress = 0;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getReceiveMobile() {
		return receiveMobile;
	}

	public void setReceiveMobile(String receiveMobile) {
		this.receiveMobile = receiveMobile;
	}

	public String getReceiveProvince() {
		return receiveProvince;
	}

	public void setReceiveProvince(String receiveProvince) {
		this.receiveProvince = receiveProvince;
	}

	public String getReceiveCity() {
		return receiveCity;
	}

	public void setReceiveCity(String receiveCity) {
		this.receiveCity = receiveCity;
	}

	public String getReceiveArea() {
		return receiveArea;
	}

	public void setReceiveArea(String receiveArea) {
		this.receiveArea = receiveArea;
	}

	public String getReceiveAddress() {
		return receiveAddress;
	}

	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}

	public Integer getDefaultAddress() {
		return defaultAddress;
	}

	public void setDefaultAddress(Integer defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

}