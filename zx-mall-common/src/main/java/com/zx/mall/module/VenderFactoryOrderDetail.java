package com.zx.mall.module;

public class VenderFactoryOrderDetail {
    private Integer lid;

    private Integer olid;

    private Integer ptype;

    private String typename;

    private Integer plid;

    private String pname;

    private Float prices;

    private Integer amount;

    private Float total;
    
    private Integer status;

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
        this.typename = typename == null ? null : typename.trim();
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
        this.pname = pname == null ? null : pname.trim();
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
    
}