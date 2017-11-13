package com.zx.mall.module;

public class MallProduct {
    private Long productId;

    private String productNo;

    private String productName;

    private Float price;

    private Long kindId;

    private Integer recommend;

    private Integer stockamount;

    private Integer status;

    private String attrStr;

    private String accessoryService;

    private String uploadPicpath;

    private String htmlPath;

    private String spicPath;

    private String bpicPath;

    private Integer originId;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getKindId() {
        return kindId;
    }

    public void setKindId(Long kindId) {
        this.kindId = kindId;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Integer getStockamount() {
        return stockamount;
    }

    public void setStockamount(Integer stockamount) {
        this.stockamount = stockamount;
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

    public String getAccessoryService() {
        return accessoryService;
    }

    public void setAccessoryService(String accessoryService) {
        this.accessoryService = accessoryService == null ? null : accessoryService.trim();
    }

    public String getUploadPicpath() {
        return uploadPicpath;
    }

    public void setUploadPicpath(String uploadPicpath) {
        this.uploadPicpath = uploadPicpath == null ? null : uploadPicpath.trim();
    }

    public String getHtmlPath() {
        return htmlPath;
    }

    public void setHtmlPath(String htmlPath) {
        this.htmlPath = htmlPath == null ? null : htmlPath.trim();
    }

    public String getSpicPath() {
        return spicPath;
    }

    public void setSpicPath(String spicPath) {
        this.spicPath = spicPath == null ? null : spicPath.trim();
    }

    public String getBpicPath() {
        return bpicPath;
    }

    public void setBpicPath(String bpicPath) {
        this.bpicPath = bpicPath == null ? null : bpicPath.trim();
    }

    public Integer getOriginId() {
        return originId;
    }

    public void setOriginId(Integer originId) {
        this.originId = originId;
    }
}