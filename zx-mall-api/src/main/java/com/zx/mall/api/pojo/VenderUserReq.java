package com.zx.mall.api.pojo;

public class VenderUserReq extends CommonReq {

	private static final long serialVersionUID = -8026982367912402950L;

	private Integer lid;
	private String username;
	private String account;
	private String password;
	private String mobile;
	private String phone;
	private Integer dlid;
	private Integer clid;
	private Integer operate; // 操作 1：新增；2：修改；3：删除

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getDlid() {
		return dlid;
	}

	public void setDlid(Integer dlid) {
		this.dlid = dlid;
	}

	public Integer getClid() {
		return clid;
	}

	public void setClid(Integer clid) {
		this.clid = clid;
	}

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

}