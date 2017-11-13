package com.zx.mall.module;

import java.util.Date;

public class MallAttrValue {
    private Long attrValueId;

    private Long attrId;

    private String attrValue;

    private Date createTime;

    public Long getAttrValueId() {
        return attrValueId;
    }

    public void setAttrValueId(Long attrValueId) {
        this.attrValueId = attrValueId;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue == null ? null : attrValue.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}