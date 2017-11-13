package com.zx.mall.dao;

import com.zx.mall.module.MallProductSku;

public interface MallProductSkuMapper {
    int deleteByPrimaryKey(Long skuId);

    int insert(MallProductSku record);

    int insertSelective(MallProductSku record);

    MallProductSku selectByPrimaryKey(Long skuId);

    int updateByPrimaryKeySelective(MallProductSku record);

    int updateByPrimaryKey(MallProductSku record);
}