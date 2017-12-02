package com.zx.mall.front.pojo;

import com.zx.mall.front.common.Constant;
import com.zx.mall.module.VenderProductKindBrand;
import com.zx.mall.util.StringUtil;

public class KindBrandRsp {

	private Integer bId;	// 品牌ID
	private Integer kindId;
	private String bName;	// 品牌名称
	private String enName;
	private String descr;
	private String logo;
	private Integer status;
	private Integer sort;
	
	public KindBrandRsp() {
	}

	public KindBrandRsp(VenderProductKindBrand info) {
		this.bId = info.getbId();
//		this.kindId = info.getKindId();
		this.bName = info.getCnname();
		this.enName = info.getEnname();
		this.descr = info.getDescr();
		if(!StringUtil.isNullOrEmpty(info.getLogo())) {
			if(info.getLogo().startsWith("http://") || info.getLogo().startsWith("https://")) {
				this.logo = info.getLogo();
			} else {
				this.logo = Constant.IMG_PREFIX_URL + info.getLogo();
			}
		}
		this.status = info.getStatus();
		this.sort = info.getSort();
	}

	public Integer getbId() {
		return bId;
	}

	public void setbId(Integer bId) {
		this.bId = bId;
	}

	public Integer getKindId() {
		return kindId;
	}

	public void setKindId(Integer kindId) {
		this.kindId = kindId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
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

}