package com.zx.mall.api.pojo;

public class VenderCategorySubjectTypeReq extends CommonReq {

	private static final long serialVersionUID = -265078992974862525L;

	private Integer ptype;	// 对应第三级品类ID
	private Integer operate = 1; // 操作 1：新增；2：修改；3：删除

	public Integer getPtype() {
		return ptype;
	}

	public void setPtype(Integer ptype) {
		this.ptype = ptype;
	}

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

}