package com.zx.mall.module;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.zx.mall.module.vo.MallAdvertVo;
import com.zx.mall.util.StringUtil;

public class MallAdvert {
    private Long id;
    private String title;
    private String linkUrl;
    private Integer status;	// 启用状态1、启用 0、停用
    private Integer sortId;
    private String type;
    private String picPath;
    private Date publishDate;
    private String createUser;
    private Date createDate;
    private Date downTime;
    private String bgColor;
    
    public MallAdvert() {
	}
    
    public MallAdvert(MallAdvertVo vo) {
    	this.id = vo.getId();
    	this.title = vo.getTitle();
    	this.linkUrl = vo.getLinkUrl();
    	this.status = vo.getStatus();	// 启用状态1、启用 0、停用
    	this.sortId = vo.getSortId();
    	this.type = vo.getType();
    	this.picPath = vo.getPicPath();
    	try {
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		if(!StringUtil.isNullOrEmpty(vo.getPublishDate()))
    			this.publishDate = sdf.parse(vo.getPublishDate());
    		if(!StringUtil.isNullOrEmpty(vo.getCreateDate()))
    			this.createDate = sdf.parse(vo.getCreateDate());
    		if(!StringUtil.isNullOrEmpty(vo.getDownTime()))
    			this.downTime = sdf.parse(vo.getDownTime());
    	} catch(Exception e) {
    	}
    	if(!StringUtil.isNullOrEmpty(vo.getCreateUser()))
    		this.createUser = vo.getCreateUser();
    	this.bgColor = vo.getBgColor();
	}

    public MallAdvert(Map<String, Object> map) throws Exception {
    	this.id = map.containsKey("id") ? Long.valueOf(map.get("id").toString()) : null;
    	this.title = map.containsKey("title") ? map.get("title").toString() : null;
    	this.linkUrl = map.containsKey("linkUrl") ? map.get("linkUrl").toString() : null;
    	this.status = map.containsKey("status") ? Integer.valueOf(map.get("status").toString()) : 1;	// 启用状态1、启用 0、停用
    	this.sortId = map.containsKey("sortId") ? Integer.valueOf(map.get("sortId").toString()) : null;
    	this.type = map.containsKey("type") ? map.get("type").toString() : null;
    	this.picPath = map.containsKey("picPath") ? map.get("picPath").toString() : null;
    	try {
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		this.publishDate = (map.containsKey("publishDate") && !StringUtil.isNullOrEmpty(map.get("publishDate").toString())) ? sdf.parse(map.get("publishDate").toString()) : null;
    		this.createDate = (map.containsKey("createDate") && !StringUtil.isNullOrEmpty(map.get("createDate").toString())) ? sdf.parse(map.get("createDate").toString()) : null;
    		this.downTime = (map.containsKey("downTime") && !StringUtil.isNullOrEmpty(map.get("downTime").toString())) ? sdf.parse(map.get("downTime").toString()) : null;
    	} catch(Exception e) {
    	}
    	this.createUser = (map.containsKey("createUser") && map.get("createUser") != null && !StringUtil.isNullOrEmpty(map.get("createUser").toString())) ? map.get("createUser").toString() : null;
    	this.bgColor = map.containsKey("bgColor") ? map.get("bgColor").toString() : null;
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
        this.title = title == null ? null : title.trim();
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl == null ? null : linkUrl.trim();
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
        this.type = type == null ? null : type.trim();
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDownTime() {
        return downTime;
    }

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor == null ? null : bgColor.trim();
    }
}