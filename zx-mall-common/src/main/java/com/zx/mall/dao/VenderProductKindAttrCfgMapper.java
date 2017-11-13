package com.zx.mall.dao;

import com.zx.mall.module.VenderProductKindAttrCfg;

public interface VenderProductKindAttrCfgMapper {
    int deleteByPrimaryKey(Integer kindAttrId);

    int insert(VenderProductKindAttrCfg record);

    int insertSelective(VenderProductKindAttrCfg record);

    VenderProductKindAttrCfg selectByPrimaryKey(Integer kindAttrId);

    int updateByPrimaryKeySelective(VenderProductKindAttrCfg record);

    int updateByPrimaryKey(VenderProductKindAttrCfg record);
}