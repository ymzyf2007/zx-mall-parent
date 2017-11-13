package com.zx.mall.front.service;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.zx.mall.front.pojo.OrderReq;
import com.zx.mall.front.pojo.OrderTrackReq;
import com.zx.mall.front.pojo.UserAddressReq;

@Path("/order")
public interface IOrderService {
	
	/**
	 * 1、账号信息（收货地址）-新增地址/编辑地址
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/saveAddress")
	Map<String, Object> saveAddress(UserAddressReq req);
	
	/**
	 * 2、账号信息（收货地址）-根据用户ID获取收货地址列表
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAddressList")
	Map<String, Object> getAddressList(UserAddressReq req);
	
	/**
	 * 3、账号信息（收货地址）-删除收货地址
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delAddress")
	Map<String, Object> delAddress(UserAddressReq req);
	
	/**
	 * 1、用户下单
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/saveOrder")
	Map<String, Object> saveOrder(OrderReq req);
	
	/**
	 * 2、用户取消订单
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cancelOrder")
	Map<String, Object> cancelOrder(OrderReq req);
	
	/**
	 * 3、用户查询订单
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getOrders")
	Map<String, Object> getOrders(OrderReq req);
	
	/**
	 * 4、根据订单编号查询订单明细
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getOrderDetail")
	Map<String, Object> getOrderDetail(OrderReq req);
	
	/**
	 * 5、查询订单轨迹
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getOrderTrack")
	Map<String, Object> getOrderTrack(OrderTrackReq req);
	
	/**
	 * 下单前判断是否超过预算
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/judgeOrder")
	Map<String, Object> judgeOrder(OrderReq req);

}