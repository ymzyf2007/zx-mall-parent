package com.zx.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zx.mall.module.MallUserAddress;

public interface MallUserAddressMapper {
    int deleteByPrimaryKey(Long receiverId);

    int insert(MallUserAddress record);

    int insertSelective(MallUserAddress record);

    MallUserAddress selectByPrimaryKey(Long receiverId);

    int updateByPrimaryKeySelective(MallUserAddress record);

    int updateByPrimaryKey(MallUserAddress record);
    
    void updateNotDefaultAddress(@Param("userId") Integer userId);

    /**
     * 根据用户ID查询地址列表
     * @param userId
     * @return
     */
	List<MallUserAddress> selectAddressListByUserId(@Param("userId") Integer userId);
}