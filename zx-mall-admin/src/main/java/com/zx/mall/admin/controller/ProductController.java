package com.zx.mall.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zx.mall.admin.pojo.ChgRecommendReq;
import com.zx.mall.admin.pojo.ChgStatusReq;
import com.zx.mall.admin.pojo.PageCommonReq;
import com.zx.mall.admin.pojo.SaveProductReq;
import com.zx.mall.admin.pojo.SearchProductReq;
import com.zx.mall.common.Constants;
import com.zx.mall.common.PageInfo;
import com.zx.mall.dao.MallProductMapper;
import com.zx.mall.dao.VenderProductSkuMapper;
import com.zx.mall.module.MallProduct;
import com.zx.mall.module.VenderProductSku;
import com.zx.mall.module.vo.MallProductDetailVo;
import com.zx.mall.module.vo.MallProductVo;
import com.zx.mall.util.MapUtils;
import com.zx.mall.util.StringUtil;

@Controller
@RequestMapping("/product")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ProductController {
	
	@Autowired
	private VenderProductSkuMapper venderProductSkuMapper;
	@Autowired
	private MallProductMapper mallProductMapper;
	
	/**
	 * 商品查询
	 * @return
	 */
	@RequestMapping("/search")
	@ResponseBody
	public Map<String, Object> search(SearchProductReq req) {
		Map<String, Object> reMap = new HashMap<String, Object>();	
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			if(req.getPageNo() != null) {
				params.put("begin", (req.getPageNo() - 1) * (req.getPageSize() == null ? 20 : req.getPageSize()));
			} else {
				params.put("begin", 0);
			}
			params.put("pageSize", req.getPageSize() == null ? 20 : req.getPageSize());
			if(req.getStatus() != null && -1 != req.getStatus())
				params.put("status", req.getStatus());	// 上下架 1:上架；2:下架；-1:全部
			if(req.getKindId() != null && -1 != req.getKindId())
				params.put("kindId", req.getKindId());	// 商品分类ID -1:查询所有
			if(req.getRecommend() != null && -1 != req.getRecommend())
				params.put("recommend", req.getRecommend());	// 是否推荐标识 1:是；0:否；-1：全部
			if(!StringUtil.isNullOrEmpty(req.getPname()))
				params.put("name", req.getPname());	// 商品名称，模糊查找
			
			int totalCount = mallProductMapper.findProductCount(params);
			List<MallProductVo> productList = mallProductMapper.findProductList(params);
			reMap.put("data", new PageInfo<MallProductVo>(req.getPageNo(), req.getPageSize(), totalCount, productList));
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
	 * 商品查询
	 * @return
	 */
	@RequestMapping("/getDetailById")
	@ResponseBody
	public Map<String, Object> getDetailById(String id) {
		Map<String, Object> reMap = new HashMap<String, Object>();	
		try {
			if(StringUtil.isNullOrEmpty(id)) {
				reMap.put("status", Constants.FAIL_CODE);
				reMap.put("msg", "参数错误！");
				return reMap;
			}
			
			MallProductDetailVo detailVo = mallProductMapper.getDetailById(Long.valueOf(id));
			if(detailVo != null) {
				reMap.put("data", detailVo);
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
	 * 查找订单系统未绑定商品sku个数
	 * @return
	 */
	@RequestMapping("/findCountUnbindingProSku")
	@ResponseBody
	public Map<String, Object> findCountUnbindingProSku() {
		Map<String, Object> reMap = new HashMap<String, Object>();	
		try {
			int count = venderProductSkuMapper.findCountUnbindingProSku();
			
			reMap.put("data", count);
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
	 * 查找订单系统未绑定商品列表
	 * @return
	 */
	@RequestMapping("/findUnbindingProSkuList")
	@ResponseBody
	public Map<String, Object> findUnbindingProSkuList(PageCommonReq req) {
		Map<String, Object> reMap = new HashMap<String, Object>();	
		try {
			
			Map<String, Object> params = MapUtils.java2Map(req);
			if(req.getPageNo() != null) {
				params.put("begin", (req.getPageNo() - 1) * (req.getPageSize() == null ? 20 : req.getPageSize()));
			} else {
				params.put("begin", 0);
			}
			List<VenderProductSku> venderSkuList = venderProductSkuMapper.findUnbindingProSkuList(params);
			if(venderSkuList != null && venderSkuList.size() > 0) {
				int count = venderProductSkuMapper.findCountUnbindingProSku();
				reMap.put("data", new PageInfo<VenderProductSku>(req.getPageNo(), req.getPageSize(), count, venderSkuList));
			} else {
				reMap.put("data", new PageInfo<VenderProductSku>(req.getPageNo(), req.getPageSize(), 0, new ArrayList()));
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
	 * 商品管理
	 * @param req
	 * @return
	 */
	@RequestMapping("/saveProduct")
	@ResponseBody
	public Map<String, Object> saveProduct(SaveProductReq req) {
		Map<String, Object> reMap = new HashMap<String, Object>();
		try {
			if(req == null || req.getKindId() == null || req.getCode() == null 
					|| StringUtil.isNullOrEmpty(req.getName()) || req.getPrice() == null
					|| req.getRecommend() == null || req.getStockamount() == null) {
				reMap.put("status", Constants.FAIL_CODE);
				reMap.put("msg", "参数错误！");
				return reMap;
			}
			MallProduct mallProduct = new MallProduct();
			mallProduct.setProductNo(req.getCode().toString());
			mallProduct.setProductName(req.getName());
			mallProduct.setPrice(req.getPrice());
			mallProduct.setKindId(req.getKindId());
			mallProduct.setRecommend(req.getRecommend());
			mallProduct.setStockamount(req.getStockamount());
			mallProduct.setStatus(req.getStatus());
			if(!StringUtil.isNullOrEmpty(req.getAttrStr()))
				mallProduct.setAttrStr(req.getAttrStr());
			if(!StringUtil.isNullOrEmpty(req.getAccessoryService()))
				mallProduct.setAccessoryService(req.getAccessoryService());
			if(!StringUtil.isNullOrEmpty(req.getHtmlPath()))
				mallProduct.setHtmlPath(req.getHtmlPath());
			if(!StringUtil.isNullOrEmpty(req.getSpicPath()))
				mallProduct.setSpicPath(req.getSpicPath());
			if(!StringUtil.isNullOrEmpty(req.getBpicPath()))
				mallProduct.setBpicPath(req.getBpicPath());
			if(req.getpId() != null && !StringUtil.isNullOrEmpty(req.getpId().toString())) {
				mallProduct.setProductId(req.getpId());
				mallProductMapper.updateByPrimaryKeySelective(mallProduct);
			} else {
				if(req.getvSkuId() == null) {
					reMap.put("status", Constants.FAIL_CODE);
					reMap.put("msg", "参数错误！");
					return reMap;
				}
				
				mallProductMapper.insertSelective(mallProduct);
				VenderProductSku venderProductSku = new VenderProductSku();
				venderProductSku.setvSkuId(req.getvSkuId().intValue());
				venderProductSku.setBinding(1);
				venderProductSkuMapper.updateByPrimaryKeySelective(venderProductSku);
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
	 * 批量上下架
	 * @return
	 */
	@RequestMapping("/batchChgStatus")
	@ResponseBody
	public Map<String, Object> batchChgStatus(ChgStatusReq req) {
		Map<String, Object> reMap = new HashMap<String, Object>();
		try {
			if(StringUtil.isNullOrEmpty(req.getIds()) || req.getStatus() == null) {
				reMap.put("status", Constants.FAIL_CODE);
				reMap.put("msg", "参数错误！");
				return reMap;
			}
			
			String[] idArray = req.getIds().split(",");
			if(idArray != null && idArray.length > 0) {
				for(String id : idArray) {
					mallProductMapper.updateStatus(Long.valueOf(id), req.getStatus());
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
	 * 批量推荐
	 * @return
	 */
	@RequestMapping("/batchRecommend")
	@ResponseBody
	public Map<String, Object> batchRecommend(ChgRecommendReq req) {
		Map<String, Object> reMap = new HashMap<String, Object>();
		try {
			if(StringUtil.isNullOrEmpty(req.getIds())) {
				reMap.put("status", Constants.FAIL_CODE);
				reMap.put("msg", "参数错误！");
				return reMap;
			}
			
			String[] idArray = req.getIds().split(",");
			if(idArray != null && idArray.length > 0) {
				for(String id : idArray) {
					mallProductMapper.updateRecommend(Long.valueOf(id), req.getFlag());
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