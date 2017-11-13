package com.zx.mall.api.pojo;

import com.zx.mall.module.VenderOrderTrack;

public class OrderStatusReq extends CommonReq {

	private static final long serialVersionUID = 6803441124557550633L;

	private String orderno; // 订单单号
	private Integer orderstatus; // 1:：待核对（接入时默认），2：已核对，3：已分单，4：已接单，5：已发货，6：已签收，7待安装，8：已完结
	private VenderOrderTrack record;	// 订单轨迹

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public Integer getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(Integer orderstatus) {
		this.orderstatus = orderstatus;
	}

	public VenderOrderTrack getRecord() {
		return record;
	}

	public void setRecord(VenderOrderTrack record) {
		this.record = record;
	}
	
}