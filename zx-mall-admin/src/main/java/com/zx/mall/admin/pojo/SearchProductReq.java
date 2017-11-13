package com.zx.mall.admin.pojo;

public class SearchProductReq extends PageCommonReq {
	private Integer status = -1; // 上下架 1:上架；2:下架；-1:全部
	private Long kindId = -1L; // 商品分类ID -1:查询所有
	private Integer recommend = -1; // 是否推荐标识 1:是；0:否；-1：全部
	private String pname; // 商品名称，模糊查找

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

}