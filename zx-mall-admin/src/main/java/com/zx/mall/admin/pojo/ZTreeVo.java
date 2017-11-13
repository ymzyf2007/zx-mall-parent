package com.zx.mall.admin.pojo;

public class ZTreeVo {
	private Long id;
	private Long pId;
	private String name;
	private Integer level;
	private Boolean isParent;
	
	private Long vKindId;
	private String vKindName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
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
	
}