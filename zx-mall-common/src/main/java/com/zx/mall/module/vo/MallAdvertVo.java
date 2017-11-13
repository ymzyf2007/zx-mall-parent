package com.zx.mall.module.vo;

import java.text.SimpleDateFormat;

import com.zx.mall.module.MallAdvert;

public class MallAdvertVo {

	private Long id;
	private String title;
	private String linkUrl;
	private Integer status; // 启用状态1、启用 0、停用
	private Integer sortId;
	private String type;
	private String picPath;
	private String publishDate;
	private String createUser;
	private String createDate;
	private String downTime;
	private String bgColor;
	
	public MallAdvertVo() {
	}
	
	public MallAdvertVo(MallAdvert advert) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.id = advert.getId();
		this.title = advert.getTitle();
		this.linkUrl = advert.getLinkUrl();
		this.status = advert.getStatus(); // 启用状态1、启用 0、停用
		this.sortId = advert.getSortId();
		this.type = advert.getType();
		this.picPath = advert.getPicPath();
		try {
			this.publishDate = advert.getPublishDate() == null ? "" : sdf.format(advert.getPublishDate());
			this.createDate = advert.getCreateDate() == null ? "" : sdf.format(advert.getCreateDate());
			this.downTime = advert.getDownTime() == null ? "" : sdf.format(advert.getDownTime());
		} catch(Exception e) {
		}
		this.createUser = advert.getCreateUser();
		this.bgColor = advert.getBgColor();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSortId() {
		return sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	
	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getDownTime() {
		return downTime;
	}

	public void setDownTime(String downTime) {
		this.downTime = downTime;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

}