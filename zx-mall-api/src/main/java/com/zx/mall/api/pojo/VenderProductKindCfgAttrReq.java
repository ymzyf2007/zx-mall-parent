package com.zx.mall.api.pojo;

public class VenderProductKindCfgAttrReq extends CommonReq {

	private static final long serialVersionUID = -467519073883145157L;
	
	private Integer kindAttrId;
    private Integer kindId;
    private Integer attrId;
    private Integer status;
    private Integer sort;
    private Integer operate;	// 操作  1：新增；2：修改；3：删除

    public Integer getKindAttrId() {
        return kindAttrId;
    }

    public void setKindAttrId(Integer kindAttrId) {
        this.kindAttrId = kindAttrId;
    }

    public Integer getKindId() {
        return kindId;
    }

    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}
    
}