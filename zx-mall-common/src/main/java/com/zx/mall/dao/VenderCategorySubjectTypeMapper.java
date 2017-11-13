package com.zx.mall.dao;

import com.zx.mall.module.VenderCategorySubjectType;

public interface VenderCategorySubjectTypeMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(VenderCategorySubjectType record);

    int insertSelective(VenderCategorySubjectType record);

    VenderCategorySubjectType selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(VenderCategorySubjectType record);

    int updateByPrimaryKey(VenderCategorySubjectType record);
}