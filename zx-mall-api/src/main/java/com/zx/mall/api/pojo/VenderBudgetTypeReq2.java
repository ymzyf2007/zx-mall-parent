package com.zx.mall.api.pojo;

import java.util.List;

public class VenderBudgetTypeReq2 extends CommonReq {

	private static final long serialVersionUID = -352125905609344146L;

	private List<VenderBudgetTypeReq> data;

	public List<VenderBudgetTypeReq> getData() {
		return data;
	}

	public void setData(List<VenderBudgetTypeReq> data) {
		this.data = data;
	}

}