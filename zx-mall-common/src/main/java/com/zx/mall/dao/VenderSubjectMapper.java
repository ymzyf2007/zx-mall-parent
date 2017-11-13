package com.zx.mall.dao;

import com.zx.mall.module.VenderSubject;

public interface VenderSubjectMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(VenderSubject record);

    int insertSelective(VenderSubject record);

    VenderSubject selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(VenderSubject record);

    int updateByPrimaryKey(VenderSubject record);
}