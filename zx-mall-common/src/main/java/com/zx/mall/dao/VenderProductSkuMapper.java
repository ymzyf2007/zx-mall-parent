package com.zx.mall.dao;

import java.util.List;
import java.util.Map;

import com.zx.mall.module.VenderProductSku;

public interface VenderProductSkuMapper {
    int deleteByPrimaryKey(Integer vSkuId);

    int insert(VenderProductSku record);

    int insertSelective(VenderProductSku record);

    VenderProductSku selectByPrimaryKey(Integer vSkuId);

    int updateByPrimaryKeySelective(VenderProductSku record);

    int updateByPrimaryKey(VenderProductSku record);

	int findCountUnbindingProSku();
	
	List<VenderProductSku> findUnbindingProSkuList(Map<String, Object> params);
}