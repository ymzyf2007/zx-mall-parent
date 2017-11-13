package com.zx.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zx.mall.module.VenderBudgetDetail;

public interface VenderBudgetDetailMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(VenderBudgetDetail record);

    int insertSelective(VenderBudgetDetail record);

    VenderBudgetDetail selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(VenderBudgetDetail record);

    int updateByPrimaryKey(VenderBudgetDetail record);

	List<VenderBudgetDetail> findByYearPrimaryKey(@Param("blid") Integer blid);
}