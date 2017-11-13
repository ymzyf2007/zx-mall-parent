package com.zx.mall.front.pojo;

import com.zx.mall.front.common.Constant;

/**
 * 轮播图返回信息
 *
 */
public class AdvertRsp {
	
	private String index; // 下标，标识位置
	private String imgUrl; // 图片地址
	private String url; // 图片指向链接
	private String title; // 标题
	private String bgColor; // 背景颜色

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		if(imgUrl.startsWith("http://") || imgUrl.startsWith("https://")) {
			this.imgUrl = imgUrl;
		} else {
			this.imgUrl = Constant.IMG_PREFIX_URL + imgUrl;
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBgColor() {
		return bgColor;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

}