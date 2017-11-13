package com.zx.mall.front.pojo;

import java.util.List;

public class LoginReq {
	private String account;
	private String password;
	
	private Float totalAmount;	// 年度部门总预算
	private Float useAmount;	// 已用年度部门预算
	private List<SubjectBudgetVo> subjectBudgets;	// 科目预算列表

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Float getUseAmount() {
		return useAmount;
	}

	public void setUseAmount(Float useAmount) {
		this.useAmount = useAmount;
	}

	public List<SubjectBudgetVo> getSubjectBudgets() {
		return subjectBudgets;
	}

	public void setSubjectBudgets(List<SubjectBudgetVo> subjectBudgets) {
		this.subjectBudgets = subjectBudgets;
	}
	
}