package com.zx.mall.module;

public class VenderSubject {
    private Integer lid;

    private String bcode;

    private String cname;

    private Integer sort;

    private Integer plid;

    private Integer haschild;

    private String remark;

    private Integer isdelete;

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
        this.bcode = bcode == null ? null : bcode.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
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
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}