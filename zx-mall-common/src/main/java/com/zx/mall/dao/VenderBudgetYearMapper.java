package com.zx.mall.dao;

import java.util.Map;

import com.zx.mall.module.VenderBudgetYear;

public interface VenderBudgetYearMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(VenderBudgetYear record);

    int insertSelective(VenderBudgetYear record);

    VenderBudgetYear selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(VenderBudgetYear record);

    int updateByPrimaryKey(VenderBudgetYear record);

	VenderBudgetYear findBudgetByCidAndDid(Map<String, Object> params);
}