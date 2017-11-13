package com.zx.mall.api.pojo;

import java.util.Date;
import java.util.List;

public class VenderProductSkuReq extends CommonReq {

	private static final long serialVersionUID = 2340761628885354130L;
	
	private Integer vSkuId;
	
	private String vCode;

    private String vAlias;

    private String vPname;

    private String vPshortname;

    private String vBarcode;

    private Integer vBlid;

    private String vBname;

    private String vDisplayname;

    private String vMainpicture;

    private Float vRetailprice;

    private Integer vStockamount;

    private String vUnit;

    private Integer vKindId;

    private Byte vStatus;

    private Date createtime;

    private Integer binding;
    
    private Integer operate;	// 操作  1：新增；2：修改；3：删除
    
    private List<VenderProductSkuAttrReq> data;

    public Integer getvSkuId() {
        return vSkuId;
    }

    public void setvSkuId(Integer vSkuId) {
        this.vSkuId = vSkuId;
    }
    
    public String getvCode() {
		return vCode;
	}

	public void setvCode(String vCode) {
		this.vCode = vCode;
	}

	public String getvAlias() {
        return vAlias;
    }

    public void setvAlias(String vAlias) {
        this.vAlias = vAlias == null ? null : vAlias.trim();
    }

    public String getvPname() {
        return vPname;
    }

    public void setvPname(String vPname) {
        this.vPname = vPname == null ? null : vPname.trim();
    }

    public String getvPshortname() {
        return vPshortname;
    }

    public void setvPshortname(String vPshortname) {
        this.vPshortname = vPshortname == null ? null : vPshortname.trim();
    }

    public String getvBarcode() {
        return vBarcode;
    }

    public void setvBarcode(String vBarcode) {
        this.vBarcode = vBarcode == null ? null : vBarcode.trim();
    }

    public Integer getvBlid() {
        return vBlid;
    }

    public void setvBlid(Integer vBlid) {
        this.vBlid = vBlid;
    }

    public String getvBname() {
        return vBname;
    }

    public void setvBname(String vBname) {
        this.vBname = vBname == null ? null : vBname.trim();
    }

    public String getvDisplayname() {
        return vDisplayname;
    }

    public void setvDisplayname(String vDisplayname) {
        this.vDisplayname = vDisplayname == null ? null : vDisplayname.trim();
    }

    public String getvMainpicture() {
        return vMainpicture;
    }

    public void setvMainpicture(String vMainpicture) {
        this.vMainpicture = vMainpicture == null ? null : vMainpicture.trim();
    }

    public Float getvRetailprice() {
        return vRetailprice;
    }

    public void setvRetailprice(Float vRetailprice) {
        this.vRetailprice = vRetailprice;
    }

    public Integer getvStockamount() {
        return vStockamount;
    }

    public void setvStockamount(Integer vStockamount) {
        this.vStockamount = vStockamount;
    }

    public String getvUnit() {
        return vUnit;
    }

    public void setvUnit(String vUnit) {
        this.vUnit = vUnit == null ? null : vUnit.trim();
    }

    public Integer getvKindId() {
        return vKindId;
    }

    public void setvKindId(Integer vKindId) {
        this.vKindId = vKindId;
    }

    public Byte getvStatus() {
        return vStatus;
    }

    public void setvStatus(Byte vStatus) {
        this.vStatus = vStatus;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getBinding() {
        return binding;
    }

    public void setBinding(Integer binding) {
        this.binding = binding;
    }

	public Integer getOperate() {
		return operate;
	}

	public void setOperate(Integer operate) {
		this.operate = operate;
	}

	public List<VenderProductSkuAttrReq> getData() {
		return data;
	}

	public void setData(List<VenderProductSkuAttrReq> data) {
		this.data = data;
	}
	
}