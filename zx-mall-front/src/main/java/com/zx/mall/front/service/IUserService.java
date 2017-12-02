package com.zx.mall.front.service;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.zx.mall.front.pojo.ExistSBudgetReq;
import com.zx.mall.front.pojo.LoginReq;
import com.zx.mall.front.pojo.SubscribeReq;

@Path("/user")
public interface IUserService {
	
	/**
	 * 用户登录
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login")
	Map<String, Object> login(LoginReq req);
	
	/**
	 * 用户退出
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/logout")
	Map<String, Object> logout(LoginReq req);
	
	/**
	 * 根据用户ID判断是否具有专项预算
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/existSBudget")
	Map<String, Object> existSBudget(ExistSBudgetReq req);
	
	/**
	 * 收藏-用户收藏商品
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/subscribePro")
	Map<String, Object> subscribePro(SubscribeReq req);
	
	/**
	 * 收藏-用户取消收藏商品
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/unSubscribePro")
	Map<String, Object> unSubscribePro(SubscribeReq req);
	
	/**
	 * 收藏-分页获取用户收藏/关注的商品列表
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getSubProList")
	Map<String, Object> getSubProList(SubscribeReq req);
	
	/**
	 * 预算-根据用户ID获取预算信息
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getBudgetInfo")
	Map<String, Object> getBudgetInfo(SubscribeReq req);
	
	/**
	 * 预算-根据用户ID判断该用户是否具有专项预算
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/existSBudget")
	Map<String, Object> existSBudget(SubscribeReq req);

}