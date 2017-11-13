package com.zx.mall.admin.dao;

import java.util.List;
import java.util.Map;

import com.zx.mall.admin.module.SysMenu;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
    
    /**
     * 根据角色列表查询菜单列表
     * @param roleIds
     * @return
     */
    List<SysMenu> findMenuByRoleIds(Map<String, Object> map);
}