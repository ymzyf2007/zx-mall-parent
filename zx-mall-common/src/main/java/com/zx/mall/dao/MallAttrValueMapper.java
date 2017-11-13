package com.zx.mall.dao;

import com.zx.mall.module.MallAttrValue;

/**
 * 属性值表
 *
 */
public interface MallAttrValueMapper {
    int deleteByPrimaryKey(Long attrValueId);

    int insert(MallAttrValue record);

    int insertSelective(MallAttrValue record);

    MallAttrValue selectByPrimaryKey(Long attrValueId);

    int updateByPrimaryKeySelective(MallAttrValue record);

    int updateByPrimaryKey(MallAttrValue record);
}