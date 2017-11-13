package com.zx.mall.dao;

import java.util.List;
import java.util.Map;

import com.zx.mall.module.MallIndexKind;
import com.zx.mall.module.vo.IndexKindRsp;

public interface MallIndexKindMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MallIndexKind record);

    int insertSelective(MallIndexKind record);

    MallIndexKind selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallIndexKind record);

    int updateByPrimaryKey(MallIndexKind record);
    
    List<MallIndexKind> findList(Map<String, Object> params);

	List<IndexKindRsp> qryMainKindList();
}