package com.zx.mall.module.vo;

public class MallProductVo {

	private Long skuId;
	private Long code;
	private String pname; // 商品名称
	private Long kindId; // 商品分类ID
	private String kindName;
	private String displayName;
	private Integer stockamount;
	private Float price;
	private Integer status;
	private Integer recommend;
	private String uploadPicpath;
	private String spicPath;
	private String bpicPath;

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Long getKindId() {
		return kindId;
	}

	public void setKindId(Long kindId) {
		this.kindId = kindId;
	}

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Integer getStockamount() {
		return stockamount;
	}

	public void setStockamount(Integer stockamount) {
		this.stockamount = stockamount;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public String getUploadPicpath() {
		return uploadPicpath;
	}

	public void setUploadPicpath(String uploadPicpath) {
		this.uploadPicpath = uploadPicpath;
	}

	public String getSpicPath() {
		return spicPath;
	}

	public void setSpicPath(String spicPath) {
		this.spicPath = spicPath;
	}

	public String getBpicPath() {
		return bpicPath;
	}

	public void setBpicPath(String bpicPath) {
		this.bpicPath = bpicPath;
	}
	
}