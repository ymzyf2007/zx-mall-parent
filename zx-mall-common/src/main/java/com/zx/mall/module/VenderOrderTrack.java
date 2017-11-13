package com.zx.mall.module;

public class VenderOrderTrack {
    private Integer lid;

    private Integer type;

    private String ordernumber;

    private String splitno;

    private Integer status;

    private String content;

    private String operatorname;

    private String operatortime;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber == null ? null : ordernumber.trim();
    }

    public String getSplitno() {
        return splitno;
    }

    public void setSplitno(String splitno) {
        this.splitno = splitno == null ? null : splitno.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
}