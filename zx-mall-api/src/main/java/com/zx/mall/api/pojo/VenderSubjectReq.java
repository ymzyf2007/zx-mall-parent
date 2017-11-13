package com.zx.mall.api.pojo;

public class VenderSubjectReq extends CommonReq {

	private static final long serialVersionUID = 4074678316475877890L;

	private Integer lid;
	private String bcode;
	private String cname;
	private Integer sort;
	private Integer plid;
	private Integer haschild;
	private String remark;
	private Integer operate; // 操作 1：新增；2：修改；3：删除

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public String getBcode() {
		return bcode;
	}

	public void setBcode(String bcode) {
		this.bcode = bcode;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getPlid() {
		return plid;
	}

	public void setPlid(Integer plid) {
		this.plid = plid;
	}

	public Integer getHaschild() {
		return haschild;
	}

	public void setHaschild(Integer haschild) {
		this.haschild = haschild;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

}