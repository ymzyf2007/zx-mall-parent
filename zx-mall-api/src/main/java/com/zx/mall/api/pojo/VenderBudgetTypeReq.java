package com.zx.mall.api.pojo;

public class VenderBudgetTypeReq extends CommonReq {

	private static final long serialVersionUID = 1575011234884141949L;

	private Integer lid;
	private String bname;
	private Integer operate; // 操作 1：新增；2：修改；3：删除

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

}