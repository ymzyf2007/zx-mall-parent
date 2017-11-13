package com.zx.mall.dao;

import java.util.List;
import java.util.Map;

import com.zx.mall.module.VenderOrderTrack;

public interface VenderOrderTrackMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(VenderOrderTrack record);

    int insertSelective(VenderOrderTrack record);

    VenderOrderTrack selectByPrimaryKey(Integer lid);

    int updateByPrimaryKeySelective(VenderOrderTrack record);

    int updateByPrimaryKey(VenderOrderTrack record);
    
    List<VenderOrderTrack> selectByParams(Map<String, Object> params);
}