package com.zx.mall.api.pojo;

import java.util.List;

public class VenderFactoryOrderReq extends CommonReq {

	private static final long serialVersionUID = -6467538870154425813L;

	private Integer lid;
	private Integer folid;
	private Integer status;

	private String ordernumber;

	private String ordertime;

	private String purchaser;

	private String purchasingunit;

	private String telephone;

	private String mobilephone;

	private String receivingarea;

	private String address;

	private String deliverytime;

	private String area;

	private Integer amount;

	private Float total;

	private Integer flid;

	private String fname;

	private String distributetime;

	private Integer distributelid;

	private String distributename;

	private String receivetime;

	private Integer receivelid;

	private String receivename;

	private String sendtime;

	private String installtime;

	private String finishtime;

	private Integer operate; // 操作 1：新增；2：修改；3：删除
	
	private List<VenderFactoryOrderDetailReq> data;

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public Integer getFolid() {
		return folid;
	}

	public void setFolid(Integer folid) {
		this.folid = folid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public String getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}

	public String getPurchasingunit() {
		return purchasingunit;
	}

	public void setPurchasingunit(String purchasingunit) {
		this.purchasingunit = purchasingunit;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getReceivingarea() {
		return receivingarea;
	}

	public void setReceivingarea(String receivingarea) {
		this.receivingarea = receivingarea;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeliverytime() {
		return deliverytime;
	}

	public void setDeliverytime(String deliverytime) {
		this.deliverytime = deliverytime;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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

	public Integer getFlid() {
		return flid;
	}

	public void setFlid(Integer flid) {
		this.flid = flid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getDistributetime() {
		return distributetime;
	}

	public void setDistributetime(String distributetime) {
		this.distributetime = distributetime;
	}

	public Integer getDistributelid() {
		return distributelid;
	}

	public void setDistributelid(Integer distributelid) {
		this.distributelid = distributelid;
	}

	public String getDistributename() {
		return distributename;
	}

	public void setDistributename(String distributename) {
		this.distributename = distributename;
	}

	public String getReceivetime() {
		return receivetime;
	}

	public void setReceivetime(String receivetime) {
		this.receivetime = receivetime;
	}

	public Integer getReceivelid() {
		return receivelid;
	}

	public void setReceivelid(Integer receivelid) {
		this.receivelid = receivelid;
	}

	public String getReceivename() {
		return receivename;
	}

	public void setReceivename(String receivename) {
		this.receivename = receivename;
	}

	public String getSendtime() {
		return sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public String getInstalltime() {
		return installtime;
	}

	public void setInstalltime(String installtime) {
		this.installtime = installtime;
	}

	public String getFinishtime() {
		return finishtime;
	}

	public void setFinishtime(String finishtime) {
		this.finishtime = finishtime;
	}

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

	public List<VenderFactoryOrderDetailReq> getData() {
		return data;
	}

	public void setData(List<VenderFactoryOrderDetailReq> data) {
		this.data = data;
	}
	
}