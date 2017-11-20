package com.zx.mall.api.pojo;

public class VenderProductKindBrandCfgReq extends CommonReq {

	private static final long serialVersionUID = -4585327731050449419L;

	private Integer bId;	// 品牌ID
	private String kindIds;	// 第三级品类ID，多个品类以逗号隔开

	public Integer getbId() {
		return bId;
	}

	public void setbId(Integer bId) {
		this.bId = bId;
	}

	public String getKindIds() {
		return kindIds;
	}

	public void setKindIds(String kindIds) {
		this.kindIds = kindIds;
	}

}