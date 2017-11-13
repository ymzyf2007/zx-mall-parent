package com.zx.mall.module.vo;

public class MallProductKindVo {

	private Long kindId;
	private String kindName;
	private Long parentId;
	private Integer sortId;
	private Integer menugrade;
	private String url;
	private String imgUrl;
	
	private Long vKindId;
	private String vKindName;
	private Integer vLevel;

	public Long getKindId() {
		return kindId;
	}

	public void setKindId(Long kindId) {
		this.kindId = kindId;
	}

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Integer getSortId() {
		return sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

	public Integer getMenugrade() {
		return menugrade;
	}

	public void setMenugrade(Integer menugrade) {
		this.menugrade = menugrade;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Long getvKindId() {
		return vKindId;
	}

	public void setvKindId(Long vKindId) {
		this.vKindId = vKindId;
	}

	public String getvKindName() {
		return vKindName;
	}

	public void setvKindName(String vKindName) {
		this.vKindName = vKindName;
	}

	public Integer getvLevel() {
		return vLevel;
	}

	public void setvLevel(Integer vLevel) {
		this.vLevel = vLevel;
	}

}