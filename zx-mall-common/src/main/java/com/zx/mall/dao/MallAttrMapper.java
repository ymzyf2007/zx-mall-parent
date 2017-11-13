package com.zx.mall.dao;

import com.zx.mall.module.MallAttr;

/**
 * 属性表
 *
 */
public interface MallAttrMapper {
    int deleteByPrimaryKey(Long attrId);

    int insert(MallAttr record);

    int insertSelective(MallAttr record);

    MallAttr selectByPrimaryKey(Long attrId);

    int updateByPrimaryKeySelective(MallAttr record);

    int updateByPrimaryKey(MallAttr record);
}