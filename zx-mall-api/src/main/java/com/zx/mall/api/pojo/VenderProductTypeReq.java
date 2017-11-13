package com.zx.mall.api.pojo;

public class VenderProductTypeReq extends CommonReq {
	private static final long serialVersionUID = -9197997481398272341L;
	private Long lid;
	private String cname; // 类别名称
	private Long plid; // 上级类别：其中-1表示无上级类别
	private String pname; // 上级类别名称
	private Integer tlevel; // 级别：1（一级分类）、2（二 级分类）、3（三级品类）
	private Integer operate;	// 操作  1：新增；2：修改；3：删除

	public Long getLid() {
		return lid;
	}

	public void setLid(Long lid) {
		this.lid = lid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Long getPlid() {
		return plid;
	}

	public void setPlid(Long plid) {
		this.plid = plid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getTlevel() {
		return tlevel;
	}

	public void setTlevel(Integer tlevel) {
		this.tlevel = tlevel;
	}

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}
	
}