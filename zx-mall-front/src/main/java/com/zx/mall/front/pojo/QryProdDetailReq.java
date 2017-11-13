package com.zx.mall.front.pojo;

/**
 * 查询商品详细信息请求参数
 *
 */
public class QryProdDetailReq extends BaseReq {
	
	private Long skuId;

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}
	
}