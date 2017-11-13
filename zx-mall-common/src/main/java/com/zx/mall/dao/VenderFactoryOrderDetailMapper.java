package com.zx.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zx.mall.module.VenderFactoryOrderDetail;

public interface VenderFactoryOrderDetailMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(VenderFactoryOrderDetail record);

    int insertSelective(VenderFactoryOrderDetail record);

    VenderFactoryOrderDetail selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(VenderFactoryOrderDetail record);

    int updateByPrimaryKey(VenderFactoryOrderDetail record);

	List<VenderFactoryOrderDetail> findFactoryOrderDetailByFolid(@Param("olid") Integer olid);
}