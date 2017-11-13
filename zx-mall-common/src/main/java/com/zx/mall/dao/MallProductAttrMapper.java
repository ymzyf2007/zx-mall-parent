package com.zx.mall.dao;

import com.zx.mall.module.MallProductAttr;

public interface MallProductAttrMapper {
    int deleteByPrimaryKey(Long productAttrId);

    int insert(MallProductAttr record);

    int insertSelective(MallProductAttr record);

    MallProductAttr selectByPrimaryKey(Long productAttrId);

    int updateByPrimaryKeySelective(MallProductAttr record);

    int updateByPrimaryKey(MallProductAttr record);
}