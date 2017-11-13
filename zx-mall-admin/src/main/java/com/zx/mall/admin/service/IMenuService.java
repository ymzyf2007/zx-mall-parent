package com.zx.mall.admin.service;

import java.util.List;

import com.zx.mall.admin.pojo.MenuVo;

public interface IMenuService {
	
	List<MenuVo> allTreeNode(List<Integer> roleIds);

}