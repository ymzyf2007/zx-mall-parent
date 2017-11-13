package com.zx.mall.admin.pojo;

public class SearchAdvertReq {

	private String keyword; // 关键词
	private String startTime; // 起始发布时间
	private String endTime; // 结束发布时间
	private String type; // 广告类型 1：轮播图；2：活动横条；3：首页遮罩屏
	private Integer status = 1; // 启用状态 不传查询所有状态
	private Integer pageNo = 1; // 页码，不传值默认1
	private Integer pageSize = 20; // 每页条数，不传值默认20

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

}