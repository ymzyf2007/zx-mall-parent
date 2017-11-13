package com.zx.mall.common;

import java.util.HashMap;
import java.util.Map;

public class PageUtil {
	
	public static Map<String, Object> getMap(int current, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		Page page = new Page();
		page.setCurrent(current);
		page.setPageSize(pageSize);
		map.put("begin", page.getBegin());
		map.put("pageSize", pageSize);
		return map;
	}

}