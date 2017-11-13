package com.zx.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zx.mall.module.VenderProductSkuAttr;
import com.zx.mall.module.vo.VenderProductSkuAttrVo;

public interface VenderProductSkuAttrMapper {
    int deleteByPrimaryKey(Integer skuAttrId);

    int insert(VenderProductSkuAttr record);

    int insertSelective(VenderProductSkuAttr record);

    VenderProductSkuAttr selectByPrimaryKey(Integer skuAttrId);

    int updateByPrimaryKeySelective(VenderProductSkuAttr record);

    int updateByPrimaryKey(VenderProductSkuAttr record);
    
    List<VenderProductSkuAttrVo> getVenderProductSkuAttrsBySkuId(@Param("skuId") Integer skuId);
}