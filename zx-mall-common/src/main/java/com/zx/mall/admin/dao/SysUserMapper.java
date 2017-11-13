package com.zx.mall.admin.dao;

import com.zx.mall.admin.module.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
	SysUser findUserByUserName(String username);
}