package com.zx.mall.dao;

import com.zx.mall.module.VenderBudgetType;

public interface VenderBudgetTypeMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(VenderBudgetType record);

    int insertSelective(VenderBudgetType record);

    VenderBudgetType selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(VenderBudgetType record);

    int updateByPrimaryKey(VenderBudgetType record);
}