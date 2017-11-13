package com.zx.mall.dao;

import com.zx.mall.module.MallBrand;

/**
 * 产品品牌表
 *
 */
public interface MallBrandMapper {
    int deleteByPrimaryKey(Long brandId);

    int insert(MallBrand record);

    int insertSelective(MallBrand record);

    MallBrand selectByPrimaryKey(Long brandId);

    int updateByPrimaryKeySelective(MallBrand record);

    int updateByPrimaryKey(MallBrand record);
}