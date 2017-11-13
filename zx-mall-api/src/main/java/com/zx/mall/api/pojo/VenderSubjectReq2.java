package com.zx.mall.api.pojo;

import java.util.List;

public class VenderSubjectReq2 extends CommonReq {

	private static final long serialVersionUID = 9053883887400390961L;

	private List<VenderSubjectReq> data;

	public List<VenderSubjectReq> getData() {
		return data;
	}

	public void setData(List<VenderSubjectReq> data) {
		this.data = data;
	}

}