package com.zx.mall.api.pojo;

import java.util.List;

public class VenderProductKindCfgAttrReq2 extends CommonReq {

	private static final long serialVersionUID = -3177985024701955235L;

	private Integer kindId;
	private List<VenderProductKindCfgAttrVo> data;

	public Integer getKindId() {
		return kindId;
	}

	public void setKindId(Integer kindId) {
		this.kindId = kindId;
	}

	public List<VenderProductKindCfgAttrVo> getData() {
		return data;
	}

	public void setData(List<VenderProductKindCfgAttrVo> data) {
		this.data = data;
	}

}