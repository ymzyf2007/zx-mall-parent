package com.zx.mall.module;

public class VenderBudgetYear {
    private Integer lid;

    private Integer btype;

    private String content;

    private String remark;

    private Integer applyid;

    private String applydate;

    private Integer clid;

    private Integer applydlid;

    private String year;

    private Integer initamount;

    private Integer adjustamount;

    private Integer totalamount;

    private Integer expenseamount;

    private Integer usefulamount;

    private Integer status;

    private Integer operatorid;

    private String operatorname;

    private String operatortime;

    private Integer auditid;

    private String auditname;

    private String audittime;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getBtype() {
        return btype;
    }

    public void setBtype(Integer btype) {
        this.btype = btype;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        this.applydate = applydate == null ? null : applydate.trim();
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
        this.year = year == null ? null : year.trim();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(Integer operatorid) {
        this.operatorid = operatorid;
    }

    public String getOperatorname() {
        return operatorname;
    }

    public void setOperatorname(String operatorname) {
        this.operatorname = operatorname == null ? null : operatorname.trim();
    }

    public String getOperatortime() {
        return operatortime;
    }

    public void setOperatortime(String operatortime) {
        this.operatortime = operatortime == null ? null : operatortime.trim();
    }

    public Integer getAuditid() {
        return auditid;
    }

    public void setAuditid(Integer auditid) {
        this.auditid = auditid;
    }

    public String getAuditname() {
        return auditname;
    }

    public void setAuditname(String auditname) {
        this.auditname = auditname == null ? null : auditname.trim();
    }

    public String getAudittime() {
        return audittime;
    }

    public void setAudittime(String audittime) {
        this.audittime = audittime == null ? null : audittime.trim();
    }
}