package com.zx.mall.api.pojo;

import java.util.List;

public class VenderCategorySubjectTypeReq2 extends CommonReq {

	private static final long serialVersionUID = -7975714776136729196L;

	private Integer clid;	// 企业主键
	private Integer slid;	// 科目主键
	private String bcode;	// 科目编码
	private List<VenderCategorySubjectTypeReq> data;	// 科目对应的品类列表

	public Integer getClid() {
		return clid;
	}

	public void setClid(Integer clid) {
		this.clid = clid;
	}

	public Integer getSlid() {
		return slid;
	}

	public void setSlid(Integer slid) {
		this.slid = slid;
	}
	
	public String getBcode() {
		return bcode;
	}

	public void setBcode(String bcode) {
		this.bcode = bcode;
	}

	public List<VenderCategorySubjectTypeReq> getData() {
		return data;
	}

	public void setData(List<VenderCategorySubjectTypeReq> data) {
		this.data = data;
	}

}