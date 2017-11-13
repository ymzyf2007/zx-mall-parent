package com.zx.mall.module;

import java.util.Date;

public class MallProductAttr {
    private Long productAttrId;

    private Long productId;

    private Long attrId;

    private Long attrValueId;

    private Long skuId;

    private Date createTime;

    public Long getProductAttrId() {
        return productAttrId;
    }

    public void setProductAttrId(Long productAttrId) {
        this.productAttrId = productAttrId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getAttrValueId() {
        return attrValueId;
    }

    public void setAttrValueId(Long attrValueId) {
        this.attrValueId = attrValueId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}