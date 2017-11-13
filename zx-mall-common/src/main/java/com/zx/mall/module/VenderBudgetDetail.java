package com.zx.mall.module;

public class VenderBudgetDetail {
    private Integer lid;

    private Integer blid;

    private Integer slid;

    private Integer bcode;

    private String sname;

    private Float amount;

    private Integer usefulamount;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getBlid() {
        return blid;
    }

    public void setBlid(Integer blid) {
        this.blid = blid;
    }

    public Integer getSlid() {
        return slid;
    }

    public void setSlid(Integer slid) {
        this.slid = slid;
    }

    public Integer getBcode() {
        return bcode;
    }

    public void setBcode(Integer bcode) {
        this.bcode = bcode;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getUsefulamount() {
        return usefulamount;
    }

    public void setUsefulamount(Integer usefulamount) {
        this.usefulamount = usefulamount;
    }
}