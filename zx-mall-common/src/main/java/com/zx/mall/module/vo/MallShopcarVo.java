package com.zx.mall.module.vo;

public class MallShopcarVo {

	private Long skuId;
	private String pname;
	private String displayname;
	private String pic;
	private Float price; // 商品单价
	private Integer quantity; // 购买数量
	private Integer stockamount;
	private String spicPath;
	private String bpicPath;

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

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getStockamount() {
		return stockamount;
	}

	public void setStockamount(Integer stockamount) {
		this.stockamount = stockamount;
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