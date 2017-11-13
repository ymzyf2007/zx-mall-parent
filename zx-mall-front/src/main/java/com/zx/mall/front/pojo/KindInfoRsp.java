package com.zx.mall.front.pojo;

import java.util.ArrayList;
import java.util.List;

public class KindInfoRsp {

	private Long kindId; // 分类ID
	private String kindName; // 分类名称
	private Integer level; // 分类级别
	private String url;
	private String imgUrl;
	private List<KindInfoRsp> subKindList = new ArrayList<KindInfoRsp>(); // 子级分类列表

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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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

	public List<KindInfoRsp> getSubKindList() {
		return subKindList;
	}

	public void setSubKindList(List<KindInfoRsp> subKindList) {
		this.subKindList = subKindList;
	}

}