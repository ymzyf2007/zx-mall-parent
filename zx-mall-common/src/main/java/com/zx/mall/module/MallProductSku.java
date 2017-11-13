package com.zx.mall.module;

import java.util.Date;

public class MallProductSku {
    private Long skuId;

    private String skuName;

    private Long productId;

    private Integer remainNum;

    private String price;

    private Integer status;

    private String attrStr;

    private Integer recommendNum;

    private Date createTime;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getRemainNum() {
        return remainNum;
    }

    public void setRemainNum(Integer remainNum) {
        this.remainNum = remainNum;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAttrStr() {
        return attrStr;
    }

    public void setAttrStr(String attrStr) {
        this.attrStr = attrStr == null ? null : attrStr.trim();
    }

    public Integer getRecommendNum() {
        return recommendNum;
    }

    public void setRecommendNum(Integer recommendNum) {
        this.recommendNum = recommendNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}