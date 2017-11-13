package com.zx.mall.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zx.mall.admin.pojo.SearchIndexKindProdReq;
import com.zx.mall.admin.pojo.SearchIndexKindReq;
import com.zx.mall.common.Constants;
import com.zx.mall.dao.MallIndexKindMapper;
import com.zx.mall.dao.MallIndexKindProductMapper;
import com.zx.mall.module.MallIndexKind;
import com.zx.mall.module.MallIndexKindProduct;
import com.zx.mall.util.MapUtils;
import com.zx.mall.util.StringUtil;

@Controller
@RequestMapping("/subject")
@SuppressWarnings("unchecked")
public class SubjectController {
	
	@Autowired
	private MallIndexKindMapper mallIndexKindMapper;
	@Autowired
	private MallIndexKindProductMapper mallIndexKindProductMapper;
	
	/**
	 * 首页栏目分类查询
	 * @param req
	 * @return
	 */
	@RequestMapping("/searchCategory")
	@ResponseBody
	public Map<String, Object> searchCategory(SearchIndexKindReq req) {
		Map<String, Object> reMap = new HashMap<String, Object>();	
		try {
			Map<String, Object> params = MapUtils.java2Map(req);
			if(req.getPageNo() != null) {
				params.put("begin", (req.getPageNo() - 1) * (req.getPageSize() == null ? 20 : req.getPageSize()));
			} else {
				params.put("begin", 0);
			}
			List<MallIndexKind> list = mallIndexKindMapper.findList(params);
			reMap.put("data", list);
			
			reMap.put("status", Constants.SUCCESS_CODE);
			reMap.put("msg", Constants.SUCCESS_MSG);
		} catch (Exception e) {
			e.printStackTrace();
			reMap.put("status", Constants.FAIL_CODE);
			reMap.put("msg", e.getMessage());
		}	
		return reMap;
	}
	
	/**
	 * 首页栏目商品查询
	 * @param req
	 * @return
	 */
	@RequestMapping("/searchProdsBySubjectId")
	@ResponseBody
	public Map<String, Object> searchProdsBySubjectId(SearchIndexKindProdReq req) {
		Map<String, Object> reMap = new HashMap<String, Object>();	
		try {
			if(req.getSubjectId() == null || StringUtil.isNullOrEmpty(req.getSubjectId())) {
				reMap.put("status", Constants.FAIL_CODE);
				reMap.put("msg", "参数错误！");
				return reMap;
			}
			Map<String, Object> params = MapUtils.java2Map(req);
			
			List<MallIndexKindProduct> list = mallIndexKindProductMapper.findList(params);
			reMap.put("data", list);
			
			reMap.put("status", Constants.SUCCESS_CODE);
			reMap.put("msg", Constants.SUCCESS_MSG);
		} catch (Exception e) {
			e.printStackTrace();
			reMap.put("status", Constants.FAIL_CODE);
			reMap.put("msg", e.getMessage());
		}	
		return reMap;
	}
	
	/**
	 * 首页栏目商品管理
	 * @param req
	 * @return
	 */
	@RequestMapping("/saveSubjectProduct")
	@ResponseBody
	public Map<String, Object> saveSubjectProduct(MallIndexKindProduct req) {
		Map<String, Object> reMap = new HashMap<String, Object>();
		try {
			if(req == null || null == req.getIndexKindId() || StringUtil.isNullOrEmpty(req.getLocation())) {
				reMap.put("status", Constants.FAIL_CODE);
				reMap.put("msg", "参数错误！");
				return reMap;
			}
			if(req.getId() != null) {	// 修改
				mallIndexKindProductMapper.updateByPrimaryKeySelective(req);
			} else {	// 新增
				mallIndexKindProductMapper.insertSelective(req);
			}
			reMap.put("status", Constants.SUCCESS_CODE);
			reMap.put("msg", Constants.SUCCESS_MSG);
		} catch (Exception e) {
			e.printStackTrace();
			reMap.put("status", Constants.FAIL_CODE);
			reMap.put("msg", e.getMessage());
		}
		return reMap;
	}

}