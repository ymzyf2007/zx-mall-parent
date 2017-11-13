package com.zx.mall.front.service;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.zx.mall.front.pojo.BaseReq;
import com.zx.mall.front.pojo.DelShopCartReq;
import com.zx.mall.front.pojo.KindInfoReq;
import com.zx.mall.front.pojo.QryProdDetailReq;
import com.zx.mall.front.pojo.QryProdsReq;
import com.zx.mall.front.pojo.SearchProdsReq;
import com.zx.mall.front.pojo.ShopCartReq;

/**
 * 首页
 *
 */
@Path("/main")
public interface IMainService {
	
	/**
	 * 1、商品首页（未登录）-获取首页轮播图
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/qryCarousel")
	Map<String, Object> qryCarousel(BaseReq req);
	
	/**
	 * 2、商品首页（未登录）-获取栏目信息[eg：热门推荐等]
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/qryMainKind")
	Map<String, Object> qryMainKind(BaseReq req);
	
	/**
	 * 获取商品分类信息
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findCategoryList")
	Map<String, Object> findCategoryList(BaseReq req);
	
	/**
	 * 3、商品首页（未登录）-全部商品分类【前三级分类】
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findAllCategoryList")
	Map<String, Object> findAllCategoryList(BaseReq req);
	
	/**
	 * 根据分类ID查询该分类下的商品品牌列表，该分类为第三级分类【品牌挂在第三级分类下】
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findBrandsByKindId")
	Map<String, Object> findBrandsByKindId(KindInfoReq req);
	
	/**
	 * 根据品牌ID和综合排序方式分页查询商品列表
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findProdsByParams")
	Map<String, Object> findProdsByParams(QryProdsReq req);
	
	/**
	 * 6、根据商品ID查询商品详细信息
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findProdDetail")
	Map<String, Object> findProdDetail(QryProdDetailReq req);
	
	/**
	 * 7、根据关键字搜索商品【支持商品名称、商品参数搜索】
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/searchProds")
	Map<String, Object> searchProds(SearchProdsReq req);
	
	/**
	 * 8、购物车商品保存
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/saveShopCart")
	Map<String, Object> saveShopCart(ShopCartReq req);
	
	/**
	 * 9、获取购物车商品接口
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getShopCart")
	Map<String, Object> getShopCart(ShopCartReq req);
	
	/**
	 * 10、删除购物车商品接口【支持批量删除】
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delShopCart")
	Map<String, Object> delShopCart(DelShopCartReq req);
	
	/**
	 * 11、分页查询推荐商品列表
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findRecommendProds")
	Map<String, Object> findRecommendProds(QryProdsReq req);
	
}