package com.zx.mall.api.pojo;

import java.util.List;

public class VenderCategorySubjectTypeReq2 extends CommonReq {

	private static final long serialVersionUID = -7975714776136729196L;

	private Integer btype;

	private List<VenderCategorySubjectTypeReq> data;

	public Integer getBtype() {
		return btype;
	}

	public void setBtype(Integer btype) {
		this.btype = btype;
	}

	public List<VenderCategorySubjectTypeReq> getData() {
		return data;
	}

	public void setData(List<VenderCategorySubjectTypeReq> data) {
		this.data = data;
	}

}