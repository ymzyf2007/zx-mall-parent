package com.zx.mall.dao;

import java.util.List;
import java.util.Map;

import com.zx.mall.module.MallShopcar;

public interface MallShopcarMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MallShopcar record);

    int insertSelective(MallShopcar record);

    MallShopcar selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallShopcar record);

    int updateByPrimaryKey(MallShopcar record);

	List<MallShopcar> findByParams(Map<String, Object> filter);

	void deleteByUidAndSkuId(Map<String, Object> params);
}