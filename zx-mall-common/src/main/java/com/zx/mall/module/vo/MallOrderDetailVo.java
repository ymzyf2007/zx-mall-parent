package com.zx.mall.module.vo;

public class MallOrderDetailVo {

	private String orderNo;
	private Long skuId;
	private String pname; // 商品名称
	private Long kindId; // 商品分类ID
	private String kindName;
	private String spicPath;
	private String bpicPath;
	private Float price; // 单价
	private Integer amount; // 购买数量
	private Float total; // 小计
	
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

}