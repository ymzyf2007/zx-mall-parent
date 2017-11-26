package com.zx.mall.api.pojo;

public class VenderBudgetYearReq extends CommonReq {

	private static final long serialVersionUID = -846558062221074627L;

	private Long lid;
	private String content; // 相关事宜描述，做什么事的计划之类的
	private String remark; // 备注
	private Long applyid; // 申请用户ID
	private String applydate; // 申请日期，格式yyyy-MM-dd HH:mm:ss
	private Long clid; // 企业主键
	private Long applydlid; // 申请部门主键
	private String year; // 年份
	private Float initamount; // 初始额度
	private Float adjustamount; // 调整额度
	private Float totalamount; // 预算总额
	private Float expenseamount; // 报销总额
	private Float usefulamount; // 可用总额

	public Long getLid() {
		return lid;
	}

	public void setLid(Long lid) {
		this.lid = lid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getApplyid() {
		return applyid;
	}

	public void setApplyid(Long applyid) {
		this.applyid = applyid;
	}

	public String getApplydate() {
		return applydate;
	}

	public void setApplydate(String applydate) {
		this.applydate = applydate;
	}

	public Long getClid() {
		return clid;
	}

	public void setClid(Long clid) {
		this.clid = clid;
	}

	public Long getApplydlid() {
		return applydlid;
	}

	public void setApplydlid(Long applydlid) {
		this.applydlid = applydlid;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Float getInitamount() {
		return initamount;
	}

	public void setInitamount(Float initamount) {
		this.initamount = initamount;
	}

	public Float getAdjustamount() {
		return adjustamount;
	}

	public void setAdjustamount(Float adjustamount) {
		this.adjustamount = adjustamount;
	}

	public Float getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(Float totalamount) {
		this.totalamount = totalamount;
	}

	public Float getExpenseamount() {
		return expenseamount;
	}

	public void setExpenseamount(Float expenseamount) {
		this.expenseamount = expenseamount;
	}

	public Float getUsefulamount() {
		return usefulamount;
	}

	public void setUsefulamount(Float usefulamount) {
		this.usefulamount = usefulamount;
	}

}