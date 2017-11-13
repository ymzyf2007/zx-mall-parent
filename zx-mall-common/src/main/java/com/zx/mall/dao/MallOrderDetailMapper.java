package com.zx.mall.dao;

import com.zx.mall.module.MallOrderDetail;

public interface MallOrderDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MallOrderDetail record);

    int insertSelective(MallOrderDetail record);

    MallOrderDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallOrderDetail record);

    int updateByPrimaryKey(MallOrderDetail record);
}