package com.zx.mall.api.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zx.mall.api.common.TokenUtil;
import com.zx.mall.api.pojo.OrderStatusReq;
import com.zx.mall.api.pojo.TokenReq;
import com.zx.mall.api.pojo.TokenRsp;
import com.zx.mall.api.pojo.VenderBudgetTypeReq;
import com.zx.mall.api.pojo.VenderBudgetTypeReq2;
import com.zx.mall.api.pojo.VenderBudgetTypeSubjectReq;
import com.zx.mall.api.pojo.VenderBudgetTypeSubjectReq2;
import com.zx.mall.api.pojo.VenderCategorySubjectTypeReq;
import com.zx.mall.api.pojo.VenderCategorySubjectTypeReq2;
import com.zx.mall.api.pojo.VenderCompanyReq;
import com.zx.mall.api.pojo.VenderDepartmentReq;
import com.zx.mall.api.pojo.VenderFactoryOrderDetailReq;
import com.zx.mall.api.pojo.VenderFactoryOrderReq;
import com.zx.mall.api.pojo.VenderProductKindAttrReq;
import com.zx.mall.api.pojo.VenderProductKindBrandReq;
import com.zx.mall.api.pojo.VenderProductKindCfgAttrReq;
import com.zx.mall.api.pojo.VenderProductKindCfgAttrReq2;
import com.zx.mall.api.pojo.VenderProductKindCfgAttrVo;
import com.zx.mall.api.pojo.VenderProductSkuAttrReq;
import com.zx.mall.api.pojo.VenderProductSkuReq;
import com.zx.mall.api.pojo.VenderProductTypeReq;
import com.zx.mall.api.pojo.VenderSubjectReq;
import com.zx.mall.api.pojo.VenderSubjectReq2;
import com.zx.mall.api.service.IVenderService;
import com.zx.mall.dao.MallOrderMapper;
import com.zx.mall.dao.VenderBudgetTypeMapper;
import com.zx.mall.dao.VenderBudgetTypeSubjectMapper;
import com.zx.mall.dao.VenderCategorySubjectTypeMapper;
import com.zx.mall.dao.VenderCompanyMapper;
import com.zx.mall.dao.VenderDepartmentMapper;
import com.zx.mall.dao.VenderFactoryOrderDetailMapper;
import com.zx.mall.dao.VenderFactoryOrderMapper;
import com.zx.mall.dao.VenderOrderTrackMapper;
import com.zx.mall.dao.VenderProductKindAttrCfgMapper;
import com.zx.mall.dao.VenderProductKindAttrMapper;
import com.zx.mall.dao.VenderProductKindBrandMapper;
import com.zx.mall.dao.VenderProductKindMapper;
import com.zx.mall.dao.VenderProductSkuAttrMapper;
import com.zx.mall.dao.VenderProductSkuMapper;
import com.zx.mall.dao.VenderSubjectMapper;
import com.zx.mall.module.MallOrder;
import com.zx.mall.module.VenderBudgetType;
import com.zx.mall.module.VenderBudgetTypeSubject;
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
	private VenderProductSkuMapper venderProductSkuMapper;
	@Autowired
	private VenderProductSkuAttrMapper venderProductSkuAttrMapper;
	@Autowired
	private VenderCompanyMapper venderCompanyMapper;
	@Autowired
	private VenderDepartmentMapper venderDepartmentMapper;
	@Autowired
	private VenderBudgetTypeMapper venderBudgetTypeMapper;
	@Autowired
	private VenderSubjectMapper venderSubjectMapper;
	@Autowired
	private VenderBudgetTypeSubjectMapper venderBudgetTypeSubjectMapper;
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
	
	/**
	 * 获取token
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
	 * 提供接口给订单系统，订单系统实时推送接口
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
//				venderProductKindMapper.deleteByPrimaryKey(venderProductKind.getLid());	// 删除是否要删除商城已绑定的分类，暂时不处理
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
	 * 保存商品属性库
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
	 * 保存商品品类品牌信息
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitProKindBrand(VenderProductKindBrandReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getbId() == null || req.getKindId() == null || StringUtil.isNullOrEmpty(req.getEnname())) {
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
	 * 保存订单系统推送的商品sku信息
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
	 * 保存商品sku信息属性值
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitProSkuAttr(VenderProductSkuAttrReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getToken()) || req.getSkuAttrId() == null || req.getSkuId() == null 
				|| req.getKindId() == null || req.getAttrId() == null) {
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
			VenderProductSkuAttr venderProductSkuAttr = new VenderProductSkuAttr();
			BeanUtils.copyProperties(req, venderProductSkuAttr);
			
			if(1 == req.getOperate().intValue()) {
				venderProductSkuAttrMapper.insertSelective(venderProductSkuAttr);
			} else if(2 == req.getOperate().intValue()) {
				venderProductSkuAttrMapper.updateByPrimaryKeySelective(venderProductSkuAttr);
			} else if(3 == req.getOperate().intValue()) {
//				venderProductSkuAttrMapper.deleteByPrimaryKey(venderProductSkuAttr.getAttrId()));
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
	 * 保存客户信息
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
	 * 保存客户组织架构
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
	 * 保存预算类别表
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitBudgetType(VenderBudgetTypeReq2 req) {
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
				for(VenderBudgetTypeReq vo : req.getData()) {
					VenderBudgetType venderBudgetType = new VenderBudgetType();
					BeanUtils.copyProperties(vo, venderBudgetType);
					if(1 == vo.getOperate().intValue()) {
						venderBudgetTypeMapper.insertSelective(venderBudgetType);
					} else if(2 == vo.getOperate().intValue()) {
						venderBudgetTypeMapper.updateByPrimaryKeySelective(venderBudgetType);
					} else if(3 == vo.getOperate().intValue()) {
						venderBudgetTypeMapper.deleteByPrimaryKey(venderBudgetType.getLid());
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

	/**
	 * 保存预算类别科目配置
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitBudgetTypeSubject(VenderBudgetTypeSubjectReq2 req) {
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
				for(VenderBudgetTypeSubjectReq vo : req.getData()) {
					vo.setBtype(req.getBtype());
					VenderBudgetTypeSubject venderBudgetTypeSubject = new VenderBudgetTypeSubject();
					BeanUtils.copyProperties(vo, venderBudgetTypeSubject);
					if(1 == vo.getOperate().intValue()) {
						venderBudgetTypeSubjectMapper.insertSelective(venderBudgetTypeSubject);
					} else if(2 == vo.getOperate().intValue()) {
						venderBudgetTypeSubjectMapper.updateByPrimaryKeySelective(venderBudgetTypeSubject);
					} else if(3 == vo.getOperate().intValue()) {
						venderBudgetTypeSubjectMapper.deleteByPrimaryKey(venderBudgetTypeSubject.getLid());
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
	 * 保存预算科目同第三级的产品类别设置表
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> submitCategorySubjectType(VenderCategorySubjectTypeReq2 req) {
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
				for(VenderCategorySubjectTypeReq vo : req.getData()) {
					vo.setBtype(req.getBtype());
					VenderCategorySubjectType venderCategorySubjectType = new VenderCategorySubjectType();
					BeanUtils.copyProperties(vo, venderCategorySubjectType);
					if(1 == vo.getOperate().intValue()) {
						venderCategorySubjectTypeMapper.insertSelective(venderCategorySubjectType);
					} else if(2 == vo.getOperate().intValue()) {
						venderCategorySubjectTypeMapper.updateByPrimaryKeySelective(venderCategorySubjectType);
					} else if(3 == vo.getOperate().intValue()) {
						venderCategorySubjectTypeMapper.deleteByPrimaryKey(venderCategorySubjectType.getLid());
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