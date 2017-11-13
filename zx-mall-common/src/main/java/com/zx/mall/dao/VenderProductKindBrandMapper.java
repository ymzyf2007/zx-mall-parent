package com.zx.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zx.mall.module.VenderProductKindBrand;

public interface VenderProductKindBrandMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(VenderProductKindBrand record);

    int insertSelective(VenderProductKindBrand record);

    VenderProductKindBrand selectByPrimaryKey(Integer bId);

    int updateByPrimaryKeySelective(VenderProductKindBrand record);

    int updateByPrimaryKey(VenderProductKindBrand record);

    /**
	 * 根据分类ID查询该分类下的商品品牌列表，该分类为第三级分类【品牌挂在第三级分类下】
	 * @return
	 */
//	List<VenderProductKindBrand> findBrandsByKindId(@Param("kindId") Long kindId);
    
    String getChildList(@Param("kindId") Long kindId);
    
    List<VenderProductKindBrand> findBrandsByKindId(List<Long> list);
}