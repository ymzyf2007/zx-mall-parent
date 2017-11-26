package com.zx.mall.front.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zx.mall.common.Constants;
import com.zx.mall.common.PageInfo;
import com.zx.mall.dao.MallAdvertMapper;
import com.zx.mall.dao.MallIndexKindMapper;
import com.zx.mall.dao.MallProductKindMapper;
import com.zx.mall.dao.MallProductMapper;
import com.zx.mall.dao.MallShopcarMapper;
import com.zx.mall.dao.UserMapper;
import com.zx.mall.dao.UserTokenMapper;
import com.zx.mall.dao.VenderProductKindBrandMapper;
import com.zx.mall.dao.VenderProductSkuAttrMapper;
import com.zx.mall.front.pojo.AdvertRsp;
import com.zx.mall.front.pojo.BaseReq;
import com.zx.mall.front.pojo.DelShopCartReq;
import com.zx.mall.front.pojo.KindBrandRsp;
import com.zx.mall.front.pojo.KindInfoReq;
import com.zx.mall.front.pojo.KindInfoRsp;
import com.zx.mall.front.pojo.QryProdDetailReq;
import com.zx.mall.front.pojo.QryProdsReq;
import com.zx.mall.front.pojo.SearchProdsReq;
import com.zx.mall.front.pojo.ShopCartReq;
import com.zx.mall.front.service.IMainService;
import com.zx.mall.module.MallAdvert;
import com.zx.mall.module.MallProduct;
import com.zx.mall.module.MallShopcar;
import com.zx.mall.module.User;
import com.zx.mall.module.UserToken;
import com.zx.mall.module.VenderProductKindBrand;
import com.zx.mall.module.vo.IndexKindProduct;
import com.zx.mall.module.vo.IndexKindRsp;
import com.zx.mall.module.vo.MallProductDetailVo;
import com.zx.mall.module.vo.MallProductKindVo;
import com.zx.mall.module.vo.MallProductVo;
import com.zx.mall.module.vo.MallShopcarVo;
import com.zx.mall.module.vo.VenderProductSkuAttrVo;
import com.zx.mall.util.MapUtils;
import com.zx.mall.util.StringUtil;

/**
 * 首页
 *
 */
@Service(value = "mainService")
public class MainServiceImpl implements IMainService {
	
	public static final String APP_ID = "zx_mall";
	
	@Autowired
	private MallAdvertMapper mallAdvertMapper;
	@Autowired
	private MallIndexKindMapper mallIndexKindMapper;
	@Autowired
	private MallProductKindMapper mallProductKindMapper;
	@Autowired
	private VenderProductKindBrandMapper venderProductKindBrandMapper;
	@Autowired
	private MallProductMapper mallProductMapper;
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserTokenMapper userTokenMapper;
	@Autowired
	private MallShopcarMapper mallShopcarMapper;
	@Autowired
	private VenderProductSkuAttrMapper venderProductSkuAttrMapper;

	/**
	 * 1、商品首页-获取首页轮播图
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> qryCarousel(BaseReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		// 参数验证
		if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId())) {
			rtMap.put("status", 500);
			rtMap.put("msg", "参数错误！");
			return rtMap;
		}
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("type", 1);
		param.put("status", 1);
		List<MallAdvert> advertList = mallAdvertMapper.findList(param);
		
		List<AdvertRsp> rtList = new ArrayList<AdvertRsp>();
		for(MallAdvert advert : advertList) {
			AdvertRsp rsp = new AdvertRsp();
			rsp.setIndex(advert.getSortId() == null ? "" : String.valueOf(advert.getSortId()));
			rsp.setUrl(advert.getLinkUrl());
			rsp.setImgUrl(advert.getPicPath());
			rsp.setTitle(advert.getTitle());
			rsp.setBgColor(advert.getBgColor());
			rtList.add(rsp);
		}
		
		rtMap.put("status", 200);
		rtMap.put("msg", "success");
		rtMap.put("data", rtList);
		return rtMap;
	}

	/**
	 * 2、商品首页-获取栏目信息[eg：热门推荐等]
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> qryMainKind(BaseReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		// 参数验证
		if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId())) {
			rtMap.put("status", 500);
			rtMap.put("msg", "参数错误！");
			return rtMap;
		}
		
		List<IndexKindRsp> mainKindList = mallIndexKindMapper.qryMainKindList();
		if(mainKindList != null && mainKindList.size() > 0) {
			for(IndexKindRsp kindRsp : mainKindList) {
				if(kindRsp.getProducts() != null && kindRsp.getProducts().size() > 0) {
					for(IndexKindProduct indexKindProduct : kindRsp.getProducts()) {
						if(indexKindProduct.getImgUrl().startsWith("http://") || indexKindProduct.getImgUrl().startsWith("https://")) {
							indexKindProduct.setImgUrl(indexKindProduct.getImgUrl());
						} else {
							indexKindProduct.setImgUrl(Constants.PREFIX_URI + indexKindProduct.getImgUrl());
						}
					}
				}
			}
			rtMap.put("data", mainKindList);
		} else {
			rtMap.put("data", new ArrayList<IndexKindRsp>());
		}
		rtMap.put("status", 200);
		rtMap.put("msg", "success");
		
		return rtMap;
	}

	/**
	 * 3、商品首页-全部商品分类【前三级分类】
	 * @return
	 */
	@Override
	public Map<String, Object> findAllCategoryList(BaseReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		// 参数验证
		if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId())) {
			rtMap.put("status", 500);
			rtMap.put("msg", "参数错误！");
			return rtMap;
		}
		
		List<MallProductKindVo> kindList = mallProductKindMapper.findKindList();
		if(kindList != null && kindList.size() > 0) {
			List<KindInfoRsp> rtList = new ArrayList<KindInfoRsp>();
			for(MallProductKindVo vo : kindList) {
				if(0 == vo.getParentId().intValue()) {
					KindInfoRsp info = new KindInfoRsp();
					info.setKindId(vo.getKindId());
					info.setKindName(vo.getKindName());
					info.setLevel((vo.getMenugrade() == null ? 0 : vo.getMenugrade()) + 1);
					info.setUrl(vo.getUrl());
					if(!StringUtil.isNullOrEmpty(vo.getImgUrl())) {
						if(vo.getImgUrl().startsWith("http://") || vo.getImgUrl().startsWith("https://")) {
							info.setImgUrl(vo.getImgUrl());
						} else {
							info.setImgUrl(Constants.PREFIX_URI + vo.getImgUrl());
						}
					}
					
					buildCategoryTree(info, vo.getKindId(), kindList);
					
					rtList.add(info);
				}
			}
			
			rtMap.put("data", rtList);
		} else {
			rtMap.put("data", new ArrayList<KindInfoRsp>());
		}
		rtMap.put("status", 200);
		rtMap.put("msg", "success");
		
		return rtMap;
	}
	
	/**
	 * 4、商品首页-分页查询推荐商品列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findRecommendProds(QryProdsReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId())) {
				rtMap.put("status", 500);
				rtMap.put("msg", "参数错误！");
				return rtMap;
			}
			
			Map<String, Object> params = MapUtils.java2Map(req);
			if(req.getPageNo() != null) {
				params.put("begin", (req.getPageNo() - 1) * (req.getPageSize() == null ? 20 : req.getPageSize()));
			} else {
				params.put("begin", 0);
			}
			
			if(req.getSortType() != null && 1 == req.getSortType()) {	// 按照推荐排序
				params.put("orderByScript", "order by t1.recommend desc limit "+ params.get("begin") +"," + params.get("pageSize"));
			} else if(req.getSortType() != null && 2 == req.getSortType()) {	// 按照价格排序
				params.put("orderByScript", "order by t1.price "+ ("asc".equals(req.getOrderBy()) ? "asc" : "desc") +" limit "+ params.get("begin") +"," + params.get("pageSize"));
			} else {
				params.put("orderByScript", "order by t1.recommend desc limit "+ params.get("begin") +"," + params.get("pageSize"));
			}
			params.put("homeRecommend", 1);
			params.put("status", 1);
			int totalCount = mallProductMapper.findProdCountByParams(params);
			if(totalCount > 0) {
				List<MallProductVo> productList = mallProductMapper.findProdsByParams(params);
				for(MallProductVo vo : productList) {
					if(!StringUtil.isNullOrEmpty(vo.getUploadPicpath())) {
						StringBuilder sb = new StringBuilder();
						String[] ss = vo.getUploadPicpath().split(",");
						for(String s : ss) {
							if(s.startsWith("http://") || s.startsWith("https://")) {
								sb.append(s).append(",");
							} else {
								sb.append(Constants.PREFIX_URI + s).append(",");
							}
						}
						vo.setUploadPicpath(sb.substring(0, sb.length() - 1));
					}
					
					if(!StringUtil.isNullOrEmpty(vo.getBpicPath())) {
						StringBuilder sb = new StringBuilder();
						String[] ss = vo.getBpicPath().split(",");
						for(String s : ss) {
							if(s.startsWith("http://") || s.startsWith("https://")) {
								sb.append(s).append(",");
							} else {
								sb.append(Constants.PREFIX_URI + s).append(",");
							}
						}
						vo.setBpicPath(sb.substring(0, sb.length() - 1));
					}
					
					if(!StringUtil.isNullOrEmpty(vo.getSpicPath())) {
						StringBuilder sb = new StringBuilder();
						String[] ss = vo.getSpicPath().split(",");
						for(String s : ss) {
							if(s.startsWith("http://") || s.startsWith("https://")) {
								sb.append(s).append(",");
							} else {
								sb.append(Constants.PREFIX_URI + s).append(",");
							}
						}
						vo.setSpicPath(sb.substring(0, sb.length() - 1));
					}
				}
				
				rtMap.put("data", new PageInfo<MallProductVo>(req.getPageNo(), req.getPageSize(), totalCount, productList));
			} else {
				rtMap.put("data", new PageInfo<MallProductVo>(req.getPageNo(), req.getPageSize(), 0, new ArrayList<MallProductVo>()));
			}
			
			rtMap.put("status", 200);
			rtMap.put("msg", "success");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("status", Constants.FAIL_CODE);
			rtMap.put("msg", e.getMessage());
		}
		
		return rtMap;
	}
	
	/**
	 * 5、商品首页-根据关键字搜索商品【支持商品名称、商品参数搜索】
	 * @param req
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> searchProds(SearchProdsReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId()) || StringUtil.isNullOrEmpty(req.getKeyword())) {
				rtMap.put("status", 500);
				rtMap.put("msg", "参数错误！");
				return rtMap;
			}
			
			Map<String, Object> params = MapUtils.java2Map(req);
			if(req.getPageNo() != null) {
				params.put("begin", (req.getPageNo() - 1) * (req.getPageSize() == null ? 20 : req.getPageSize()));
			} else {
				params.put("begin", 0);
			}
			
			List<MallProductDetailVo> list = mallProductMapper.searchProdsByParams(params);
			if(list != null && list.size() > 0) {
				int totalCount = mallProductMapper.searchProdsCountByParams(params);
				for(MallProductDetailVo productDetailVo : list) {
					if(!StringUtil.isNullOrEmpty(productDetailVo.getUploadPicpath())) {
						StringBuilder sb = new StringBuilder();
						String[] ss = productDetailVo.getUploadPicpath().split(",");
						for(String s : ss) {
							if(s.startsWith("http://") || s.startsWith("https://")) {
								sb.append(s).append(",");
							} else {
								sb.append(Constants.PREFIX_URI + s).append(",");
							}
						}
						productDetailVo.setUploadPicpath(sb.substring(0, sb.length() - 1));
					}
					
					if(!StringUtil.isNullOrEmpty(productDetailVo.getBpicPath())) {
						StringBuilder sb = new StringBuilder();
						String[] ss = productDetailVo.getBpicPath().split(",");
						for(String s : ss) {
							if(s.startsWith("http://") || s.startsWith("https://")) {
								sb.append(s).append(",");
							} else {
								sb.append(Constants.PREFIX_URI + s).append(",");
							}
						}
						productDetailVo.setBpicPath(sb.substring(0, sb.length() - 1));
					}
					
					if(!StringUtil.isNullOrEmpty(productDetailVo.getSpicPath())) {
						StringBuilder sb = new StringBuilder();
						String[] ss = productDetailVo.getSpicPath().split(",");
						for(String s : ss) {
							if(s.startsWith("http://") || s.startsWith("https://")) {
								sb.append(s).append(",");
							} else {
								sb.append(Constants.PREFIX_URI + s).append(",");
							}
						}
						productDetailVo.setSpicPath(sb.substring(0, sb.length() - 1));
					}
				}
				rtMap.put("data", new PageInfo<MallProductDetailVo>(req.getPageNo(), req.getPageSize(), totalCount, list));
			} else {
				rtMap.put("data", new PageInfo<MallProductDetailVo>(req.getPageNo(), req.getPageSize(), 0, new ArrayList<MallProductDetailVo>()));
			}
			rtMap.put("status", 200);
			rtMap.put("msg", "success");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("status", Constants.FAIL_CODE);
			rtMap.put("msg", e.getMessage());
		}
		
		return rtMap;
	}

	private void buildCategoryTree(KindInfoRsp pinfo, Long parentId, List<MallProductKindVo> kindList) {
		List<KindInfoRsp> childList = new ArrayList<KindInfoRsp>();
		for(MallProductKindVo vo : kindList) {
			if(parentId.intValue() == vo.getParentId().intValue()) {
				KindInfoRsp info = new KindInfoRsp();
				info.setKindId(vo.getKindId());
				info.setKindName(vo.getKindName());
				info.setLevel((vo.getMenugrade() == null ? 0 : vo.getMenugrade()) + 1);
				info.setUrl(vo.getUrl());
				if(!StringUtil.isNullOrEmpty(vo.getImgUrl())) {
					if(vo.getImgUrl().startsWith("http://") || vo.getImgUrl().startsWith("https://")) {
						info.setImgUrl(vo.getImgUrl());
					} else {
						info.setImgUrl(Constants.PREFIX_URI + vo.getImgUrl());
					}
				}
				
				buildCategoryTree(info, vo.getKindId(), kindList);
				childList.add(info);
			}
		}
		pinfo.setSubKindList(childList);
	}

	/**
	 * 6、根据分类ID查询该分类下的商品品牌列表，该分类为第三级分类【品牌挂在第三级分类下】
	 * @return
	 */
	@Override
	public Map<String, Object> findBrandsByKindId(KindInfoReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		// 参数验证
		if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId())) {
			rtMap.put("status", 500);
			rtMap.put("msg", "参数错误！");
			return rtMap;
		}

		// 根据父分类ID查找子分类列表
		List<Long> kindIdList = new ArrayList<Long>();
		kindIdList.add(req.getKindId());
		String kindIds = venderProductKindBrandMapper.getChildList(req.getKindId());
		if(!StringUtil.isNullOrEmpty(kindIds)) {
			String[] ids = kindIds.split(",");
			for(String id : ids) {
				if(!StringUtil.isNullOrEmpty(id))
					kindIdList.add(Long.valueOf(id));
			}
		}
		
		// 查询分类品牌信息，后面改成商城内部设置品牌信息，因目前商城后台缺少这块
		List<VenderProductKindBrand> brandList = venderProductKindBrandMapper.findBrandsByKindId(kindIdList/*req.getKindId()*/);
		if(brandList != null && brandList.size() > 0) {
			List<KindBrandRsp> rtList = new ArrayList<KindBrandRsp>();
			for(VenderProductKindBrand info : brandList) {
				rtList.add(new KindBrandRsp(info));
			}
			
			rtMap.put("data", rtList);
		} else {
			rtMap.put("data", new ArrayList<KindBrandRsp>());
		}
		rtMap.put("status", 200);
		rtMap.put("msg", "success");
		
		return rtMap;
	}

	/**
	 * 7、根据商品分类ID、品牌ID和综合排序方式分页查询商品列表
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findProdsByParams(QryProdsReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId())) {
				rtMap.put("status", 500);
				rtMap.put("msg", "参数错误！");
				return rtMap;
			}
//			if(!"asc".equalsIgnoreCase(req.getOrderBy()) || !"desc".equalsIgnoreCase(req.getOrderBy())) {
//				rtMap.put("status", 500);
//				rtMap.put("msg", "参数错误！");
//				return rtMap;
//			}
			
			Map<String, Object> params = MapUtils.java2Map(req);
			if(req.getPageNo() != null) {
				params.put("begin", (req.getPageNo() - 1) * (req.getPageSize() == null ? 20 : req.getPageSize()));
			} else {
				params.put("begin", 0);
			}
			
			if(req.getSortType() != null && 1 == req.getSortType()) {	// 按照推荐排序
				params.put("orderByScript", "order by t1.recommend desc limit "+ params.get("begin") +"," + params.get("pageSize"));
			} else if(req.getSortType() != null && 2 == req.getSortType()) {	// 按照价格排序
				params.put("orderByScript", "order by t1.price "+ ("asc".equals(req.getOrderBy()) ? "asc" : "desc") +" limit "+ params.get("begin") +"," + params.get("pageSize"));
			} else {
				params.put("orderByScript", "order by t1.recommend desc limit "+ params.get("begin") +"," + params.get("pageSize"));
			}
			
			int totalCount = mallProductMapper.findProdCountByParams(params);
			if(totalCount > 0) {
				List<MallProductVo> productList = mallProductMapper.findProdsByParams(params);
				for(MallProductVo vo : productList) {
					if(!StringUtil.isNullOrEmpty(vo.getUploadPicpath())) {
						StringBuilder sb = new StringBuilder();
						String[] ss = vo.getUploadPicpath().split(",");
						for(String s : ss) {
							if(s.startsWith("http://") || s.startsWith("https://")) {
								sb.append(s).append(",");
							} else {
								sb.append(Constants.PREFIX_URI + s).append(",");
							}
						}
						vo.setUploadPicpath(sb.substring(0, sb.length() - 1));
					}
					
					if(!StringUtil.isNullOrEmpty(vo.getBpicPath())) {
						StringBuilder sb = new StringBuilder();
						String[] ss = vo.getBpicPath().split(",");
						for(String s : ss) {
							if(s.startsWith("http://") || s.startsWith("https://")) {
								sb.append(s).append(",");
							} else {
								sb.append(Constants.PREFIX_URI + s).append(",");
							}
						}
						vo.setBpicPath(sb.substring(0, sb.length() - 1));
					}
					
					if(!StringUtil.isNullOrEmpty(vo.getSpicPath())) {
						StringBuilder sb = new StringBuilder();
						String[] ss = vo.getSpicPath().split(",");
						for(String s : ss) {
							if(s.startsWith("http://") || s.startsWith("https://")) {
								sb.append(s).append(",");
							} else {
								sb.append(Constants.PREFIX_URI + s).append(",");
							}
						}
						vo.setSpicPath(sb.substring(0, sb.length() - 1));
					}
				}
				
				rtMap.put("data", new PageInfo<MallProductVo>(req.getPageNo(), req.getPageSize(), totalCount, productList));
			} else {
				rtMap.put("data", new PageInfo<MallProductVo>(req.getPageNo(), req.getPageSize(), 0, new ArrayList<MallProductVo>()));
			}
			
			rtMap.put("status", 200);
			rtMap.put("msg", "success");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("status", Constants.FAIL_CODE);
			rtMap.put("msg", e.getMessage());
		}
		
		return rtMap;
	}

	/**
	 * 8、根据商品ID查询商品详细信息
	 * @param skuId
	 * @return
	 */
	@Override
	public Map<String, Object> findProdDetail(QryProdDetailReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getAppId()) || req.getSkuId() == null || !APP_ID.equals(req.getAppId())) {
				rtMap.put("status", 500);
				rtMap.put("msg", "参数错误！");
				return rtMap;
			}
			MallProductDetailVo productDetailVo = mallProductMapper.getDetailById(req.getSkuId());
			if(productDetailVo != null) {
				if(!StringUtil.isNullOrEmpty(productDetailVo.getUploadPicpath())) {
					StringBuilder sb = new StringBuilder();
					String[] ss = productDetailVo.getUploadPicpath().split(",");
					for(String s : ss) {
						if(s.startsWith("http://") || s.startsWith("https://")) {
							sb.append(s).append(",");
						} else {
							sb.append(Constants.PREFIX_URI + s).append(",");
						}
					}
					productDetailVo.setUploadPicpath(sb.substring(0, sb.length() - 1));
				}
				
				if(!StringUtil.isNullOrEmpty(productDetailVo.getBpicPath())) {
					StringBuilder sb = new StringBuilder();
					String[] ss = productDetailVo.getBpicPath().split(",");
					for(String s : ss) {
						if(s.startsWith("http://") || s.startsWith("https://")) {
							sb.append(s).append(",");
						} else {
							sb.append(Constants.PREFIX_URI + s).append(",");
						}
					}
					productDetailVo.setBpicPath(sb.substring(0, sb.length() - 1));
				}
				
				if(!StringUtil.isNullOrEmpty(productDetailVo.getSpicPath())) {
					StringBuilder sb = new StringBuilder();
					String[] ss = productDetailVo.getSpicPath().split(",");
					for(String s : ss) {
						if(s.startsWith("http://") || s.startsWith("https://")) {
							sb.append(s).append(",");
						} else {
							sb.append(Constants.PREFIX_URI + s).append(",");
						}
					}
					productDetailVo.setSpicPath(sb.substring(0, sb.length() - 1));
				}
				
				if(!StringUtil.isNullOrEmpty(productDetailVo.getHtmlPath())) {	// 处理图片，图片保存的是相对路径，这个待优化
					productDetailVo.setHtmlPath(productDetailVo.getHtmlPath().replaceAll("upload/upload/images/", Constants.SERVER_PREFIX_URI + "upload/upload/images/"));
				}
				
				List<VenderProductSkuAttrVo> attrList = venderProductSkuAttrMapper.getVenderProductSkuAttrsBySkuId(Integer.valueOf(String.valueOf(productDetailVo.getCode())));
				if(attrList != null && attrList.size() > 0) {
					productDetailVo.setAttribute(attrList);
				} else {
					productDetailVo.setAttribute(new ArrayList<VenderProductSkuAttrVo>());
				}
			}
			
			rtMap.put("status", 200);
			rtMap.put("msg", "success");
			rtMap.put("data", productDetailVo);
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("status", Constants.FAIL_CODE);
			rtMap.put("msg", e.getMessage());
		}
		
		return rtMap;
	}

	/**
	 * 9、购物车商品保存
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> saveShopCart(ShopCartReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId()) 
					|| StringUtil.isNullOrEmpty(req.getToken()) || req.getUid() == null 
					|| req.getSkuId() == null || req.getQuantity() == null) {
				rtMap.put("status", 500);
				rtMap.put("msg", "参数错误！");
				return rtMap;
			}
			
			User currentUser = userMapper.selectByPrimaryKey(Integer.valueOf(String.valueOf(req.getUid())));
			if(currentUser != null) {
				// 验证用户token
				UserToken userToken = userTokenMapper.selectByUserId(currentUser.getId());
				if(!req.getToken().equals(userToken.getToken())) {
					rtMap.put("status", 500);
					rtMap.put("msg", "token错误！");
					return rtMap;
				}
				// 验证产品
				MallProduct productInfo = mallProductMapper.selectByPrimaryKey(req.getSkuId());
				if(productInfo != null) {
					MallShopcar mallShopcar = new MallShopcar();
					mallShopcar.setSkuId(productInfo.getProductId());
					mallShopcar.setUserId(req.getUid());
					mallShopcar.setCreateTime(new Date());
					
					// 判断购物车是否存在
					Map<String, Object> filter = new HashMap<String, Object>();
					filter.put("skuId", productInfo.getProductId());
					filter.put("userId", req.getUid());
					List<MallShopcar> showCarList = mallShopcarMapper.findByParams(filter);
					if(showCarList != null && showCarList.size() > 0) {
						int newQuantity = (showCarList.get(0).getQuantity() == null ? 0 : showCarList.get(0).getQuantity()) + req.getQuantity();
						if(newQuantity <= 0) {	// 购物车删除该商品
							Map<String, Object> params = new HashMap<String, Object>();
							params.put("userId", showCarList.get(0).getUserId());
							params.put("skuId", showCarList.get(0).getSkuId());
							mallShopcarMapper.deleteByUidAndSkuId(params);
						} else {
							mallShopcar.setId(showCarList.get(0).getId());
							mallShopcar.setQuantity(newQuantity);
							mallShopcarMapper.updateByPrimaryKeySelective(mallShopcar);
						}
					} else {
						if(req.getQuantity() <= 0) {
							rtMap.put("status", 500);
							rtMap.put("msg", "添加购物车产品数量应大于0！");
							return rtMap;
						}
						
						mallShopcar.setQuantity(req.getQuantity());
						mallShopcarMapper.insertSelective(mallShopcar);
					}
					rtMap.put("status", 200);
					rtMap.put("msg", "success");
				} else {
					rtMap.put("status", 500);
					rtMap.put("msg", "产品不存在！");
					return rtMap;
				}
			} else {
				rtMap.put("status", 500);
				rtMap.put("msg", "用户不存在！");
				return rtMap;
			}
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("status", Constants.FAIL_CODE);
			rtMap.put("msg", e.getMessage());
		}
		
		return rtMap;
	}

	/**
	 * 10、获取购物车商品接口
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> getShopCart(ShopCartReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId()) 
					|| StringUtil.isNullOrEmpty(req.getToken()) || req.getUid() == null) {
				rtMap.put("status", 500);
				rtMap.put("msg", "参数错误！");
				return rtMap;
			}
			User currentUser = userMapper.selectByPrimaryKey(Integer.valueOf(String.valueOf(req.getUid())));
			if(currentUser != null) {
				// 验证用户token
				UserToken userToken = userTokenMapper.selectByUserId(currentUser.getId());
				if(!req.getToken().equals(userToken.getToken())) {
					rtMap.put("status", 500);
					rtMap.put("msg", "token错误！");
					return rtMap;
				}
				
				// 获取购物车商品
				Map<String, Object> filter = new HashMap<String, Object>();
				filter.put("userId", req.getUid());
				List<MallShopcarVo> shopcarProds = mallProductMapper.getShopcarProds(filter);
				if(shopcarProds != null && shopcarProds.size() > 0) {
					for(MallShopcarVo mallShopcarVo : shopcarProds) {
						if(!StringUtil.isNullOrEmpty(mallShopcarVo.getPic())) {
							StringBuilder sb = new StringBuilder();
							String[] ss = mallShopcarVo.getPic().split(",");
							for(String s : ss) {
								if(s.startsWith("http://") || s.startsWith("https://")) {
									sb.append(s).append(",");
								} else {
									sb.append(Constants.PREFIX_URI + s).append(",");
								}
							}
							mallShopcarVo.setPic(sb.substring(0, sb.length() - 1));
						}
						
						if(!StringUtil.isNullOrEmpty(mallShopcarVo.getBpicPath())) {
							StringBuilder sb = new StringBuilder();
							String[] ss = mallShopcarVo.getBpicPath().split(",");
							for(String s : ss) {
								if(s.startsWith("http://") || s.startsWith("https://")) {
									sb.append(s).append(",");
								} else {
									sb.append(Constants.PREFIX_URI + s).append(",");
								}
							}
							mallShopcarVo.setBpicPath(sb.substring(0, sb.length() - 1));
						}
						
						if(!StringUtil.isNullOrEmpty(mallShopcarVo.getSpicPath())) {
							StringBuilder sb = new StringBuilder();
							String[] ss = mallShopcarVo.getSpicPath().split(",");
							for(String s : ss) {
								if(s.startsWith("http://") || s.startsWith("https://")) {
									sb.append(s).append(",");
								} else {
									sb.append(Constants.PREFIX_URI + s).append(",");
								}
							}
							mallShopcarVo.setSpicPath(sb.substring(0, sb.length() - 1));
						}
					}
					
					rtMap.put("data", shopcarProds);
				} else {
					rtMap.put("data", new ArrayList<MallShopcarVo>());
				}
				rtMap.put("status", 200);
				rtMap.put("msg", "success");
			} else {
				rtMap.put("status", 500);
				rtMap.put("msg", "用户不存在！");
				return rtMap;
			}
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("status", Constants.FAIL_CODE);
			rtMap.put("msg", e.getMessage());
		}
		
		return rtMap;
	}

	/**
	 * 11、删除购物车商品接口【支持批量删除】
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> delShopCart(DelShopCartReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId()) 
					|| StringUtil.isNullOrEmpty(req.getToken()) || req.getUid() == null || StringUtil.isNullOrEmpty(req.getSkuIds())) {
				rtMap.put("status", 500);
				rtMap.put("msg", "参数错误！");
				return rtMap;
			}
			User currentUser = userMapper.selectByPrimaryKey(Integer.valueOf(String.valueOf(req.getUid())));
			if(currentUser != null) {
				// 验证用户token
				UserToken userToken = userTokenMapper.selectByUserId(currentUser.getId());
				if(!req.getToken().equals(userToken.getToken())) {
					rtMap.put("status", 500);
					rtMap.put("msg", "token错误！");
					return rtMap;
				}
				String[] ss = req.getSkuIds().split(",");
				Map<String, Object> params = new HashMap<String, Object>();
				for(String skuId : ss) {
					params.clear();
					params.put("userId", req.getUid());
					params.put("skuId", Long.valueOf(skuId));
					mallShopcarMapper.deleteByUidAndSkuId(params);
				}
				
				rtMap.put("status", 200);
				rtMap.put("msg", "success");
			} else {
				rtMap.put("status", 500);
				rtMap.put("msg", "用户不存在！");
				return rtMap;
			}
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("status", Constants.FAIL_CODE);
			rtMap.put("msg", e.getMessage());
		}
		
		return rtMap;
	}

}