package com.zx.mall.api.pojo;

public class VenderDepartmentReq extends CommonReq {

	private static final long serialVersionUID = 7416215352204209077L;

	private Integer lid;
	private Integer plid;
	private String code;
	private String cname;
	private String description;
	private Integer pricipallid;
	private String principalname;
	private String remark;
	private Integer clid;
	private Integer operate; // 操作 1：新增；2：修改；3：删除

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public Integer getPlid() {
		return plid;
	}

	public void setPlid(Integer plid) {
		this.plid = plid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPricipallid() {
		return pricipallid;
	}

	public void setPricipallid(Integer pricipallid) {
		this.pricipallid = pricipallid;
	}

	public String getPrincipalname() {
		return principalname;
	}

	public void setPrincipalname(String principalname) {
		this.principalname = principalname;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getClid() {
		return clid;
	}

	public void setClid(Integer clid) {
		this.clid = clid;
	}

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

}