package com.zx.mall.api.pojo;

public class VenderBudgetYearDetailReq extends CommonReq {

	private static final long serialVersionUID = -6158476817705572792L;

	private Integer lid;
	private Integer blid; // 预算登记主键
	private Integer slid; // 预算科目主键
	private Float amount; // 预算总额
	private Integer expenseamount; // 报销总额
	private Integer usefulamount; // 可用总额
	private Integer adjustamount; // 调整总额
	private String month; // 调整月份
	private String content; // 备注
	private Integer operate; // 操作 1：新增；2：修改；3：删除

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public Integer getBlid() {
		return blid;
	}

	public void setBlid(Integer blid) {
		this.blid = blid;
	}

	public Integer getSlid() {
		return slid;
	}

	public void setSlid(Integer slid) {
		this.slid = slid;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
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

	public Integer getAdjustamount() {
		return adjustamount;
	}

	public void setAdjustamount(Integer adjustamount) {
		this.adjustamount = adjustamount;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

}