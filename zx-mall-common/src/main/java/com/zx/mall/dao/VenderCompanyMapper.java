package com.zx.mall.dao;

import com.zx.mall.module.VenderCompany;

public interface VenderCompanyMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(VenderCompany record);

    int insertSelective(VenderCompany record);

    VenderCompany selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(VenderCompany record);

    int updateByPrimaryKey(VenderCompany record);
}