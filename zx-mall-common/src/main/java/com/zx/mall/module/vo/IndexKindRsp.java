package com.zx.mall.module.vo;

import java.util.List;

/**
 * 栏目信息
 * 
 */
public class IndexKindRsp {

	private Long kindId;
	private String cnTitle;
	private String enTitle;
	private List<IndexKindProduct> products;
	
	public Long getKindId() {
		return kindId;
	}

	public void setKindId(Long kindId) {
		this.kindId = kindId;
	}

	public String getCnTitle() {
		return cnTitle;
	}

	public void setCnTitle(String cnTitle) {
		this.cnTitle = cnTitle;
	}

	public String getEnTitle() {
		return enTitle;
	}

	public void setEnTitle(String enTitle) {
		this.enTitle = enTitle;
	}

	public List<IndexKindProduct> getProducts() {
		return products;
	}

	public void setProducts(List<IndexKindProduct> products) {
		this.products = products;
	}

}