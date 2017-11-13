package com.zx.mall.dao;

import java.util.List;
import java.util.Map;

import com.zx.mall.module.MallAdvert;

/**
 * 广告位表
 *
 */
public interface MallAdvertMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MallAdvert record);

    int insertSelective(MallAdvert record);

    MallAdvert selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallAdvert record);

    int updateByPrimaryKey(MallAdvert record);

	void offStore(Long id);

	/**
	 * 根据条件查询轮播图列表
	 * @param param
	 * @return
	 */
	List<MallAdvert> findList(Map<String, Object> param);
}