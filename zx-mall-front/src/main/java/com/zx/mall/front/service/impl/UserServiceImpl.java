package com.zx.mall.front.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zx.mall.common.Constants;
import com.zx.mall.dao.UserMapper;
import com.zx.mall.dao.UserTokenMapper;
import com.zx.mall.dao.VenderBudgetDetailMapper;
import com.zx.mall.dao.VenderBudgetYearMapper;
import com.zx.mall.front.pojo.ExistSBudgetReq;
import com.zx.mall.front.pojo.LoginReq;
import com.zx.mall.front.pojo.SubjectBudgetVo;
import com.zx.mall.front.service.IUserService;
import com.zx.mall.module.User;
import com.zx.mall.module.UserToken;
import com.zx.mall.module.VenderBudgetDetail;
import com.zx.mall.module.VenderBudgetYear;
import com.zx.mall.util.StringUtil;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {
	
	public static final String APP_ID = "zx_mall";
	private final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserTokenMapper userTokenMapper;
	@Autowired
	private VenderBudgetYearMapper venderBudgetYearMapper;
	@Autowired
	private VenderBudgetDetailMapper venderBudgetDetailMapper;

	/**
	 * 用户登录
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> login(LoginReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();	
		try {
			if(StringUtils.isBlank(req.getAccount())) {
				rtMap.put("status", Constants.FAIL_CODE);
				rtMap.put("msg", "登陆名不能为空！");
				return rtMap;
			}
			if(StringUtils.isBlank(req.getPassword())) {
				rtMap.put("status", Constants.FAIL_CODE);
				rtMap.put("msg", "密码不能为空！");
				return rtMap;
			}
			User u = new User();
			u.setAccount(req.getAccount());
			u.setPassword(req.getPassword());
			User currentUser = userMapper.findLoginUser(u);
			if(currentUser != null) {
				// 清除之前token，并插入一条新的token
				userTokenMapper.deleteUserTokenByUserId(currentUser.getId());
				
				String token = UUID.randomUUID().toString();
				UserToken userToken = new UserToken();
				userToken.setUserId(currentUser.getId());
				userToken.setToken(token);
				userToken.setCreatetime(new Date());
				userTokenMapper.insertSelective(userToken);
				
				// 根据企业ID和部门ID获取部门年度预算
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("clid", currentUser.getClid());
				params.put("applydlid", currentUser.getDlid());
				VenderBudgetYear venderBudgetYear = venderBudgetYearMapper.findBudgetByCidAndDid(params);
				
				rtMap.put("status", Constants.SUCCESS_CODE);
				rtMap.put("msg", Constants.SUCCESS_MSG);
				Map<String, Object> data = new HashMap<String, Object>();
				data.put("token", token);
				data.put("uid", currentUser.getId());
				if(venderBudgetYear != null) {
					data.put("totalAmount", venderBudgetYear.getInitamount());
					data.put("useAmount", venderBudgetYear.getUsefulamount());
					
					List<VenderBudgetDetail> budgetList = venderBudgetDetailMapper.findByYearPrimaryKey(venderBudgetYear.getLid());
					if(budgetList != null && budgetList.size() > 0) {
						List<SubjectBudgetVo> subjectBudgets = new ArrayList<SubjectBudgetVo>();	// 科目预算列表
						for(VenderBudgetDetail budgetInfo : budgetList) {
							SubjectBudgetVo vo = new SubjectBudgetVo();
							vo.setBudgetTotalAmount(budgetInfo.getAmount());
							vo.setBudgetUseAmount(Float.valueOf(budgetInfo.getUsefulamount()));
							vo.setSubjectName(budgetInfo.getSname());
							subjectBudgets.add(vo);
						}
						data.put("subjectBudgets", subjectBudgets);
					}
				}
				rtMap.put("data", data);
			} else {
				rtMap.put("status", Constants.FAIL_CODE);
				rtMap.put("msg", "登录失败！");
				logger.info("用户不存在/密码错误");
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
	 * 用户退出
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> logout(LoginReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();	
		try {
			if(StringUtils.isBlank(req.getAccount())) {
				rtMap.put("status", Constants.FAIL_CODE);
				rtMap.put("msg", "登陆名不能为空！");
				return rtMap;
			}
			User u = new User();
			u.setAccount(req.getAccount());
			User currentUser = userMapper.findLoginUser(u);
			if(currentUser != null) {
				// 清除用户token
				userTokenMapper.deleteUserTokenByUserId(currentUser.getId());
				rtMap.put("status", Constants.SUCCESS_CODE);
				rtMap.put("msg", Constants.SUCCESS_MSG);
			} else {
				rtMap.put("status", Constants.FAIL_CODE);
				rtMap.put("msg", "用户退出失败！");
				logger.info("用户不存在");
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
	 * 根据用户ID判断是否具有专项预算
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> existSBudget(ExistSBudgetReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		// 参数验证
		if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId())) {
			rtMap.put("status", 500);
			rtMap.put("msg", "参数错误！");
			return rtMap;
		}
		
		rtMap.put("status", 200);
		rtMap.put("msg", "success");
		rtMap.put("exists", false);
		return rtMap;
	}

}