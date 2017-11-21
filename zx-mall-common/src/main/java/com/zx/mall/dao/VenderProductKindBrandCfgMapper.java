package com.zx.mall.dao;

import org.apache.ibatis.annotations.Param;

import com.zx.mall.module.VenderProductKindBrandCfg;

public interface VenderProductKindBrandCfgMapper {
	
	int insertSelective(VenderProductKindBrandCfg record);
	
	int deleteByBid(@Param("bId") Integer bId);

}
