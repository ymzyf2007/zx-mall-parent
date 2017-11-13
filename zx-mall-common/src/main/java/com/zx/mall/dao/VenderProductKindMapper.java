package com.zx.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zx.mall.module.VenderProductKind;
import com.zx.mall.module.vo.VenderProductKindVo;

public interface VenderProductKindMapper {
    int deleteByPrimaryKey(Long vKindId);

    int insert(VenderProductKind record);

    int insertSelective(VenderProductKind record);

    VenderProductKind selectByPrimaryKey(Long vKindId);

    int updateByPrimaryKeySelective(VenderProductKind record);

    int updateByPrimaryKey(VenderProductKind record);

	List<VenderProductKindVo> findRelationTypeList(@Param("level") Integer level);
}