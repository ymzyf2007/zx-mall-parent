package com.zx.mall.api.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zx.mall.api.common.TokenUtil;
import com.zx.mall.api.pojo.OrderStatusReq;
import com.zx.mall.api.pojo.TokenReq;
import com.zx.mall.api.pojo.TokenRsp;
import com.zx.mall.api.pojo.VenderBudgetYearDetailReq;
import com.zx.mall.api.pojo.VenderBudgetYearReq;
import com.zx.mall.api.pojo.VenderCategorySubjectTypeReq;
import com.zx.mall.api.pojo.VenderCategorySubjectTypeReq2;
import com.zx.mall.api.pojo.VenderCompanyReq;
import com.zx.mall.api.pojo.VenderDepartmentReq;
import com.zx.mall.api.pojo.VenderFactoryOrderDetailReq;
import com.zx.mall.api.pojo.VenderFactoryOrderReq;
import com.zx.mall.api.pojo.VenderProductKindAttrReq;
import com.zx.mall.api.pojo.VenderProductKindBrandCfgReq;
import com.zx.mall.api.pojo.VenderProductKindBrandReq;
import com.zx.mall.api.pojo.VenderProductKindCfgAttrReq;
import com.zx.mall.api.pojo.VenderProductKindCfgAttrReq2;
import com.zx.mall.api.pojo.VenderProductKindCfgAttrVo;
import com.zx.mall.api.pojo.VenderProductSkuAttrReq;
import com.zx.mall.api.pojo.VenderProductSkuReq;
import com.zx.mall.api.pojo.VenderProductTypeReq;
import com.zx.mall.api.pojo.VenderSubjectReq;
import com.zx.mall.api.pojo.VenderSubjectReq2;
import com.zx.mall.api.pojo.VenderUserReq;
import com.zx.mall.api.service.IVenderService;
import com.zx.mall.dao.MallOrderMapper;
import com.zx.mall.dao.UserMapper;
import com.zx.mall.dao.VenderBudgetDetailMapper;
import com.zx.mall.dao.VenderBudgetYearMapper;
import com.zx.mall.dao.VenderCategorySubjectTypeMapper;
import com.zx.mall.dao.VenderCompanyMapper;
import com.zx.mall.dao.VenderDepartmentMapper;
import com.zx.mall.dao.VenderFactoryOrderDetailMapper;
import com.zx.mall.dao.VenderFactoryOrderMapper;
import com.zx.mall.dao.VenderOrderTrackMapper;
import com.zx.mall.dao.VenderProductKindAttrCfgMapper;
import com.zx.mall.dao.VenderProductKindAttrMapper;
import com.zx.mall.dao.VenderProductKindBrandCfgMapper;
import com.zx.mall.dao.VenderProductKindBrandMapper;
import com.zx.mall.dao.VenderProductKindMapper;
import com.zx.mall.dao.VenderProductSkuAttrMapper;
import com.zx.mall.dao.VenderProductSkuMapper;
import com.zx.mall.dao.VenderSubjectMapper;
import com.zx.mall.module.MallOrder;
import com.zx.mall.module.User;
import com.zx.mall.module.VenderBudgetDetail;
import com.zx.mall.module.VenderBudgetYear;
import com.zx.mall.module.VenderCategorySubjectType;
import com.zx.mall.module.VenderCompany;
import com.zx.mall.module.VenderDepartment;
import com.zx.mall.module.VenderFactoryOrder;
import com.zx.mall.module.VenderFactoryOrderDetail;
import com.zx.mall.module.VenderOrderTrack;
import com.zx.mall.module.VenderProductKind;
import com.zx.mall.module.VenderProductKindAttr;
import com.zx.mall.module.VenderProductKindAttrCfg;
import com.zx.mall.module.VenderProductKindBrand;
import com.zx.mall.module.VenderProductKindBrandCfg;
import com.zx.mall.module.VenderProductSku;
import com.zx.mall.module.VenderProductSkuAttr;
import com.zx.mall.module.VenderSubject;
import com.zx.mall.util.StringUtil;

@Service(value = "venderService")
public class VenderServiceImpl implements IVenderService {
	
	@Autowired
	private VenderProductKindMapper venderProductKindMapper;
	@Autowired
	private VenderProductKindAttrMapper venderProductKindAttrMapper;
	@Autowired
	private VenderProductKindAttrCfgMapper venderProductKindAttrCfgMapper;
	@Autowired
	private VenderProductKindBrandMapper venderProductKindBrandMapper;
	@Autowired
	private VenderProductKindBrandCfgMapper venderProductKindBrandCfgMapper;
	@Autowired
	private VenderProductSkuMapper venderProductSkuMapper;
	@Autowired
	private VenderProductSkuAttrMapper venderProductSkuAttrMapper;
	@Autowired
	private VenderCompanyMapper venderCompanyMapper;
	@Autowired
	private VenderDepartmentMapper venderDepartmentMapper;
//	@Autowired
//	private VenderBudgetTypeMapper venderBudgetTypeMapper;
	@Autowired
	private VenderSubjectMapper venderSubjectMapper;
//	@Autowired
//	private VenderBudgetTypeSubjectMapper venderBudgetTypeSubjectMapper;
	@Autowired
	private VenderCategorySubjectTypeMapper venderCategorySubjectTypeMapper;
	@Autowired
	private VenderFactoryOrderMapper venderFactoryOrderMapper;
	@Autowired
	private VenderFactoryOrderDetailMapper venderFactoryOrderDetailMapper;
	@Autowired
	private VenderOrderTrackMapper venderOrderTrackMapper;
	@Autowired
	private MallOrderMapper mallOrderMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private VenderBudgetYearMapper venderBudgetYearMapper;
	@Autowired
	private VenderBudgetDetailMapper venderBudgetDetailMapper;
	
	/**
	 * 1、获取token
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> getToken(TokenReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			TokenRsp tokenInfo = new TokenRsp();
			tokenInfo.setAccess_token(TokenUtil.getToken());
			tokenInfo.setExpires_at("-1");
			rtMap.put("data", tokenInfo);
			rtMap.put("success", true);
			rtMap.put("desc", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("status", false);
			rtMap.put("desc", e.getMessage());
		}
		return rtMap;
	}

	/**
	 * 2、保存订单系统推送的商品类别
	 * 商品类别分为：一级分类、二级分类、三级品类，所有商品都挂在三级品类下
	 * t_vender_product_kind
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitProType(VenderProductTypeReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getLid() == null || StringUtil.isNullOrEmpty(req.getCname()) 
					|| req.getPlid() == null || req.getTlevel() == null || req.getOperate() == null) {
				rtMap.put("success", false);
				rtMap.put("desc", "参数错误！");
				return rtMap;
			}
			// 验证token
			if(!TokenUtil.getToken().equals(req.getToken())) {
				rtMap.put("success", false);
				rtMap.put("desc", "token错误！");
				return rtMap;
			}
			
			VenderProductKind venderProductKind = new VenderProductKind();
			venderProductKind.setvKindId(req.getLid());
			venderProductKind.setvKindName(req.getCname());
			venderProductKind.setvParentId(req.getPlid());
			venderProductKind.setvLevel(req.getTlevel());
			
			if(1 == req.getOperate().intValue()) {
				venderProductKindMapper.insertSelective(venderProductKind);
			} else if(2 == req.getOperate().intValue()) {
				venderProductKindMapper.updateByPrimaryKeySelective(venderProductKind);
			} else if(3 == req.getOperate().intValue()) {
				venderProductKindMapper.deleteByPrimaryKey(venderProductKind.getvKindId());	// 删除是否要删除商城已绑定的分类，暂时不处理
			}
			
			rtMap.put("success", true);
			rtMap.put("desc", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("success", false);
			rtMap.put("desc", e.getMessage());
		}
		return rtMap;
	}

	/**
	 * 3、保存商品属性库
	 * 挂在三级品类下，这是所有的商品属性集合
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitProKindAttr(VenderProductKindAttrReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getAttrId() == null || StringUtil.isNullOrEmpty(req.getAttrName())) {
				rtMap.put("success", false);
				rtMap.put("desc", "参数错误！");
				return rtMap;
			}
			// 验证token
			if(!TokenUtil.getToken().equals(req.getToken())) {
				rtMap.put("success", false);
				rtMap.put("desc", "token错误！");
				return rtMap;
			}
			VenderProductKindAttr venderProductKindAttr = new VenderProductKindAttr();
			BeanUtils.copyProperties(req, venderProductKindAttr);
			
			if(1 == req.getOperate().intValue()) {
				venderProductKindAttrMapper.insertSelective(venderProductKindAttr);
			} else if(2 == req.getOperate().intValue()) {
				venderProductKindAttrMapper.updateByPrimaryKeySelective(venderProductKindAttr);
			} else if(3 == req.getOperate().intValue()) {
				venderProductKindAttrMapper.deleteByPrimaryKey(venderProductKindAttr.getAttrId());
			}
			
			rtMap.put("success", true);
			rtMap.put("desc", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("success", false);
			rtMap.put("desc", e.getMessage());
		}
		return rtMap;
	}

	/**
	 * 保存商品品类属性配置
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitProKindCfgAttr(VenderProductKindCfgAttrReq2 req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getKindId() == null || req.getData() == null) {
				rtMap.put("success", false);
				rtMap.put("desc", "参数错误！");
				return rtMap;
			}
			// 验证token
			if(!TokenUtil.getToken().equals(req.getToken())) {
				rtMap.put("success", false);
				rtMap.put("desc", "token错误！");
				return rtMap;
			}
			
			
			if(req.getData() != null && req.getData().size() > 0) {
				for(VenderProductKindCfgAttrVo vo : req.getData()) {
					
					VenderProductKindCfgAttrReq attrCfg = new VenderProductKindCfgAttrReq();
					attrCfg.setKindAttrId(vo.getKindAttrId());
					attrCfg.setKindId(req.getKindId());
					attrCfg.setAttrId(vo.getAttrId());
					attrCfg.setStatus(vo.getStatus());
					attrCfg.setOperate(vo.getOperate());
					
					VenderProductKindAttrCfg venderProductKindAttrCfg = new VenderProductKindAttrCfg();
					BeanUtils.copyProperties(attrCfg, venderProductKindAttrCfg);
					
					if(1 == vo.getOperate().intValue()) {
						venderProductKindAttrCfgMapper.insertSelective(venderProductKindAttrCfg);
					} else if(2 == vo.getOperate().intValue()) {
						venderProductKindAttrCfgMapper.updateByPrimaryKeySelective(venderProductKindAttrCfg);
					} else if(3 == vo.getOperate().intValue()) {
//						venderProductKindAttrCfgMapper.deleteByPrimaryKey(venderProductKindAttrCfg.getLid());
					}
				}
			} else {
				rtMap.put("success", false);
				rtMap.put("desc", "参数错误！");
				return rtMap;
			}
			
			rtMap.put("success", true);
			rtMap.put("desc", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("success", false);
			rtMap.put("desc", e.getMessage());
		}
		return rtMap;
	}

	/**
	 * 5、保存品牌信息
	 * （1）	品牌基本信息
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitProKindBrand(VenderProductKindBrandReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getbId() == null || StringUtil.isNullOrEmpty(req.getEnname())) {
				rtMap.put("success", false);
				rtMap.put("desc", "参数错误！");
				return rtMap;
			}
			// 验证token
			if(!TokenUtil.getToken().equals(req.getToken())) {
				rtMap.put("success", false);
				rtMap.put("desc", "token错误！");
				return rtMap;
			}
			VenderProductKindBrand venderProductKindBrand = new VenderProductKindBrand();
			BeanUtils.copyProperties(req, venderProductKindBrand);
			
			if(1 == req.getOperate().intValue()) {
				venderProductKindBrandMapper.insertSelective(venderProductKindBrand);
			} else if(2 == req.getOperate().intValue()) {
				venderProductKindBrandMapper.updateByPrimaryKeySelective(venderProductKindBrand);
			} else if(3 == req.getOperate().intValue()) {
				venderProductKindBrandMapper.deleteByPrimaryKey(venderProductKindBrand.getbId());
			}
			
			rtMap.put("success", true);
			rtMap.put("desc", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("success", false);
			rtMap.put("desc", e.getMessage());
		}
		return rtMap;
	}
	
	/**
	 * 6、保存品牌配置信息
	 * （2）	三级品类品牌配置表
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitProKindBrandCfg(VenderProductKindBrandCfgReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getbId() == null || StringUtil.isNullOrEmpty(req.getKindIds())) {
				rtMap.put("success", false);
				rtMap.put("desc", "参数错误！");
				return rtMap;
			}
			// 验证token
			if(!TokenUtil.getToken().equals(req.getToken())) {
				rtMap.put("success", false);
				rtMap.put("desc", "token错误！");
				return rtMap;
			}
			// 根据品牌ID先清空该品牌配置
			venderProductKindBrandCfgMapper.deleteByBid(req.getbId());
			// 再插入该品牌配置
			String[] kindIdArry = req.getKindIds().split(",");
			for(int i = 0; i < kindIdArry.length; i++) {
				VenderProductKindBrandCfg venderProductKindBrandCfg = new VenderProductKindBrandCfg();
				venderProductKindBrandCfg.setbId(req.getbId());
				venderProductKindBrandCfg.setKindId(Integer.valueOf(kindIdArry[i]));
				venderProductKindBrandCfgMapper.insertSelective(venderProductKindBrandCfg);
			}
			rtMap.put("success", true);
			rtMap.put("desc", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("success", false);
			rtMap.put("desc", e.getMessage());
		}
		return rtMap;
	}
	
	/**
	 * 7、保存商品信息
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitProSku(VenderProductSkuReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getvSkuId() == null || StringUtil.isNullOrEmpty(req.getvPname())
				|| req.getvKindId() == null || req.getvStockamount() == null) {
				rtMap.put("success", false);
				rtMap.put("desc", "参数错误！");
				return rtMap;
			}
			// 验证token
			if(!TokenUtil.getToken().equals(req.getToken())) {
				rtMap.put("success", false);
				rtMap.put("desc", "token错误！");
				return rtMap;
			}
			VenderProductSku venderProductSku = new VenderProductSku();
			BeanUtils.copyProperties(req, venderProductSku);
			
			if(1 == req.getOperate().intValue()) {
				venderProductSkuMapper.insertSelective(venderProductSku);
			} else if(2 == req.getOperate().intValue()) {
				venderProductSkuMapper.updateByPrimaryKeySelective(venderProductSku);
			} else if(3 == req.getOperate().intValue()) {
				venderProductSkuMapper.deleteByPrimaryKey(venderProductSku.getvSkuId());
			}
			
			if(req.getData() != null && req.getData().size() > 0) {
				for(VenderProductSkuAttrReq vo : req.getData()) {
					VenderProductSkuAttr venderProductSkuAttr = new VenderProductSkuAttr();
					BeanUtils.copyProperties(vo, venderProductSkuAttr);
					if(1 == vo.getOperate().intValue()) {
						venderProductSkuAttrMapper.insertSelective(venderProductSkuAttr);
					} else if(2 == vo.getOperate().intValue()) {
						venderProductSkuAttrMapper.updateByPrimaryKeySelective(venderProductSkuAttr);
					} else if(3 == vo.getOperate().intValue()) {
						venderProductSkuAttrMapper.deleteByPrimaryKey(venderProductSkuAttr.getSkuAttrId());
					}
				}
			}
			
			rtMap.put("success", true);
			rtMap.put("desc", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("success", false);
			rtMap.put("desc", e.getMessage());
		}
		return rtMap;
	}

	/**
	 * 8、保存集团公司信息
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitCompany(VenderCompanyReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getLid() == null 
				|| req.getOperate() == null) {
				rtMap.put("success", false);
				rtMap.put("desc", "参数错误！");
				return rtMap;
			}
			// 验证token
			if(!TokenUtil.getToken().equals(req.getToken())) {
				rtMap.put("success", false);
				rtMap.put("desc", "token错误！");
				return rtMap;
			}
			
			VenderCompany venderCompany = new VenderCompany();
			BeanUtils.copyProperties(req, venderCompany);
			if(1 == req.getOperate().intValue()) {
				venderCompanyMapper.insertSelective(venderCompany);
			} else if(2 == req.getOperate().intValue()) {
				venderCompanyMapper.updateByPrimaryKeySelective(venderCompany);
			} else if(3 == req.getOperate().intValue()) {
				venderCompanyMapper.deleteByPrimaryKey(venderCompany.getLid());
			}
			
			rtMap.put("success", true);
			rtMap.put("desc", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("success", false);
			rtMap.put("desc", e.getMessage());
		}
		return rtMap;
	}
	
	/**
	 * 9、保存客户组织架构
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitDepartment(VenderDepartmentReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getLid() == null || req.getCode() == null || req.getCname() == null 
					|| req.getClid() == null || req.getOperate() == null) {
				rtMap.put("success", false);
				rtMap.put("desc", "参数错误！");
				return rtMap;
			}
			// 验证token
			if(!TokenUtil.getToken().equals(req.getToken())) {
				rtMap.put("success", false);
				rtMap.put("desc", "token错误！");
				return rtMap;
			}
			
			VenderDepartment venderDepartment = new VenderDepartment();
			BeanUtils.copyProperties(req, venderDepartment);
			if(1 == req.getOperate().intValue()) {
				venderDepartmentMapper.insertSelective(venderDepartment);
			} else if(2 == req.getOperate().intValue()) {
				venderDepartmentMapper.updateByPrimaryKeySelective(venderDepartment);
			} else if(3 == req.getOperate().intValue()) {
				venderDepartmentMapper.deleteByPrimaryKey(venderDepartment.getLid());
			}
			
			rtMap.put("success", true);
			rtMap.put("desc", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("success", false);
			rtMap.put("desc", e.getMessage());
		}
		return rtMap;
	}
	
	/**
	 * 10、保存用户信息
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitUser(VenderUserReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getLid() == null || StringUtil.isNullOrEmpty(req.getAccount()) || StringUtil.isNullOrEmpty(req.getPassword()) 
					|| StringUtil.isNullOrEmpty(req.getMobile()) || req.getDlid() == null || req.getClid() == null || req.getOperate() == null) {
				rtMap.put("success", false);
				rtMap.put("desc", "参数错误！");
				return rtMap;
			}
			// 验证token
			if(!TokenUtil.getToken().equals(req.getToken())) {
				rtMap.put("success", false);
				rtMap.put("desc", "token错误！");
				return rtMap;
			}
			
			User user = new User();
			user.setId(req.getLid());
			user.setUsername(req.getUsername());
			user.setAccount(req.getAccount());
			user.setMobile(req.getMobile());
			user.setPassword(req.getPassword());
			user.setCreatetime(new Date());
			user.setStatus(1);
			user.setDlid(req.getDlid());
			user.setClid(req.getClid());
			if(!StringUtil.isNullOrEmpty(req.getPhone()))
				user.setTel(req.getPhone());
			
			if(1 == req.getOperate().intValue()) {
				userMapper.insertSelective(user);
			} else if(2 == req.getOperate().intValue()) {
				userMapper.updateByPrimaryKeySelective(user);
			} else if(3 == req.getOperate().intValue()) {
				userMapper.deleteByPrimaryKey(user.getId());
			}
			
			rtMap.put("success", true);
			rtMap.put("desc", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("success", false);
			rtMap.put("desc", e.getMessage());
		}
		return rtMap;
	}

//	/**
//	 * 保存预算类别表
//	 * @param req
//	 * @return
//	 */
//	@Override
//	public Map<String, Object> submitBudgetType(VenderBudgetTypeReq2 req) {
//		Map<String, Object> rtMap = new HashMap<String, Object>();
//		try {
//			// 参数验证
//			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getData() == null) {
//				rtMap.put("success", false);
//				rtMap.put("desc", "参数错误！");
//				return rtMap;
//			}
//			// 验证token
//			if(!TokenUtil.getToken().equals(req.getToken())) {
//				rtMap.put("success", false);
//				rtMap.put("desc", "token错误！");
//				return rtMap;
//			}
//			
//			if(req.getData() != null && req.getData().size() > 0) {
//				for(VenderBudgetTypeReq vo : req.getData()) {
//					VenderBudgetType venderBudgetType = new VenderBudgetType();
//					BeanUtils.copyProperties(vo, venderBudgetType);
//					if(1 == vo.getOperate().intValue()) {
//						venderBudgetTypeMapper.insertSelective(venderBudgetType);
//					} else if(2 == vo.getOperate().intValue()) {
//						venderBudgetTypeMapper.updateByPrimaryKeySelective(venderBudgetType);
//					} else if(3 == vo.getOperate().intValue()) {
//						venderBudgetTypeMapper.deleteByPrimaryKey(venderBudgetType.getLid());
//					}
//				}
//			}
//			
//			rtMap.put("success", true);
//			rtMap.put("desc", "成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//			rtMap.put("success", false);
//			rtMap.put("desc", e.getMessage());
//		}
//		return rtMap;
//	}

	/**
	 * 保存预算科目
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitSubject(VenderSubjectReq2 req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getData() == null) {
				rtMap.put("success", false);
				rtMap.put("desc", "参数错误！");
				return rtMap;
			}
			// 验证token
			if(!TokenUtil.getToken().equals(req.getToken())) {
				rtMap.put("success", false);
				rtMap.put("desc", "token错误！");
				return rtMap;
			}
			
			if(req.getData() != null && req.getData().size() > 0) {
				for(VenderSubjectReq vo : req.getData()) {
					if(StringUtil.isNullOrEmpty(vo.getBcode()) || StringUtil.isNullOrEmpty(vo.getCname()) || vo.getPlid() == null || vo.getClid() == null || StringUtil.isNullOrEmpty(vo.getYear())) {
						rtMap.put("success", false);
						rtMap.put("desc", "参数错误！");
						return rtMap;
					}
				}
				
				for(VenderSubjectReq vo : req.getData()) {
					VenderSubject venderSubject = new VenderSubject();
					BeanUtils.copyProperties(vo, venderSubject);
					if(1 == vo.getOperate().intValue()) {
						venderSubjectMapper.insertSelective(venderSubject);
					} else if(2 == vo.getOperate().intValue()) {
						venderSubjectMapper.updateByPrimaryKeySelective(venderSubject);
					} else if(3 == vo.getOperate().intValue()) {
						venderSubjectMapper.deleteByPrimaryKey(venderSubject.getLid());
					}
				}
			}
			
			rtMap.put("success", true);
			rtMap.put("desc", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("success", false);
			rtMap.put("desc", e.getMessage());
		}
		return rtMap;
	}

//	/**
//	 * 保存预算类别科目配置
//	 * @param req
//	 * @return
//	 */
//	@Override
//	public Map<String, Object> submitBudgetTypeSubject(VenderBudgetTypeSubjectReq2 req) {
//		Map<String, Object> rtMap = new HashMap<String, Object>();
//		try {
//			// 参数验证
//			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getData() == null) {
//				rtMap.put("success", false);
//				rtMap.put("desc", "参数错误！");
//				return rtMap;
//			}
//			// 验证token
//			if(!TokenUtil.getToken().equals(req.getToken())) {
//				rtMap.put("success", false);
//				rtMap.put("desc", "token错误！");
//				return rtMap;
//			}
//			
//			if(req.getData() != null && req.getData().size() > 0) {
//				for(VenderBudgetTypeSubjectReq vo : req.getData()) {
//					vo.setBtype(req.getBtype());
//					VenderBudgetTypeSubject venderBudgetTypeSubject = new VenderBudgetTypeSubject();
//					BeanUtils.copyProperties(vo, venderBudgetTypeSubject);
//					if(1 == vo.getOperate().intValue()) {
//						venderBudgetTypeSubjectMapper.insertSelective(venderBudgetTypeSubject);
//					} else if(2 == vo.getOperate().intValue()) {
//						venderBudgetTypeSubjectMapper.updateByPrimaryKeySelective(venderBudgetTypeSubject);
//					} else if(3 == vo.getOperate().intValue()) {
//						venderBudgetTypeSubjectMapper.deleteByPrimaryKey(venderBudgetTypeSubject.getLid());
//					}
//				}
//			}
//			
//			rtMap.put("success", true);
//			rtMap.put("desc", "成功");
//		} catch (Exception e) {
//			e.printStackTrace();
//			rtMap.put("success", false);
//			rtMap.put("desc", e.getMessage());
//		}
//		return rtMap;
//	}

	/**
	 * 12、保存预算科目同第三级的产品类别关系表
	 * 预算科目同第三级的产品类别，预算科目与产品类别是一对多关系
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitCategorySubjectType(VenderCategorySubjectTypeReq2 req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getClid() == null || req.getSlid() == null || req.getData() == null) {
				rtMap.put("success", false);
				rtMap.put("desc", "参数错误！");
				return rtMap;
			}
			// 验证token
			if(!TokenUtil.getToken().equals(req.getToken())) {
				rtMap.put("success", false);
				rtMap.put("desc", "token错误！");
				return rtMap;
			}
			
			if(req.getData() != null && req.getData().size() > 0) {
				// 根据品牌ID先清空该品牌配置
				venderCategorySubjectTypeMapper.deleteByClidAndSlid(req.getClid(), req.getSlid());
				for(VenderCategorySubjectTypeReq vo : req.getData()) {
					VenderCategorySubjectType venderCategorySubjectType = new VenderCategorySubjectType();
//					BeanUtils.copyProperties(vo, venderCategorySubjectType);
					venderCategorySubjectType.setSlid(req.getSlid());
					venderCategorySubjectType.setBcode(req.getBcode());
					venderCategorySubjectType.setPtype(vo.getPtype());
					venderCategorySubjectType.setClid(req.getClid());
					venderCategorySubjectTypeMapper.insertSelective(venderCategorySubjectType);
//					if(1 == vo.getOperate().intValue()) {
//						venderCategorySubjectTypeMapper.insertSelective(venderCategorySubjectType);
//					} else if(2 == vo.getOperate().intValue()) {
//						venderCategorySubjectTypeMapper.updateByPrimaryKeySelective(venderCategorySubjectType);
//					} else if(3 == vo.getOperate().intValue()) {
//						venderCategorySubjectTypeMapper.deleteByPrimaryKey(venderCategorySubjectType.getLid());
//					}
				}
			}
			
			rtMap.put("success", true);
			rtMap.put("desc", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("success", false);
			rtMap.put("desc", e.getMessage());
		}
		return rtMap;
	}
	
	/**
	 * 13、保存年度预算登记
	 * 年度预算分主表和明细表，（1）、集团总部制定年度计划（即添加主表信息），（2）初始设置（即添加各机构的科目预算）
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitBudgetYear(VenderBudgetYearReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getApplydlid() == null || req.getClid() == null 
					|| req.getApplydlid() == null || StringUtil.isNullOrEmpty(req.getYear()) || req.getInitamount() == null || req.getAdjustamount() == null 
					|| req.getExpenseamount() == null || req.getUsefulamount() == null || req.getOperate() == null) {
				rtMap.put("success", false);
				rtMap.put("desc", "参数错误！");
				return rtMap;
			}
			// 验证token
			if(!TokenUtil.getToken().equals(req.getToken())) {
				rtMap.put("success", false);
				rtMap.put("desc", "token错误！");
				return rtMap;
			}
			
			VenderBudgetYear venderBudgetYear = new VenderBudgetYear();  
			BeanUtils.copyProperties(req, venderBudgetYear);
			venderBudgetYear.setBtype(1);
			if(1 == req.getOperate().intValue()) {
				venderBudgetYearMapper.insertSelective(venderBudgetYear);
			} else if(2 == req.getOperate().intValue()) {
				venderBudgetYearMapper.updateByPrimaryKeySelective(venderBudgetYear);
			} else if(3 == req.getOperate().intValue()) {
				venderBudgetYearMapper.deleteByPrimaryKey(Integer.valueOf(String.valueOf(req.getLid())));
			}
			rtMap.put("success", true);
			rtMap.put("desc", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("success", false);
			rtMap.put("desc", e.getMessage());
		}
		return rtMap;
	}
	
	/**
	 * 14、年度预算明细[添加各机构的科目预算]
	 * 年度预算分主表和明细表，（1）、集团总部制定年度计划（即添加主表信息），（2）初始设置（即添加各机构的科目预算）
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitBudgetYearDetail(VenderBudgetYearDetailReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getBlid() == null || req.getSlid() == null 
					|| req.getAmount() == null || req.getExpenseamount() == null || req.getUsefulamount() == null || req.getOperate() == null) {
				rtMap.put("success", false);
				rtMap.put("desc", "参数错误！");
				return rtMap;
			}
			// 验证token
			if(!TokenUtil.getToken().equals(req.getToken())) {
				rtMap.put("success", false);
				rtMap.put("desc", "token错误！");
				return rtMap;
			}
			
			VenderBudgetDetail venderBudgetDetail = new VenderBudgetDetail();  
			BeanUtils.copyProperties(req, venderBudgetDetail);
			venderBudgetDetail.setBcode(000000);
			if(1 == req.getOperate().intValue()) {
				venderBudgetDetailMapper.insertSelective(venderBudgetDetail);
			} else if(2 == req.getOperate().intValue()) {
				venderBudgetDetailMapper.updateByPrimaryKeySelective(venderBudgetDetail);
			} else if(3 == req.getOperate().intValue()) {
				venderBudgetDetailMapper.deleteByPrimaryKey(Integer.valueOf(String.valueOf(req.getLid())));
			}
			rtMap.put("success", true);
			rtMap.put("desc", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("success", false);
			rtMap.put("desc", e.getMessage());
		}
		return rtMap;
	}

	/**
	 * 保存发货单信息
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitFactoryOrder(VenderFactoryOrderReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getLid() == null 
					|| req.getFolid() == null || req.getOrdernumber() == null || req.getOperate() == null) {
				rtMap.put("success", false);
				rtMap.put("desc", "参数错误！");
				return rtMap;
			}
			// 验证token
			if(!TokenUtil.getToken().equals(req.getToken())) {
				rtMap.put("success", false);
				rtMap.put("desc", "token错误！");
				return rtMap;
			}
			
			VenderFactoryOrder venderFactoryOrder = new VenderFactoryOrder();
			BeanUtils.copyProperties(req, venderFactoryOrder);
			if(1 == req.getOperate().intValue()) {
				venderFactoryOrderMapper.insertSelective(venderFactoryOrder);
			} else if(2 == req.getOperate().intValue()) {
				venderFactoryOrderMapper.updateByPrimaryKeySelective(venderFactoryOrder);
			} else if(3 == req.getOperate().intValue()) {
				venderFactoryOrderMapper.deleteByPrimaryKey(venderFactoryOrder.getLid());
			}
			
			rtMap.put("success", true);
			rtMap.put("desc", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("success", false);
			rtMap.put("desc", e.getMessage());
		}
		return rtMap;
	}

	/**
	 * 保存分单明细信息
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitFactoryOrderDetail(VenderFactoryOrderDetailReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getLid() == null 
					|| req.getOlid() == null || req.getPtype() == null || req.getPlid() == null || req.getOperate() == null) {
				rtMap.put("success", false);
				rtMap.put("desc", "参数错误！");
				return rtMap;
			}
			
			// 验证token
			if(!TokenUtil.getToken().equals(req.getToken())) {
				rtMap.put("success", false);
				rtMap.put("desc", "token错误！");
				return rtMap;
			}
			
			VenderFactoryOrderDetail venderFactoryOrderDetail = new VenderFactoryOrderDetail();
			BeanUtils.copyProperties(req, venderFactoryOrderDetail);
			if(1 == req.getOperate().intValue()) {
				venderFactoryOrderDetailMapper.insertSelective(venderFactoryOrderDetail);
			} else if(2 == req.getOperate().intValue()) {
				venderFactoryOrderDetailMapper.updateByPrimaryKeySelective(venderFactoryOrderDetail);
			} else if(3 == req.getOperate().intValue()) {
				venderFactoryOrderDetailMapper.deleteByPrimaryKey(venderFactoryOrderDetail.getLid());
			}
			
			rtMap.put("success", true);
			rtMap.put("desc", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("success", false);
			rtMap.put("desc", e.getMessage());
		}
		return rtMap;
	}

	/**
	 * 保存发货单和分单明细（上两个接口作废）
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitOrderInfo(VenderFactoryOrderReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getLid() == null 
					|| req.getFolid() == null || req.getOrdernumber() == null 
					|| req.getOperate() == null) {
				rtMap.put("success", false);
				rtMap.put("desc", "参数错误！");
				return rtMap;
			}
			// 验证token
			if(!TokenUtil.getToken().equals(req.getToken())) {
				rtMap.put("success", false);
				rtMap.put("desc", "token错误！");
				return rtMap;
			}
			
			VenderFactoryOrder venderFactoryOrder = new VenderFactoryOrder();
			BeanUtils.copyProperties(req, venderFactoryOrder);
			if(1 == req.getOperate().intValue()) {
				venderFactoryOrderMapper.insertSelective(venderFactoryOrder);
			} else if(2 == req.getOperate().intValue()) {
				venderFactoryOrderMapper.updateByPrimaryKeySelective(venderFactoryOrder);
			} else if(3 == req.getOperate().intValue()) {
				venderFactoryOrderMapper.deleteByPrimaryKey(venderFactoryOrder.getLid());
			}
			
			if(req.getData() != null && req.getData().size() > 0) {
				for(VenderFactoryOrderDetailReq vo : req.getData()) {
					vo.setOlid(req.getFolid());
					
					VenderFactoryOrderDetail venderFactoryOrderDetail = new VenderFactoryOrderDetail();
					BeanUtils.copyProperties(vo, venderFactoryOrderDetail);
					if(1 == vo.getOperate().intValue()) {
						venderFactoryOrderDetailMapper.insertSelective(venderFactoryOrderDetail);
					} else if(2 == vo.getOperate().intValue()) {
						venderFactoryOrderDetailMapper.updateByPrimaryKeySelective(venderFactoryOrderDetail);
					} else if(3 == vo.getOperate().intValue()) {
						venderFactoryOrderDetailMapper.deleteByPrimaryKey(venderFactoryOrderDetail.getLid());
					}
				}
			}
			
			rtMap.put("success", true);
			rtMap.put("desc", "成功");
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("success", false);
			rtMap.put("desc", e.getMessage());
		}
		return rtMap;
	}

	/**
	 * 更改主单订单状态
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> forderStatus(OrderStatusReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || StringUtil.isNullOrEmpty(req.getOrderno()) 
					|| req.getOrderstatus() == null) {
				rtMap.put("success", false);
				rtMap.put("desc", "参数错误！");
				return rtMap;
			}
			
			// 验证token
			if(!TokenUtil.getToken().equals(req.getToken())) {
				rtMap.put("success", false);
				rtMap.put("desc", "token错误！");
				return rtMap;
			}
			
			// 判断订单是否存在
			MallOrder mallOrder = mallOrderMapper.findOrderByOrderNo(req.getOrderno());
			if(mallOrder != null) {
				mallOrder.setOrderStatus(req.getOrderstatus());
				mallOrderMapper.updateByPrimaryKey(mallOrder);
				
				// 插入订单轨迹明细记录
				if(req.getRecord() != null && !StringUtil.isNullOrEmpty(req.getRecord().getOrdernumber())) {
					VenderOrderTrack orderTrack = req.getRecord();
					venderOrderTrackMapper.insertSelective(orderTrack);
				}
				
				rtMap.put("success", true);
				rtMap.put("desc", "成功");
			} else {
				rtMap.put("success", false);
				rtMap.put("desc", "订单不存在！");
				return rtMap;
			}
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("success", false);
			rtMap.put("desc", e.getMessage());
		}
		return rtMap;
	}

	/**
	 * 更改分单订单状态
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> orderStatus(OrderStatusReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || StringUtil.isNullOrEmpty(req.getOrderno()) 
					|| req.getOrderstatus() == null) {
				rtMap.put("success", false);
				rtMap.put("desc", "参数错误！");
				return rtMap;
			}
			
			// 验证token
			if(!TokenUtil.getToken().equals(req.getToken())) {
				rtMap.put("success", false);
				rtMap.put("desc", "token错误！");
				return rtMap;
			}
			
			
			// 判断订单是否存在
//			VenderFactoryOrderDetail venderFactoryOrderDetail = venderFactoryOrderDetailMapper.selectByPrimaryKey(Integer.parseInt(req.getOrderno()));
//			if(venderFactoryOrderDetail != null) {
//				venderFactoryOrderDetail.setStatus(req.getOrderstatus());
//				venderFactoryOrderDetailMapper.updateByPrimaryKey(venderFactoryOrderDetail);
//				// 插入订单轨迹明细记录
//				if(req.getRecord() != null && !StringUtil.isNullOrEmpty(req.getRecord().getOrdernumber())) {
//					VenderOrderTrack orderTrack = req.getRecord();
//					venderOrderTrackMapper.insertSelective(orderTrack);
//				}
//				rtMap.put("success", true);
//				rtMap.put("desc", "成功");
//			} else {
//				rtMap.put("success", false);
//				rtMap.put("desc", "订单不存在！");
//				return rtMap;
//			}
			
			
			VenderFactoryOrder venderFactoryOrder = venderFactoryOrderMapper.qryVenderFactoryOrder(req.getOrderno());
			if(venderFactoryOrder != null) {
				venderFactoryOrder.setStatus(req.getOrderstatus());
				venderFactoryOrderMapper.updateByPrimaryKey(venderFactoryOrder);
				// 插入订单轨迹明细记录
				if(req.getRecord() != null && !StringUtil.isNullOrEmpty(req.getRecord().getOrdernumber())) {
					VenderOrderTrack orderTrack = req.getRecord();
					venderOrderTrackMapper.insertSelective(orderTrack);
				}
				rtMap.put("success", true);
				rtMap.put("desc", "成功");
			} else {
				rtMap.put("success", false);
				rtMap.put("desc", "订单不存在！");
				return rtMap;
			}
		} catch (Exception e) {
			e.printStackTrace();
			rtMap.put("success", false);
			rtMap.put("desc", e.getMessage());
		}
		return rtMap;
	}

}