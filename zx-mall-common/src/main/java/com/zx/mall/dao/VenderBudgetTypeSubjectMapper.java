package com.zx.mall.dao;

import com.zx.mall.module.VenderBudgetTypeSubject;

public interface VenderBudgetTypeSubjectMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(VenderBudgetTypeSubject record);

    int insertSelective(VenderBudgetTypeSubject record);

    VenderBudgetTypeSubject selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(VenderBudgetTypeSubject record);

    int updateByPrimaryKey(VenderBudgetTypeSubject record);
}