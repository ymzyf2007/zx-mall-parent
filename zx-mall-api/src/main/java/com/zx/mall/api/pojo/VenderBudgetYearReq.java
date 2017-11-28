package com.zx.mall.api.pojo;

public class VenderBudgetYearReq extends CommonReq {

	private static final long serialVersionUID = -846558062221074627L;

	private Integer lid;
	private String content; // 相关事宜描述，做什么事的计划之类的
	private String remark; // 备注
	private Integer applyid; // 申请用户ID
	private String applydate; // 申请日期，格式yyyy-MM-dd HH:mm:ss
	private Integer clid; // 企业主键
	private Integer applydlid; // 申请部门主键
	private String year; // 年份
	private Integer initamount; // 初始额度
	private Integer adjustamount; // 调整额度
	private Integer totalamount; // 预算总额
	private Integer expenseamount; // 报销总额
	private Integer usefulamount; // 可用总额
	private Integer operate; // 操作 1：新增；2：修改；3：删除

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
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

	public Integer getApplyid() {
		return applyid;
	}

	public void setApplyid(Integer applyid) {
		this.applyid = applyid;
	}

	public String getApplydate() {
		return applydate;
	}

	public void setApplydate(String applydate) {
		this.applydate = applydate;
	}

	public Integer getClid() {
		return clid;
	}

	public void setClid(Integer clid) {
		this.clid = clid;
	}

	public Integer getApplydlid() {
		return applydlid;
	}

	public void setApplydlid(Integer applydlid) {
		this.applydlid = applydlid;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getInitamount() {
		return initamount;
	}

	public void setInitamount(Integer initamount) {
		this.initamount = initamount;
	}

	public Integer getAdjustamount() {
		return adjustamount;
	}

	public void setAdjustamount(Integer adjustamount) {
		this.adjustamount = adjustamount;
	}

	public Integer getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(Integer totalamount) {
		this.totalamount = totalamount;
	}

	public Integer getExpenseamount() {
		return expenseamount;
	}

	public void setExpenseamount(Integer expenseamount) {
		this.expenseamount = expenseamount;
	}

	public Integer getUsefulamount() {
		return usefulamount;
	}

	public void setUsefulamount(Integer usefulamount) {
		this.usefulamount = usefulamount;
	}

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

}