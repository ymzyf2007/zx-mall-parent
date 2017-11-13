package com.zx.mall.api.pojo;

public class VenderProductSkuAttrReq extends CommonReq {

	private static final long serialVersionUID = 4536466602821821617L;
	
	private Integer skuAttrId;

    private Integer kindId;

    private Integer skuId;

    private Integer attrId;

    private String attrValue;
    
    private Integer operate;	// 操作  1：新增；2：修改；3：删除

    public Integer getSkuAttrId() {
        return skuAttrId;
    }

    public void setSkuAttrId(Integer skuAttrId) {
        this.skuAttrId = skuAttrId;
    }

    public Integer getKindId() {
        return kindId;
    }

    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue == null ? null : attrValue.trim();
    }

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}
    
}