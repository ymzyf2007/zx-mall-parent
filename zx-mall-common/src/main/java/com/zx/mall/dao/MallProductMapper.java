package com.zx.mall.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zx.mall.module.MallProduct;
import com.zx.mall.module.vo.MallProductDetailVo;
import com.zx.mall.module.vo.MallProductVo;
import com.zx.mall.module.vo.MallShopcarVo;

public interface MallProductMapper {
    int deleteByPrimaryKey(Long productId);

    int insert(MallProduct record);

    int insertSelective(MallProduct record);

    MallProduct selectByPrimaryKey(Long productId);

    int updateByPrimaryKeySelective(MallProduct record);

    int updateByPrimaryKey(MallProduct record);
    
    int findProductCount(Map<String, Object> params);

	List<MallProductVo> findProductList(Map<String, Object> params);

	void updateStatus(@Param("productId") Long productId, @Param("status") Integer status);
	
	void updateRecommend(@Param("productId") Long productId, @Param("recommend") Integer recommend);

	/**
	 * 根据商品分类、品牌ID和综合排序方式分页查询商品列表
	 * @param params
	 * @return
	 */
	int findProdCountByParams(Map<String, Object> params);

	/**
	 * 根据商品分类、品牌ID和综合排序方式分页查询商品列表
	 * @param params
	 * @return
	 */
	List<MallProductVo> findProdsByParams(Map<String, Object> params);

	/**
	 * 根据商品ID查询商品详情
	 * @param productId
	 * @return
	 */
	MallProductDetailVo getDetailById(@Param("productId") Long productId);
	
	/**
	 * 根据参数搜索商品列表条数
	 * @param params
	 * @return
	 */
	int searchProdsCountByParams(Map<String, Object> params);

	/**
	 * 根据参数搜索商品列表
	 * @param params
	 * @return
	 */
	List<MallProductDetailVo> searchProdsByParams(Map<String, Object> params);

	/**
	 * 查询购物车商品列表
	 * @param filter
	 * @return
	 */
	List<MallShopcarVo> getShopcarProds(Map<String, Object> filter);
}