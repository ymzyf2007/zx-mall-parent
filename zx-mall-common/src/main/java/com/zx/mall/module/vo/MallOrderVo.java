package com.zx.mall.module.vo;

import java.util.List;

import com.zx.mall.module.MallUserAddress;
import com.zx.mall.module.VenderFactoryOrder;
import com.zx.mall.module.VenderFactoryOrderDetail;

public class MallOrderVo {
	private Long userId; // 用户ID
	private String orderNo; // 订单编号
	private String orderDate; // 下单日期
	private Integer status; // 订单状态
	private String unit; // 商品单位
	private Integer purchaseNum; // 购买数量
	private Float totalPrice; // 购买价格
	private Long receiverId; // 收货地址ID
	private String invoiceHeader; // 发票抬头
	private String taxpayerNum; // 纳税人识别号
	private String remark; // 备注
	private List<MallOrderDetailVo> productList; // 商品列表
	
	private VenderFactoryOrder mainDeliveryOrder;	// 主配送单
	private List<VenderFactoryOrderDetail> deliveryOrders;	// 分单
	
	// 收货地址
	private MallUserAddress address;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getPurchaseNum() {
		return purchaseNum;
	}

	public void setPurchaseNum(Integer purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
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

	public List<MallOrderDetailVo> getProductList() {
		return productList;
	}

	public void setProductList(List<MallOrderDetailVo> productList) {
		this.productList = productList;
	}

	public VenderFactoryOrder getMainDeliveryOrder() {
		return mainDeliveryOrder;
	}

	public void setMainDeliveryOrder(VenderFactoryOrder mainDeliveryOrder) {
		this.mainDeliveryOrder = mainDeliveryOrder;
	}

	public List<VenderFactoryOrderDetail> getDeliveryOrders() {
		return deliveryOrders;
	}

	public void setDeliveryOrders(List<VenderFactoryOrderDetail> deliveryOrders) {
		this.deliveryOrders = deliveryOrders;
	}

	public MallUserAddress getAddress() {
		return address;
	}

	public void setAddress(MallUserAddress address) {
		this.address = address;
	}
	
}