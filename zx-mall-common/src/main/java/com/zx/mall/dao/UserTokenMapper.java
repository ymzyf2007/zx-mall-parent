package com.zx.mall.dao;

import org.apache.ibatis.annotations.Param;

import com.zx.mall.module.UserToken;

public interface UserTokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserToken record);

    int insertSelective(UserToken record);

    UserToken selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserToken record);

    int updateByPrimaryKey(UserToken record);
    
    void deleteUserTokenByUserId(@Param("userId") Integer userId);
    
    UserToken selectByUserId(@Param("userId") Integer userId);
}