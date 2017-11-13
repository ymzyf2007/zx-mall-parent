package com.zx.mall.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zx.mall.admin.pojo.SaveAdvertReq;
import com.zx.mall.admin.pojo.SearchAdvertReq;
import com.zx.mall.common.Constants;
import com.zx.mall.dao.MallAdvertMapper;
import com.zx.mall.module.MallAdvert;
import com.zx.mall.module.vo.MallAdvertVo;
import com.zx.mall.util.MapUtils;
import com.zx.mall.util.StringUtil;

@Controller
@RequestMapping("/advert")
@SuppressWarnings("unchecked")
public class AdvertController {
	
	@Autowired
	private MallAdvertMapper mallAdvertMapper;
	
	/**
	 * 保存轮播图
	 * @param adverts
	 * @return
	 */
	@RequestMapping("/saveAdverts")
	@ResponseBody
	public Map<String, Object> saveAdverts(SaveAdvertReq req) {
		Map<String, Object> reMap = new HashMap<String, Object>();
		try {
			if(req == null || StringUtil.isNullOrEmpty(req.getCarouselList())) {
				reMap.put("status", Constants.FAIL_CODE);
				reMap.put("msg", "参数错误！");
				return reMap;
			}
			
			ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			List<Map<String, Object>> adverts = mapper.readValue(req.getCarouselList(), List.class);
			if(adverts != null && adverts.size() > 0) {
				for(int i = 0; i < adverts.size(); i++) {
					MallAdvert advert = new MallAdvert(adverts.get(i));
					if(advert != null && advert.getId() != null) {
						mallAdvertMapper.updateByPrimaryKeySelective(advert);
					} else {
						Date now = new Date();
						advert.setStatus(1);
						advert.setPublishDate(now);
						advert.setCreateDate(now);
						mallAdvertMapper.insertSelective(advert);
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
	
	/**
	 * 轮播图查询
	 * @param advert
	 * @return
	 */
	@RequestMapping("/search")
	@ResponseBody
	public Map<String, Object> search(SearchAdvertReq req) {
		Map<String, Object> reMap = new HashMap<String, Object>();	
		try {
			Map<String, Object> params = MapUtils.java2Map(req);
			if(req.getPageNo() != null) {
				params.put("begin", (req.getPageNo() - 1) * (req.getPageSize() == null ? 20 : req.getPageSize()));
			} else {
				params.put("begin", 0);
			}
			List<MallAdvertVo> rtList = new ArrayList<MallAdvertVo>();
			List<MallAdvert> advertList = mallAdvertMapper.findList(params);
			if(advertList != null && advertList.size() > 0) {	// 时间格式化
				for(MallAdvert advert : advertList) {
					rtList.add(new MallAdvertVo(advert));
				}
			}
			reMap.put("data", rtList);
			
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
	 * 根据ID删除轮播图
	 * @param id
	 * @return
	 */
	@RequestMapping("/del")
	@ResponseBody
	public Map<String, Object> delAdvertById(Long id) {
		Map<String, Object> reMap = new HashMap<String, Object>();	
		try {
			mallAdvertMapper.offStore(id);
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
	 * 根据ID查询轮播图
	 * @param id
	 * @return
	 */
	@RequestMapping("/getAdvertById")
	@ResponseBody
	public Map<String, Object> getAdvertById(Long id) {
		Map<String, Object> reMap = new HashMap<String, Object>();	
		try {
			if(id == null) {
				reMap.put("status", Constants.FAIL_CODE);
				reMap.put("msg", "参数错误！");
				return reMap;
			}
			MallAdvert obj = mallAdvertMapper.selectByPrimaryKey(id);
			if(obj != null) {
				reMap.put("status", Constants.SUCCESS_CODE);
				reMap.put("msg", Constants.SUCCESS_MSG);
				reMap.put("data", new MallAdvertVo(obj));
			} else {
				reMap.put("status", Constants.FAIL_CODE);
				reMap.put("msg", "不存在记录");
			}
		} catch (Exception e) {
			e.printStackTrace();
			reMap.put("status", Constants.FAIL_CODE);
			reMap.put("msg", e.getMessage());
		}	
		return reMap;
	}
	
	/**
	 * 轮播图编辑接口
	 * @param advert
	 * @return
	 */
	@RequestMapping("/editAdvert")
	@ResponseBody
	public Map<String, Object> editAdvert(MallAdvertVo advertVo) {
		Map<String, Object> reMap = new HashMap<String, Object>();	
		try {
			if(advertVo == null || advertVo.getId() == null) {
				reMap.put("status", Constants.FAIL_CODE);
				reMap.put("msg", "参数错误！");
				return reMap;
			}
			mallAdvertMapper.updateByPrimaryKeySelective(new MallAdvert(advertVo));
			MallAdvert obj = mallAdvertMapper.selectByPrimaryKey(advertVo.getId());
			reMap.put("status", Constants.SUCCESS_CODE);
			reMap.put("msg", Constants.SUCCESS_MSG);
			if(obj != null) {
				reMap.put("data", obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			reMap.put("status", Constants.FAIL_CODE);
			reMap.put("msg", e.getMessage());
		}	
		return reMap;
	}
	
}