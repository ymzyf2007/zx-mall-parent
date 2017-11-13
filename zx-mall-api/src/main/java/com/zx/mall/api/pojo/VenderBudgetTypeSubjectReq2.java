package com.zx.mall.api.pojo;

import java.util.List;

public class VenderBudgetTypeSubjectReq2 extends CommonReq {

	private static final long serialVersionUID = 7876570678829314215L;

	private Integer btype;
	private List<VenderBudgetTypeSubjectReq> data;

	public Integer getBtype() {
		return btype;
	}

	public void setBtype(Integer btype) {
		this.btype = btype;
	}

	public List<VenderBudgetTypeSubjectReq> getData() {
		return data;
	}

	public void setData(List<VenderBudgetTypeSubjectReq> data) {
		this.data = data;
	}

}