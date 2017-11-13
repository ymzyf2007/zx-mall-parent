package com.zx.mall.api.pojo;

public class VenderBudgetTypeSubjectReq extends CommonReq {

	private static final long serialVersionUID = -3996556100896168697L;

	private Integer lid;
	private Integer btype;
	private Integer slid;
	private Integer clid;
	private Integer dlid;
	private Integer status;
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

	public Integer getClid() {
		return clid;
	}

	public void setClid(Integer clid) {
		this.clid = clid;
	}

	public Integer getDlid() {
		return dlid;
	}

	public void setDlid(Integer dlid) {
		this.dlid = dlid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

}