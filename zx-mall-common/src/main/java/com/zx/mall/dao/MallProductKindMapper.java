package com.zx.mall.dao;

import java.util.List;

import com.zx.mall.module.MallProductKind;
import com.zx.mall.module.vo.MallProductKindVo;

public interface MallProductKindMapper {
    int deleteByPrimaryKey(Long kindId);

    int insert(MallProductKind record);

    int insertSelective(MallProductKind record);

    MallProductKind selectByPrimaryKey(Long kindId);

    int updateByPrimaryKeySelective(MallProductKind record);

    int updateByPrimaryKey(MallProductKind record);

    /**
     * 商品分类查询
     * @return
     */
	List<MallProductKindVo> findKindList();

	/**
	 * 根据父分类ID查询类别
	 * @param parentId
	 * @return
	 */
	List<MallProductKind> qrySubByParent(Long parentId);
}