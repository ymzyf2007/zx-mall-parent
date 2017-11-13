package com.zx.mall.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zx.mall.admin.module.SysRole;
import com.zx.mall.admin.pojo.MenuVo;
import com.zx.mall.admin.security.SpringSecurityUtils;
import com.zx.mall.admin.service.IMenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	
	@Resource
	private IMenuService menuService;
	
	@RequestMapping("/allTreeNode")
	@ResponseBody
	public Map<String, Object> allTreeNode(HttpSession session) {
		Map<String, Object> reMap = new HashMap<String, Object>();
		reMap.put("status", 200);
		reMap.put("msg", "success");
		try {
			List<Integer> roleIds = new ArrayList<Integer>();
			List<SysRole> roleList = SpringSecurityUtils.getRoleList();
			if(roleList != null && roleList.size() > 0) {
				for(SysRole role : roleList) {
					roleIds.add(role.getId());
				}
			}
			List<MenuVo> datas = menuService.allTreeNode(roleIds);
			reMap.put("data", datas);
		} catch(Exception e) {
			e.printStackTrace();
			reMap.put("status", 500);
			reMap.put("msg", e.getMessage());
		}
		
		return reMap;
	}
	
}