package com.zx.mall.module;

import java.util.Date;

public class MallOrder {
    private Long id;

    private Long userId;

    private String orderNo;

    private Date orderDate;

    private Integer orderStatus;

    private String orderUnit;

    private String unitProperty;

    private Integer purchaseNum;

    private Float totalPrice;

    private String buyer;

    private String orderNote;

    private String handleOper;

    private Long receiverId;
    
    private String invoiceHeader; // 发票抬头
	private String taxpayerNum; // 纳税人识别号
	private String remark; // 备注

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderUnit() {
        return orderUnit;
    }

    public void setOrderUnit(String orderUnit) {
        this.orderUnit = orderUnit == null ? null : orderUnit.trim();
    }

    public String getUnitProperty() {
        return unitProperty;
    }

    public void setUnitProperty(String unitProperty) {
        this.unitProperty = unitProperty == null ? null : unitProperty.trim();
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

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer == null ? null : buyer.trim();
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote == null ? null : orderNote.trim();
    }

    public String getHandleOper() {
        return handleOper;
    }

    public void setHandleOper(String handleOper) {
        this.handleOper = handleOper == null ? null : handleOper.trim();
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
    
}