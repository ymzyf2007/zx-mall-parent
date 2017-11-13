package com.zx.mall.dao;

import com.zx.mall.module.VenderDepartment;

public interface VenderDepartmentMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(VenderDepartment record);

    int insertSelective(VenderDepartment record);

    VenderDepartment selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(VenderDepartment record);

    int updateByPrimaryKey(VenderDepartment record);
}