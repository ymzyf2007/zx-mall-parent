package com.zx.mall.api.service;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.zx.mall.api.pojo.OrderStatusReq;
import com.zx.mall.api.pojo.TokenReq;
import com.zx.mall.api.pojo.VenderBudgetTypeReq2;
import com.zx.mall.api.pojo.VenderBudgetTypeSubjectReq2;
import com.zx.mall.api.pojo.VenderCategorySubjectTypeReq2;
import com.zx.mall.api.pojo.VenderCompanyReq;
import com.zx.mall.api.pojo.VenderDepartmentReq;
import com.zx.mall.api.pojo.VenderFactoryOrderDetailReq;
import com.zx.mall.api.pojo.VenderFactoryOrderReq;
import com.zx.mall.api.pojo.VenderProductKindAttrReq;
import com.zx.mall.api.pojo.VenderProductKindBrandReq;
import com.zx.mall.api.pojo.VenderProductKindCfgAttrReq2;
import com.zx.mall.api.pojo.VenderProductSkuAttrReq;
import com.zx.mall.api.pojo.VenderProductSkuReq;
import com.zx.mall.api.pojo.VenderProductTypeReq;
import com.zx.mall.api.pojo.VenderSubjectReq2;

@Path("/api")
public interface IVenderService {
	
	/**
	 * 1、获取token
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/auth2/access_token")
	Map<String, Object> getToken(TokenReq req);
	
	/**
	 * 2、保存订单系统推送的商品类别
	 * 商品类别分为：一级分类、二级分类、三级品类，所有商品都挂在三级品类下
	 * t_vender_product_kind
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/submitProType")
	Map<String, Object> submitProType(VenderProductTypeReq req);
	
	/**
	 * 3、保存商品属性库
	 * 挂在三级品类下，这是所有的商品属性集合
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/submitProKindAttr")
	Map<String, Object> submitProKindAttr(VenderProductKindAttrReq req);
	
	/**
	 * 4、保存商品品类属性配置
	 * 挂在三级品类下，三级品类与属性是一对多关系
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/submitProKindCfgAttr")
	Map<String, Object> submitProKindCfgAttr(VenderProductKindCfgAttrReq2 req);

	/**
	 * 保存商品品类品牌信息
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/submitProKindBrand")
	Map<String, Object> submitProKindBrand(VenderProductKindBrandReq req);
	
	/**
	 * 保存订单系统推送的商品sku信息
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/submitProSku")
	Map<String, Object> submitProSku(VenderProductSkuReq req);
	
	/**
	 * 保存商品sku信息属性值
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/submitProSkuAttr")
	Map<String, Object> submitProSkuAttr(VenderProductSkuAttrReq req);
	
	/**
	 * 保存客户信息
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/submitCompany")
	Map<String, Object> submitCompany(VenderCompanyReq req);
	
	/**
	 * 保存客户组织架构
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/submitDepartment")
	Map<String, Object> submitDepartment(VenderDepartmentReq req);
	
	/**
	 * 保存预算类别表
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/submitBudgetType")
	Map<String, Object> submitBudgetType(VenderBudgetTypeReq2 req);
	
	/**
	 * 保存预算科目
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/submitSubject")
	Map<String, Object> submitSubject(VenderSubjectReq2 req);
	
	/**
	 * 保存预算类别科目配置
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/submitBudgetTypeSubject")
	Map<String, Object> submitBudgetTypeSubject(VenderBudgetTypeSubjectReq2 req);
	
	/**
	 * 保存预算科目同第三级的产品类别设置表
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/submitCategorySubjectType")
	Map<String, Object> submitCategorySubjectType(VenderCategorySubjectTypeReq2 req);
	
	/**
	 * 保存发货单信息
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/submitFactoryOrder")
	@Deprecated
	Map<String, Object> submitFactoryOrder(VenderFactoryOrderReq req);
	
	/**
	 * 保存分单明细信息
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/submitFactoryOrderDetail")
	@Deprecated
	Map<String, Object> submitFactoryOrderDetail(VenderFactoryOrderDetailReq req);
	
	/**
	 * 保存发货单和分单明细（上两个接口作废）
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/submitOrderInfo")
	Map<String, Object> submitOrderInfo(VenderFactoryOrderReq req);
	
	/**
	 * 更改主单订单状态
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/forderStatus")
	Map<String, Object> forderStatus(OrderStatusReq req);
	
	/**
	 * 更改分单订单状态
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/orderStatus")
	Map<String, Object> orderStatus(OrderStatusReq req);
}