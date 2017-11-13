package com.zx.mall.module;

public class VenderProductKindAttr {
    private Integer attrId;

    private Integer attrTypeId;

    private String attrName;

    private Integer issearch;

    private String attrDesc;

    private Integer ismoney;

    private Integer datatype;

    private Integer maxlength;

    private Integer isRequired;

    private Integer isOnly;

    private String defaultvalue;

    private Integer infotype;

    private Integer validatetype;

    private Integer inputmode;

    private String inputvalue;

    private String inputprompt;

    private Integer status;

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public Integer getAttrTypeId() {
        return attrTypeId;
    }

    public void setAttrTypeId(Integer attrTypeId) {
        this.attrTypeId = attrTypeId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    public Integer getIssearch() {
        return issearch;
    }

    public void setIssearch(Integer issearch) {
        this.issearch = issearch;
    }

    public String getAttrDesc() {
        return attrDesc;
    }

    public void setAttrDesc(String attrDesc) {
        this.attrDesc = attrDesc == null ? null : attrDesc.trim();
    }

    public Integer getIsmoney() {
        return ismoney;
    }

    public void setIsmoney(Integer ismoney) {
        this.ismoney = ismoney;
    }

    public Integer getDatatype() {
        return datatype;
    }

    public void setDatatype(Integer datatype) {
        this.datatype = datatype;
    }

    public Integer getMaxlength() {
        return maxlength;
    }

    public void setMaxlength(Integer maxlength) {
        this.maxlength = maxlength;
    }

    public Integer getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Integer isRequired) {
        this.isRequired = isRequired;
    }

    public Integer getIsOnly() {
        return isOnly;
    }

    public void setIsOnly(Integer isOnly) {
        this.isOnly = isOnly;
    }

    public String getDefaultvalue() {
        return defaultvalue;
    }

    public void setDefaultvalue(String defaultvalue) {
        this.defaultvalue = defaultvalue == null ? null : defaultvalue.trim();
    }

    public Integer getInfotype() {
        return infotype;
    }

    public void setInfotype(Integer infotype) {
        this.infotype = infotype;
    }

    public Integer getValidatetype() {
        return validatetype;
    }

    public void setValidatetype(Integer validatetype) {
        this.validatetype = validatetype;
    }

    public Integer getInputmode() {
        return inputmode;
    }

    public void setInputmode(Integer inputmode) {
        this.inputmode = inputmode;
    }

    public String getInputvalue() {
        return inputvalue;
    }

    public void setInputvalue(String inputvalue) {
        this.inputvalue = inputvalue == null ? null : inputvalue.trim();
    }

    public String getInputprompt() {
        return inputprompt;
    }

    public void setInputprompt(String inputprompt) {
        this.inputprompt = inputprompt == null ? null : inputprompt.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}