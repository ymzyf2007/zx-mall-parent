package com.zx.mall.dao;

import java.util.List;
import java.util.Map;

import com.zx.mall.module.MallIndexKindProduct;

public interface MallIndexKindProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MallIndexKindProduct record);

    int insertSelective(MallIndexKindProduct record);

    MallIndexKindProduct selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallIndexKindProduct record);

    int updateByPrimaryKey(MallIndexKindProduct record);

	List<MallIndexKindProduct> findList(Map<String, Object> params);
}