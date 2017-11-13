package com.zx.mall.front.pojo;

import java.util.ArrayList;
import java.util.List;

public class OrderReq extends BaseReq {

	private Integer userId;	// 用户ID
	private String token;	// TOKEN
	private Long receiverId; // 收货地址ID
	private Integer totalCount; // 总共商品数量
	private Float totalPrice; // 总金额
	private List<OrderProductDetail> productList = new ArrayList<OrderProductDetail>();

	private String invoiceHeader; // 发票抬头
	private String taxpayerNum; // 纳税人识别号
	private String remark; // 备注
	
	private String orderNo;	// 订单编号，该参数主要给取消订单时用[查询订单明细也使用]
	private Integer status;	// 订单状态，该参数主要用于订单查询，默认查询所有订单状态订单
	private String startDate;	// 订单开始时间
	private String endDate;	// 订单结束时间
	private String keyword;	// 商品名称/商品编号/订单编号 搜索
	
	private Integer pageNo = 1; // 页码；不传默认1
	private Integer pageSize = 20; // 每页条数；不传默认20
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OrderProductDetail> getProductList() {
		return productList;
	}

	public void setProductList(List<OrderProductDetail> productList) {
		this.productList = productList;
	}

	public String getInvoiceHeader() {
		return invoiceHeader;
	}

	public void setInvoiceHeader(String invoiceHeader) {
		this.invoiceHeader = invoiceHeader;
	}

	public String getTaxpayerNum() {
		return taxpayerNum;
	}

	public void setTaxpayerNum(String taxpayerNum) {
		this.taxpayerNum = taxpayerNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
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