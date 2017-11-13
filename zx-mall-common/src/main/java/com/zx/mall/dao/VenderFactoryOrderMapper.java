package com.zx.mall.dao;

import org.apache.ibatis.annotations.Param;

import com.zx.mall.module.VenderFactoryOrder;

public interface VenderFactoryOrderMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(VenderFactoryOrder record);

    int insertSelective(VenderFactoryOrder record);

    VenderFactoryOrder selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(VenderFactoryOrder record);

    int updateByPrimaryKey(VenderFactoryOrder record);
    
    VenderFactoryOrder qryVenderFactoryOrder(@Param("ordernumber") String ordernumber);
}