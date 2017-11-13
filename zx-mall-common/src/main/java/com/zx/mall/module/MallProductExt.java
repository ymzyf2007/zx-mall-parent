package com.zx.mall.module;

public class MallProductExt {
    private Long id;

    private String productSp;

    private Integer isRecommend;

    private String packing;

    private String assemService;

    private String productDetail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductSp() {
        return productSp;
    }

    public void setProductSp(String productSp) {
        this.productSp = productSp == null ? null : productSp.trim();
    }

    public Integer getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Integer isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing == null ? null : packing.trim();
    }

    public String getAssemService() {
        return assemService;
    }

    public void setAssemService(String assemService) {
        this.assemService = assemService == null ? null : assemService.trim();
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail == null ? null : productDetail.trim();
    }
}