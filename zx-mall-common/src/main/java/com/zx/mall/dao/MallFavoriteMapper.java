package com.zx.mall.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zx.mall.module.MallFavorite;
import com.zx.mall.module.vo.MallProductVo;

public interface MallFavoriteMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MallFavorite record);

    int insertSelective(MallFavorite record);

    MallFavorite selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallFavorite record);

    int updateByPrimaryKey(MallFavorite record);

	void delByUidAndSkuId(@Param("userId") Long userId, @Param("skuId") Long skuId);

	int findCount(Map<String, Object> params);

	List<MallProductVo> findSubProList(Map<String, Object> params);
}