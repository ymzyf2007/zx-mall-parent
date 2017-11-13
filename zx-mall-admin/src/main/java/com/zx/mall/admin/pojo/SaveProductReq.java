package com.zx.mall.admin.pojo;

public class SaveProductReq {

	private Long pId; // 商品ID，无则新增；有则修改
	private Long code; // 商品编号
	private String name; // 商品名称
	private Float price; // 价格
	private Long kindId; // 商品分类ID
	private Integer recommend; // 是否推荐标识 1:是；0:否；
	private Integer stockamount; // 库存
	private Integer status; // 上下架状态
	private String spicPath;
	private String bpicPath;
	private String htmlPath;
	private String attrStr;
	private String accessoryService;
	
	private Long vSkuId;	// 对应订单系统的skuId，即商城需要绑定订单系统的商品ID

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getHtmlPath() {
		return htmlPath;
	}

	public void setHtmlPath(String htmlPath) {
		this.htmlPath = htmlPath;
	}

	public String getAttrStr() {
		return attrStr;
	}

	public void setAttrStr(String attrStr) {
		this.attrStr = attrStr;
	}

	public String getAccessoryService() {
		return accessoryService;
	}

	public void setAccessoryService(String accessoryService) {
		this.accessoryService = accessoryService;
	}

	public Long getvSkuId() {
		return vSkuId;
	}

	public void setvSkuId(Long vSkuId) {
		this.vSkuId = vSkuId;
	}
	
}