package com.zx.mall.dao;

import com.zx.mall.module.VenderProductKindAttr;

public interface VenderProductKindAttrMapper {
    int deleteByPrimaryKey(Integer attrId);

    int insert(VenderProductKindAttr record);

    int insertSelective(VenderProductKindAttr record);

    VenderProductKindAttr selectByPrimaryKey(Integer attrId);

    int updateByPrimaryKeySelective(VenderProductKindAttr record);

    int updateByPrimaryKey(VenderProductKindAttr record);
}