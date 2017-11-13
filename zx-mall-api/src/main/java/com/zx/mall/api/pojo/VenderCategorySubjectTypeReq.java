package com.zx.mall.api.pojo;

public class VenderCategorySubjectTypeReq extends CommonReq {

	private static final long serialVersionUID = -265078992974862525L;

	private Integer lid;
	private Integer btype;
	private Integer slid;
	private Integer ptype;
	private Integer operate; // 操作 1：新增；2：修改；3：删除

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public Integer getBtype() {
		return btype;
	}

	public void setBtype(Integer btype) {
		this.btype = btype;
	}

	public Integer getSlid() {
		return slid;
	}

	public void setSlid(Integer slid) {
		this.slid = slid;
	}

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