package com.zx.mall.module;

public class VenderDepartment {
    private Integer lid;

    private Integer plid;

    private String code;

    private String cname;

    private String description;

    private Integer pricipallid;

    private String principalname;

    private String remark;

    private Integer clid;

    private Integer isdelete;

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
        this.code = code == null ? null : code.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
        this.principalname = principalname == null ? null : principalname.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getClid() {
        return clid;
    }

    public void setClid(Integer clid) {
        this.clid = clid;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}