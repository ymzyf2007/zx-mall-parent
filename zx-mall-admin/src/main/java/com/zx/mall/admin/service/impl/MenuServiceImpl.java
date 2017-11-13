package com.zx.mall.admin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zx.mall.admin.dao.SysMenuMapper;
import com.zx.mall.admin.module.SysMenu;
import com.zx.mall.admin.pojo.MenuVo;
import com.zx.mall.admin.service.IMenuService;

@Service(value = "menuService")
@Transactional
public class MenuServiceImpl implements IMenuService {
	
	@Autowired
	private SysMenuMapper sysMenuMapper;

	@Override
	public List<MenuVo> allTreeNode(List<Integer> roleIds) {
		List<MenuVo> nl = new ArrayList<MenuVo>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("roleIds", roleIds);
		List<SysMenu> menus = sysMenuMapper.findMenuByRoleIds(map);
		if (menus != null && menus.size() > 0) {
			for (SysMenu menu : menus) {
				MenuVo m = new MenuVo();
				m.setPid(menu.getParentId());
				m.setId(menu.getId());
				m.setIconCls(menu.getIcon());
				m.setSeq(menu.getSeq());
				m.setName(menu.getName());
				m.setState(String.valueOf(menu.getStatus()));
				m.setUrl(menu.getUrl());
				nl.add(m);
			}
		}
		return nl;
	}

}