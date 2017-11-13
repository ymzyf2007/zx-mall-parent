package com.zx.mall.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zx.mall.module.MallOrder;
import com.zx.mall.module.vo.MallOrderVo;

public interface MallOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MallOrder record);

    int insertSelective(MallOrder record);

    MallOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallOrder record);

    int updateByPrimaryKey(MallOrder record);
    
    MallOrder findByUidAndOrderNo(@Param("userId") Long userId, @Param("orderNo") String orderNo);
    
    int cancelOrder(@Param("userId") Long userId, @Param("orderNo") String orderNo);

    /**
     * 查询订单列表
     * @param params
     * @return
     */
	List<MallOrderVo> findOrderList(Map<String, Object> params);

	int findOrderCount(Map<String, Object> params);

	MallOrderVo getOrderDetail(Map<String, Object> params);
	
	MallOrder findOrderByOrderNo(@Param("orderNo") String orderNo);
    
}