package com.zx.mall.front.pojo;

public class QryProdsReq extends BaseReq {

	private Long kindId;	// 商品分类
	private Long bId; // 品牌I;查全部不传值
	private Integer sortType = 1; // 综合排序方式 1:推荐;2:价格;3:购买过;默认按照推荐排序方式
	private Integer pageNo = 1; // 页码；不传默认1
	private Integer pageSize = 20; // 每页条数；不传默认20
	private String orderBy = "desc";
	
	public Long getKindId() {
		return kindId;
	}

	public void setKindId(Long kindId) {
		this.kindId = kindId;
	}

	public Long getbId() {
		return bId;
	}

	public void setbId(Long bId) {
		this.bId = bId;
	}

	public Integer getSortType() {
		return sortType;
	}

	public void setSortType(Integer sortType) {
		this.sortType = sortType;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
}