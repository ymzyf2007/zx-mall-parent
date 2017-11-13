package com.zx.mall.dao;

import com.zx.mall.module.MallProductExt;

public interface MallProductExtMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MallProductExt record);

    int insertSelective(MallProductExt record);

    MallProductExt selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallProductExt record);

    int updateByPrimaryKeyWithBLOBs(MallProductExt record);

    int updateByPrimaryKey(MallProductExt record);
}