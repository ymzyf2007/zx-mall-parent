package com.zx.mall.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zx.mall.admin.pojo.CommonListReq;
import com.zx.mall.admin.pojo.ZTreeVo;
import com.zx.mall.common.Constants;
import com.zx.mall.dao.MallProductKindMapper;
import com.zx.mall.dao.VenderProductKindMapper;
import com.zx.mall.module.MallProductKind;
import com.zx.mall.module.vo.MallProductKindVo;
import com.zx.mall.module.vo.VenderProductKindVo;
import com.zx.mall.util.StringUtil;

@Controller
@RequestMapping("/category")
@SuppressWarnings("unchecked")
public class CategoryController {
	
	@Autowired
	private MallProductKindMapper mallProductKindMapper;
	@Autowired
	private VenderProductKindMapper venderProductKindMapper;
	
	/**
	 * 商品分类查询
	 * @return
	 */
	@RequestMapping("/search")
	@ResponseBody
	public Map<String, Object> search() {
		Map<String, Object> reMap = new HashMap<String, Object>();	
		try {
			List<MallProductKindVo> kindList = mallProductKindMapper.findKindList();
			List<ZTreeVo> rtList = new ArrayList<ZTreeVo>();
			if(kindList != null && kindList.size() > 0) {
				for(MallProductKindVo vo : kindList) {
					ZTreeVo treeVo = new ZTreeVo();
					treeVo.setId(vo.getKindId());
					treeVo.setpId(vo.getParentId());
					treeVo.setName(vo.getKindName());
					boolean isParent = false;
					for(MallProductKindVo k : kindList) {
						if(vo.getKindId() == k.getParentId()) {
							isParent = true;
							break;
						}
					}
					treeVo.setLevel(vo.getMenugrade());
					treeVo.setIsParent(isParent);
					
					treeVo.setvKindId(vo.getvKindId());
					treeVo.setvKindName(vo.getvKindName());
					rtList.add(treeVo);
				}
			}
			
			reMap.put("data", rtList/*kindList*/);
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
	 * 订单系统-关联分类查询
	 * @param level
	 * @return
	 */
	@RequestMapping("/findRelationCategory")
	@ResponseBody
	public Map<String, Object> findRelationCategory(Integer level) {
		Map<String, Object> reMap = new HashMap<String, Object>();	
		try {
			List<VenderProductKindVo> venderProductTypeList = venderProductKindMapper.findRelationTypeList(level);
			reMap.put("data", venderProductTypeList);
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
	 * 商品分类管理
	 * @param req
	 * @return
	 */
	@RequestMapping("/saveCategory")
	@ResponseBody
	public Map<String, Object> saveCategory(ZTreeVo vo/*MallProductKind req*/) {
		Map<String, Object> reMap = new HashMap<String, Object>();
		try {
//			if(req == null || req.getParentId() == null || StringUtil.isNullOrEmpty(req.getKindName())) {
//				reMap.put("status", Constants.FAIL_CODE);
//				reMap.put("msg", "参数错误！");
//				return reMap;
//			}
//			if(req.getKindId() != null) {
//				mallProductKindMapper.updateByPrimaryKeySelective(req);
//			} else {
//				mallProductKindMapper.insertSelective(req);
//			}
			
			if(vo == null || vo.getpId() == null || StringUtil.isNullOrEmpty(vo.getName())) {
				reMap.put("status", Constants.FAIL_CODE);
				reMap.put("msg", "参数错误！");
				return reMap;
			}
			MallProductKind mallProductKind = new MallProductKind();
			if(!"null".equals(vo.getName()) && !StringUtil.isNullOrEmpty((vo.getName())))
				mallProductKind.setKindName(vo.getName());
			if(vo.getpId() != null && !"null".equals(vo.getpId().toString()))
				mallProductKind.setParentId(vo.getpId());
			if(vo.getLevel() != null && !"null".equals(vo.getLevel().toString()))
				mallProductKind.setMenugrade(vo.getLevel());
			if(vo.getvKindId() != null && !"null".equals(vo.getvKindId().toString()) && !StringUtil.isNullOrEmpty(vo.getvKindId().toString()))
				mallProductKind.setvKindId(vo.getvKindId());
			
			if(vo.getId() != null && !StringUtil.isNullOrEmpty(vo.getId().toString())) {
				mallProductKind.setKindId(vo.getId());
				mallProductKindMapper.updateByPrimaryKeySelective(mallProductKind);
			} else {
				mallProductKindMapper.insertSelective(mallProductKind);
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
	
	/**
	 * 批量保存商品分类
	 * @param req
	 * @return
	 */
	@RequestMapping("/saveCategorys")
	@ResponseBody
	public Map<String, Object> saveCategorys(CommonListReq req) {
		Map<String, Object> reMap = new HashMap<String, Object>();
		try {
			if(req == null || StringUtil.isNullOrEmpty(req.getCategoryList())) {
				reMap.put("status", Constants.FAIL_CODE);
				reMap.put("msg", "参数错误！");
				return reMap;
			}
			ObjectMapper mapper = new ObjectMapper();
			mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			List<Map<String, Object>> categorys = mapper.readValue(req.getCategoryList(), List.class);
			if(categorys != null && categorys.size() > 0) {
				for(int i = 0; i < categorys.size(); i++) {
					Map<String, Object> c = categorys.get(i);
					
					MallProductKind mallProductKind = new MallProductKind();
					if(c.containsKey("name") && !"null".equals(c.get("name").toString()) && !StringUtil.isNullOrEmpty(c.get("name").toString()))
						mallProductKind.setKindName(c.get("name").toString());
					if(c.containsKey("pId") && !StringUtil.isNullOrEmpty(c.get("pId").toString()))
						mallProductKind.setParentId(Long.valueOf(c.get("pId").toString()));
					mallProductKind.setSortId(i+1);
					if(c.containsKey("level") && !"null".equals(c.get("level").toString()) && !StringUtil.isNullOrEmpty(c.get("level").toString()))
						mallProductKind.setMenugrade(Integer.valueOf(c.get("level").toString()));
					if(c.containsKey("url") && !"null".equals(c.get("url").toString()) && !StringUtil.isNullOrEmpty(c.get("url").toString()))
						mallProductKind.setUrl(c.get("url").toString());
					if(c.containsKey("vKindId") && c.get("vKindId") != null && !"null".equals(c.get("vKindId").toString()) && !StringUtil.isNullOrEmpty(c.get("vKindId").toString()))
						mallProductKind.setvKindId(Long.valueOf(c.get("vKindId").toString()));
					
					if(c.containsKey("id") && !StringUtil.isNullOrEmpty(c.get("id").toString())) {
						mallProductKind.setKindId(Long.valueOf(c.get("id").toString()));
						mallProductKindMapper.updateByPrimaryKeySelective(mallProductKind);
					} else {
						mallProductKindMapper.insertSelective(mallProductKind);
					}
					mallProductKind = null;	// help gc
				}
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
	
	/**
	 * 根据ID删除分类
	 * @param id
	 * @return
	 */
	@RequestMapping("/del")
	@ResponseBody
	public Map<String, Object> del(Long kindId) {
		Map<String, Object> reMap = new HashMap<String, Object>();	
		try {
			if(kindId == null || kindId == 0L) {
				reMap.put("status", Constants.FAIL_CODE);
				reMap.put("msg", "参数错误！");
				return reMap;
			}
			
			List<MallProductKind> kindList = mallProductKindMapper.qrySubByParent(kindId);
			if(kindList != null && kindList.size() > 0) {
				for(MallProductKind pk : kindList){
					mallProductKindMapper.deleteByPrimaryKey(pk.getKindId());
				}
				
				reMap.put("status", Constants.SUCCESS_CODE);
				reMap.put("msg", Constants.SUCCESS_MSG);
			} else {
				reMap.put("status", Constants.SUCCESS_CODE);
				reMap.put("msg", "没有记录！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			reMap.put("status", Constants.FAIL_CODE);
			reMap.put("msg", e.getMessage());
		}	
		return reMap;
	}
	
	/**
	 * 保存商品分类排序
	 * @param adverts
	 * @return
	 */
	@RequestMapping("/saveCategoryList")
	@ResponseBody
	public Map<String, Object> saveCategoryList(CommonListReq req) {
		Map<String, Object> reMap = new HashMap<String, Object>();	
		try {
			if(req == null || StringUtil.isNullOrEmpty(req.getCategoryList())) {
				reMap.put("status", Constants.FAIL_CODE);
				reMap.put("msg", "参数错误！");
				return reMap;
			}
			
			ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			List<Map<String, Object>> categorys = mapper.readValue(req.getCategoryList(), List.class);
			if(categorys != null && categorys.size() > 0) {
				for(int i = 0; i < categorys.size(); i++) {
					Map<String, Object> c = categorys.get(i);
					if(c.containsKey("kindId") && !StringUtil.isNullOrEmpty(c.get("kindId").toString()) && c.containsKey("sortId") && !StringUtil.isNullOrEmpty(c.get("sortId").toString())) {
						MallProductKind mallProductKind = new MallProductKind();
						mallProductKind.setKindId(Long.valueOf(c.get("kindId").toString()));
						mallProductKind.setSortId(Integer.valueOf(c.get("sortId").toString()));
						mallProductKindMapper.updateByPrimaryKeySelective(mallProductKind);
					}
				}
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