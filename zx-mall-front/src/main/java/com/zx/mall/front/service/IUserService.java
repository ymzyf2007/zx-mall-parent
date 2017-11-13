package com.zx.mall.front.service;

import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.zx.mall.front.pojo.ExistSBudgetReq;
import com.zx.mall.front.pojo.LoginReq;

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

}