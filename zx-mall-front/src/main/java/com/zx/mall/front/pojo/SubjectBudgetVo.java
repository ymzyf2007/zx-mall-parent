package com.zx.mall.front.pojo;

public class SubjectBudgetVo {

	private String subjectName; // 科目名称
	private Float budgetTotalAmount; // 科目年度预算
	private Float budgetUseAmount; // 科目年度已用预算

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Float getBudgetTotalAmount() {
		return budgetTotalAmount;
	}

	public void setBudgetTotalAmount(Float budgetTotalAmount) {
		this.budgetTotalAmount = budgetTotalAmount;
	}

	public Float getBudgetUseAmount() {
		return budgetUseAmount;
	}

	public void setBudgetUseAmount(Float budgetUseAmount) {
		this.budgetUseAmount = budgetUseAmount;
	}

}