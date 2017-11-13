package com.zx.mall.module;

public class MallProductKind {
    private Long kindId;

    private String kindName;

    private Long parentId;

    private Integer sortId;

    private Integer menugrade;

    private String url;
    
    private Long vKindId;	// 关联分类ID
    
    private String imgUrl;	// 分类图片，商城分类会展示图片

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
        this.url = url == null ? null : url.trim();
    }

	public Long getvKindId() {
		return vKindId;
	}

	public void setvKindId(Long vKindId) {
		this.vKindId = vKindId;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
}