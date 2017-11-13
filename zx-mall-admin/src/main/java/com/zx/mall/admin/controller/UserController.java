package com.zx.mall.admin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zx.mall.admin.pojo.SysUserVo;
import com.zx.mall.admin.security.SpringSecurityUtils;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/getCurrentUser")
	@ResponseBody
	public Map<String, Object> getCurrentUser(HttpSession session) {
		Map<String, Object> reMap = new HashMap<String, Object>();
		reMap.put("status", 200);
		reMap.put("msg", "success");
		try {
			User user = SpringSecurityUtils.getCurrentUser();
			reMap.put("data", new SysUserVo(user.getUsername(), user.isAccountNonExpired(), user.isEnabled(), user.getUsername()));
		} catch(Exception e) {
			e.printStackTrace();
			reMap.put("status", 500);
			reMap.put("msg", e.getMessage());
		}
		
		return reMap;
	}

}