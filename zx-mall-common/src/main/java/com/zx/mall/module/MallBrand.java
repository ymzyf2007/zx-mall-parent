package com.zx.mall.module;

import java.util.Date;

public class MallBrand {
    private Long brandId;

    private Long kindId;

    private String brandCnName;

    private String brandEnName;

    private String descr;

    private Integer brandStatus;

    private String brandUrl;

    private Date createTime;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getKindId() {
        return kindId;
    }

    public void setKindId(Long kindId) {
        this.kindId = kindId;
    }

    public String getBrandCnName() {
        return brandCnName;
    }

    public void setBrandCnName(String brandCnName) {
        this.brandCnName = brandCnName == null ? null : brandCnName.trim();
    }

    public String getBrandEnName() {
        return brandEnName;
    }

    public void setBrandEnName(String brandEnName) {
        this.brandEnName = brandEnName == null ? null : brandEnName.trim();
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public Integer getBrandStatus() {
        return brandStatus;
    }

    public void setBrandStatus(Integer brandStatus) {
        this.brandStatus = brandStatus;
    }

    public String getBrandUrl() {
        return brandUrl;
    }

    public void setBrandUrl(String brandUrl) {
        this.brandUrl = brandUrl == null ? null : brandUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}