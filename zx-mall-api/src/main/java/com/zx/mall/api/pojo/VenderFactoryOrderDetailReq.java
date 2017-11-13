package com.zx.mall.api.pojo;

public class VenderFactoryOrderDetailReq extends CommonReq {

	private static final long serialVersionUID = 7486738093132168496L;

	private Integer lid;
	private Integer olid;
	private Integer ptype;
	private String typename;
	private Integer plid;
	private String pname;
	private Float prices;
	private Integer amount;
	private Float total;
	private Integer operate; // 操作 1：新增；2：修改；3：删除

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public Integer getOlid() {
		return olid;
	}

	public void setOlid(Integer olid) {
		this.olid = olid;
	}

	public Integer getPtype() {
		return ptype;
	}

	public void setPtype(Integer ptype) {
		this.ptype = ptype;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Integer getPlid() {
		return plid;
	}

	public void setPlid(Integer plid) {
		this.plid = plid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Float getPrices() {
		return prices;
	}

	public void setPrices(Float prices) {
		this.prices = prices;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

}