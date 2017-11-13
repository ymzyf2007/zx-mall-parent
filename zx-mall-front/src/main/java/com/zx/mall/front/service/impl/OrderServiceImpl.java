package com.zx.mall.front.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zx.mall.common.Constants;
import com.zx.mall.common.PageInfo;
import com.zx.mall.dao.MallOrderDetailMapper;
import com.zx.mall.dao.MallOrderMapper;
import com.zx.mall.dao.MallProductMapper;
import com.zx.mall.dao.MallShopcarMapper;
import com.zx.mall.dao.MallUserAddressMapper;
import com.zx.mall.dao.UserMapper;
import com.zx.mall.dao.UserTokenMapper;
import com.zx.mall.dao.VenderFactoryOrderDetailMapper;
import com.zx.mall.dao.VenderFactoryOrderMapper;
import com.zx.mall.dao.VenderOrderTrackMapper;
import com.zx.mall.front.pojo.OrderProductDetail;
import com.zx.mall.front.pojo.OrderReq;
import com.zx.mall.front.pojo.OrderTrackReq;
import com.zx.mall.front.pojo.UserAddressReq;
import com.zx.mall.front.service.IOrderService;
import com.zx.mall.module.MallOrder;
import com.zx.mall.module.MallOrderDetail;
import com.zx.mall.module.MallProduct;
import com.zx.mall.module.MallUserAddress;
import com.zx.mall.module.User;
import com.zx.mall.module.UserToken;
import com.zx.mall.module.VenderFactoryOrder;
import com.zx.mall.module.VenderFactoryOrderDetail;
import com.zx.mall.module.VenderOrderTrack;
import com.zx.mall.module.vo.MallOrderDetailVo;
import com.zx.mall.module.vo.MallOrderVo;
import com.zx.mall.util.HttpClientUtil;
import com.zx.mall.util.RegexUtil;
import com.zx.mall.util.StringUtil;

@Service(value = "orderService")
public class OrderServiceImpl implements IOrderService {
	
	public static final String APP_ID = "zx_mall";
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserTokenMapper userTokenMapper;
	@Autowired
	private MallUserAddressMapper mallUserAddressMapper;
	@Autowired
	private MallProductMapper mallProductMapper;
	@Autowired
	private MallOrderMapper mallOrderMapper;
	@Autowired
	private MallOrderDetailMapper mallOrderDetailMapper;
	@Autowired
	private MallShopcarMapper mallShopcarMapper;
	@Autowired
	private VenderFactoryOrderMapper venderFactoryOrderMapper;
	@Autowired
	private VenderFactoryOrderDetailMapper venderFactoryOrderDetailMapper;
	@Autowired
	private VenderOrderTrackMapper venderOrderTrackMapper;
	
	/**
	 * 1、账号信息（收货地址）-新增地址/编辑地址
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> saveAddress(UserAddressReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId()) 
					|| StringUtil.isNullOrEmpty(req.getToken()) || req.getUserId() == null 
					|| StringUtil.isNullOrEmpty(req.getReceiveName()) || StringUtil.isNullOrEmpty(req.getReceiveMobile())
					|| StringUtil.isNullOrEmpty(req.getReceiveAddress())) {
				rtMap.put("status", 500);
				rtMap.put("msg", "参数错误！");
				return rtMap;
			}
			// 验证手机号码
			if(!RegexUtil.isMobile(req.getReceiveMobile())) {
				rtMap.put("status", 500);
				rtMap.put("msg", "不是合法手机号码！");
				return rtMap;
			}
			
			User currentUser = userMapper.selectByPrimaryKey(req.getUserId());
			if(currentUser != null) {
				// 验证用户token
				UserToken userToken = userTokenMapper.selectByUserId(currentUser.getId());
				if(!req.getToken().equals(userToken.getToken())) {
					rtMap.put("status", 500);
					rtMap.put("msg", "token错误！");
					return rtMap;
				}
				
				// 判断是否已勾选默认地址，如果已勾选默认地址，则已经选择的默认地址设置为非默认地址
				if(req.getDefaultAddress() != null && 1 == req.getDefaultAddress().intValue()) {
					mallUserAddressMapper.updateNotDefaultAddress(currentUser.getId());
				}
				
				MallUserAddress mallUserAddress = new MallUserAddress();
				BeanUtils.copyProperties(req, mallUserAddress);
				mallUserAddress.setModifyTime(new Date());
				if(mallUserAddress.getReceiverId() != null) {	// 修改
					mallUserAddressMapper.updateByPrimaryKeySelective(mallUserAddress);
				} else {
					mallUserAddress.setCreateTime(new Date());
					mallUserAddressMapper.insertSelective(mallUserAddress);
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
	 * 2、账号信息（收货地址）-根据用户ID获取收货地址列表
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> getAddressList(UserAddressReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId()) 
					|| StringUtil.isNullOrEmpty(req.getToken()) || req.getUserId() == null) {
				rtMap.put("status", 500);
				rtMap.put("msg", "参数错误！");
				return rtMap;
			}
			
			User currentUser = userMapper.selectByPrimaryKey(req.getUserId());
			if(currentUser != null) {
				// 验证用户token
				UserToken userToken = userTokenMapper.selectByUserId(currentUser.getId());
				if(!req.getToken().equals(userToken.getToken())) {
					rtMap.put("status", 500);
					rtMap.put("msg", "token错误！");
					return rtMap;
				}
				
				List<MallUserAddress> addressList = mallUserAddressMapper.selectAddressListByUserId(req.getUserId());
				if(addressList != null && addressList.size() > 0) {
					rtMap.put("data", addressList);
				} else {
					rtMap.put("data", new ArrayList<MallUserAddress>());
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
	 * 3、账号信息（收货地址）-删除收货地址
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> delAddress(UserAddressReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId()) 
					|| StringUtil.isNullOrEmpty(req.getToken()) || req.getUserId() == null 
					|| req.getReceiverId() == null) {
				rtMap.put("status", 500);
				rtMap.put("msg", "参数错误！");
				return rtMap;
			}
			
			User currentUser = userMapper.selectByPrimaryKey(req.getUserId());
			if(currentUser != null) {
				// 验证用户token
				UserToken userToken = userTokenMapper.selectByUserId(currentUser.getId());
				if(!req.getToken().equals(userToken.getToken())) {
					rtMap.put("status", 500);
					rtMap.put("msg", "token错误！");
					return rtMap;
				}
				
				MallUserAddress addressInfo = mallUserAddressMapper.selectByPrimaryKey(req.getReceiverId());
				if(addressInfo == null) {
					rtMap.put("status", 500);
					rtMap.put("msg", "地址不存在，删除失败！");
					return rtMap;
				} else {
					mallUserAddressMapper.deleteByPrimaryKey(req.getReceiverId());
					rtMap.put("status", 200);
					rtMap.put("msg", "success");
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
	 * 1、用户下单
	 * 目前没什么并发量、现在赶项目，暂时使用同步块，后面后话该功能
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> saveOrder(OrderReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId()) 
					|| StringUtil.isNullOrEmpty(req.getToken()) || req.getUserId() == null 
					|| req.getReceiverId() == null || req.getTotalCount() == null || req.getTotalPrice() == null
					|| req.getProductList() == null) {
				rtMap.put("status", 500);
				rtMap.put("msg", "参数错误！");
				return rtMap;
			}
			
			User currentUser = userMapper.selectByPrimaryKey(req.getUserId());
			if(currentUser != null) {
				// 验证用户token
				UserToken userToken = userTokenMapper.selectByUserId(currentUser.getId());
				if(!req.getToken().equals(userToken.getToken())) {
					rtMap.put("status", 500);
					rtMap.put("msg", "token错误！");
					return rtMap;
				}
				
				MallUserAddress addressInfo = mallUserAddressMapper.selectByPrimaryKey(req.getReceiverId());
				if(addressInfo == null) {
					rtMap.put("status", 500);
					rtMap.put("msg", "地址不存在！");
					return rtMap;
				}
				
				// 校验商品详细
				int totalProdCount = 0;
				float totalProdPrice = 0;
				List<MallOrderDetail> prodDetailList = new ArrayList<MallOrderDetail>();
				List<Map<String, Object>> venderSkuList = new ArrayList<Map<String, Object>>();
				if(req.getProductList().size() > 0) {
					for(OrderProductDetail productInfo : req.getProductList()) {
						if(productInfo.getSkuId() == null || productInfo.getQuantity() == null || productInfo.getPrice() == null || productInfo.getTotal() == null) {
							rtMap.put("status", 500);
							rtMap.put("msg", "参数错误！");
							return rtMap;
						}
						
						// 校验价格、库存是否正确
						MallProduct mallProduct = mallProductMapper.selectByPrimaryKey(productInfo.getSkuId());
						if(mallProduct == null) {
							rtMap.put("status", 500);
							rtMap.put("msg", "[" + productInfo.getSkuId() + "]商品不存在！");
							return rtMap;
						}
						if(Math.abs(mallProduct.getPrice()-productInfo.getPrice()) > 0) {
							rtMap.put("status", 500);
							rtMap.put("msg", "[" + productInfo.getSkuId() + "]商品下单价格跟系统价格不匹配！");
							return rtMap;
						}
						// 判断库存是否足够
						if((mallProduct.getStockamount().intValue() - productInfo.getQuantity().intValue()) < 0) {
							rtMap.put("status", 500);
							rtMap.put("msg", "[" + productInfo.getSkuId() + "]商品库存不足！");
							return rtMap;
						}
						
						// 预算控制，后续增加
						totalProdCount += productInfo.getQuantity();
						totalProdPrice += productInfo.getQuantity() * productInfo.getPrice();
						
						MallOrderDetail orderDtail = new MallOrderDetail();
						orderDtail.setSkuId(productInfo.getSkuId());
						orderDtail.setPrice(productInfo.getPrice());
						orderDtail.setAmount(productInfo.getQuantity());
						orderDtail.setTotal(productInfo.getQuantity() * productInfo.getPrice());
						orderDtail.setCreateDate(new Date());
						
						prodDetailList.add(orderDtail);
						
						Map<String, Object> venderSkuInfoMap = new HashMap<String, Object>();
						venderSkuInfoMap.put("lid", mallProduct.getProductNo());
						venderSkuInfoMap.put("num", productInfo.getQuantity());
						venderSkuInfoMap.put("price", productInfo.getPrice());	// 测试，需要修改
						venderSkuInfoMap.put("shellingprice", productInfo.getPrice());
						venderSkuInfoMap.put("wlid", 1);
						venderSkuList.add(venderSkuInfoMap);
					}
				}
				
				// 验证商品数量总数和总价是否一致
				if(Math.abs(totalProdCount-req.getTotalCount().intValue()) > 0) {
					rtMap.put("status", 500);
					rtMap.put("msg", "商品数量不一致！");
					return rtMap;
				}
				if(Math.abs(totalProdPrice-req.getTotalPrice()) > 0) {
					rtMap.put("status", 500);
					rtMap.put("msg", "订单总价不一致！");
					return rtMap;
				}
				
				if(prodDetailList.size() <= 0) {
					rtMap.put("status", 500);
					rtMap.put("msg", "商品数量不能为空！");
					return rtMap;
				}
				
				String orderNo = getTradeNo();
				MallOrder mallOrder = new MallOrder();
				mallOrder.setUserId(Long.valueOf(req.getUserId()));
				mallOrder.setOrderNo(orderNo);
				mallOrder.setOrderDate(new Date());
				mallOrder.setOrderStatus(1);	// 1:：待核对，2：已核对，3：已分单，4：已接单，5：已发货，6：待安装，7：已完结
				mallOrder.setOrderUnit("件");
				mallOrder.setReceiverId(req.getReceiverId());
				mallOrder.setTotalPrice(totalProdPrice);
				mallOrder.setPurchaseNum(totalProdCount);
				if(!StringUtil.isNullOrEmpty(req.getInvoiceHeader())) {	// 发票抬头
					mallOrder.setInvoiceHeader(req.getInvoiceHeader());
				}
				if(!StringUtil.isNullOrEmpty(req.getTaxpayerNum())) {	// 纳税人识别号
					mallOrder.setInvoiceHeader(req.getTaxpayerNum());
				}
				if(!StringUtil.isNullOrEmpty(req.getRemark())) {	// 备注
					mallOrder.setInvoiceHeader(req.getRemark());
				}
				
				mallOrderMapper.insertSelective(mallOrder);
				for(MallOrderDetail orderDtail : prodDetailList) {
					orderDtail.setOrderId(mallOrder.getId());
					orderDtail.setOrderNo(orderNo);
					mallOrderDetailMapper.insertSelective(orderDtail);
					
					// 删除购物车里的记录，如果立即购买可能购物车里面没有该商品
					Map<String, Object> params = new HashMap<String, Object>();	// 如果这个不是从购物车过来的，则需要删除购物车里的该商品？
					params.put("userId", req.getUserId());
					params.put("skuId", orderDtail.getSkuId());
					mallShopcarMapper.deleteByUidAndSkuId(params);
				}
				
				// 下单成功，则把订单信息推送给订单平台
				sendOrderToPlat(orderNo, venderSkuList, addressInfo.getReceiveMobile(), addressInfo.getReceiveName(), 
						totalProdCount, totalProdPrice, 302, 442);
				
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
	
	private void sendOrderToPlat(String orderNo, List<Map<String, Object>> skuList, 
			String purchaser, String purchasingunit, int amount, float total, int clid, int dlid) throws JsonProcessingException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("token", "900df893652545182dd4370003a7304c");
		params.put("ordernumber", orderNo);
		params.put("sku", skuList);
		params.put("ordertime", sdf.format(new Date()));
		params.put("purchaser", purchaser);
		params.put("purchasingunit", purchasingunit);
		params.put("amount", amount);
		params.put("total", total);
		params.put("clid", clid);	// 企业主键
		params.put("dlid", dlid);
		
		ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String body = mapper.writeValueAsString(params);
        System.out.println("body=" + body);
		String rsp = HttpClientUtil.doPost("http://39.108.149.156:8088/platform/api/order/submit", body);
		System.out.println("rsp=" + rsp);
	}

	public static String getTradeNo() {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		sb.append(sdf.format(new Date()));
		Random random = new Random();
		for (int i = 0; i < 18; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
	
	/**
	 * 2、用户取消订单
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> cancelOrder(OrderReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId()) 
					|| StringUtil.isNullOrEmpty(req.getToken()) || req.getUserId() == null 
					|| StringUtil.isNullOrEmpty(req.getOrderNo())) {
				rtMap.put("status", 500);
				rtMap.put("msg", "参数错误！");
				return rtMap;
			}
			
			User currentUser = userMapper.selectByPrimaryKey(req.getUserId());
			if(currentUser != null) {
				// 验证用户token
				UserToken userToken = userTokenMapper.selectByUserId(currentUser.getId());
				if(!req.getToken().equals(userToken.getToken())) {
					rtMap.put("status", 500);
					rtMap.put("msg", "token错误！");
					return rtMap;
				}
				
				// 检查订单是否存在
				MallOrder orderInfo = mallOrderMapper.findByUidAndOrderNo(Long.valueOf(req.getUserId()), req.getOrderNo());
				if(orderInfo == null) {
					rtMap.put("status", 500);
					rtMap.put("msg", "[" + req.getOrderNo() + "]订单不存在！");
					return rtMap;
				}
				
				// 取消订单
				mallOrderMapper.cancelOrder(Long.valueOf(req.getUserId()), req.getOrderNo());
				
				// 取消订单，把取消订单信息推送给订单平台
				sendCancelOrderToPlat(req.getOrderNo());
				
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

	private void sendCancelOrderToPlat(String orderNo) throws JsonProcessingException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("token", "900df893652545182dd4370003a7304c");
		params.put("ordernumber", orderNo);
		
		ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String body = mapper.writeValueAsString(params);
        System.out.println("body=" + body);
		String rsp = HttpClientUtil.doPost("http://39.108.149.156:8088/platform/api/order/cancel", body);
		System.out.println("rsp=" + rsp);
	}

	/**
	 * 3、用户查询订单
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> getOrders(OrderReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId()) 
					|| StringUtil.isNullOrEmpty(req.getToken()) || req.getUserId() == null) {
				rtMap.put("status", 500);
				rtMap.put("msg", "参数错误！");
				return rtMap;
			}
			
			User currentUser = userMapper.selectByPrimaryKey(req.getUserId());
			if(currentUser != null) {
				// 验证用户token
				UserToken userToken = userTokenMapper.selectByUserId(currentUser.getId());
				if(!req.getToken().equals(userToken.getToken())) {
					rtMap.put("status", 500);
					rtMap.put("msg", "token错误！");
					return rtMap;
				}
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("userId", req.getUserId());
				if(req.getPageNo() != null) {
					params.put("begin", (req.getPageNo() - 1) * (req.getPageSize() == null ? 20 : req.getPageSize()));
				} else {
					params.put("begin", 0);
				}
				params.put("pageSize", req.getPageSize() == null ? 20 : req.getPageSize());
				
				if(req.getStatus() != null && req.getStatus() != -1) {	// 订单状态，该参数主要用于订单查询，默认查询所有订单状态订单
					params.put("status", req.getStatus());
				}
				if(!StringUtil.isNullOrEmpty(req.getStartDate())) {	// 订单开始时间
					params.put("startDate", sdf.parse(req.getStartDate()));
				}
				if(!StringUtil.isNullOrEmpty(req.getEndDate())) {	// 订单结束时间
					params.put("endDate", sdf.parse(req.getEndDate()));
				}
				if(!StringUtil.isNullOrEmpty(req.getKeyword())) {	// 商品名称/商品编号/订单编号 搜索
					params.put("keyword", req.getKeyword());
				}
				
				int totalCount = mallOrderMapper.findOrderCount(params);
				List<MallOrderVo> orderList = mallOrderMapper.findOrderList(params);
				if(orderList != null && orderList.size() > 0) {
					for(MallOrderVo vo : orderList) {
						if(vo.getProductList() != null && vo.getProductList().size() > 0) {
							for(MallOrderDetailVo detailVo : vo.getProductList()) {
								if(!StringUtil.isNullOrEmpty(detailVo.getBpicPath())) {
									StringBuilder sb = new StringBuilder();
									String[] ss = detailVo.getBpicPath().split(",");
									for(String s : ss) {
										if(s.startsWith("http://") || s.startsWith("https://")) {
											sb.append(s).append(",");
										} else {
											sb.append(Constants.PREFIX_URI + s).append(",");
										}
									}
									detailVo.setBpicPath(sb.substring(0, sb.length() - 1));
								}
								
								if(!StringUtil.isNullOrEmpty(detailVo.getSpicPath())) {
									StringBuilder sb = new StringBuilder();
									String[] ss = detailVo.getSpicPath().split(",");
									for(String s : ss) {
										if(s.startsWith("http://") || s.startsWith("https://")) {
											sb.append(s).append(",");
										} else {
											sb.append(Constants.PREFIX_URI + s).append(",");
										}
									}
									detailVo.setSpicPath(sb.substring(0, sb.length() - 1));
								}
							}
						}
					}
					rtMap.put("data", new PageInfo<MallOrderVo>(req.getPageNo(), req.getPageSize(), totalCount, orderList));
				} else {
					rtMap.put("data", new ArrayList<MallOrderVo>());
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
	 * 4、根据订单编号查询订单明细
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> getOrderDetail(OrderReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId()) 
					|| StringUtil.isNullOrEmpty(req.getToken()) || req.getUserId() == null || StringUtil.isNullOrEmpty(req.getOrderNo())) {
				rtMap.put("status", 500);
				rtMap.put("msg", "参数错误！");
				return rtMap;
			}
			
			User currentUser = userMapper.selectByPrimaryKey(req.getUserId());
			if(currentUser != null) {
				// 验证用户token
				UserToken userToken = userTokenMapper.selectByUserId(currentUser.getId());
				if(!req.getToken().equals(userToken.getToken())) {
					rtMap.put("status", 500);
					rtMap.put("msg", "token错误！");
					return rtMap;
				}
				
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("userId", req.getUserId());
				params.put("orderNo", req.getOrderNo());
				MallOrderVo orderDetail = mallOrderMapper.getOrderDetail(params);
				if(orderDetail != null) {
					if(orderDetail.getProductList() != null && orderDetail.getProductList().size() > 0) {
						for(MallOrderDetailVo detailVo : orderDetail.getProductList()) {
							if(!StringUtil.isNullOrEmpty(detailVo.getBpicPath())) {
								StringBuilder sb = new StringBuilder();
								String[] ss = detailVo.getBpicPath().split(",");
								for(String s : ss) {
									if(s.startsWith("http://") || s.startsWith("https://")) {
										sb.append(s).append(",");
									} else {
										sb.append(Constants.PREFIX_URI + s).append(",");
									}
								}
								detailVo.setBpicPath(sb.substring(0, sb.length() - 1));
							}
							
							if(!StringUtil.isNullOrEmpty(detailVo.getSpicPath())) {
								StringBuilder sb = new StringBuilder();
								String[] ss = detailVo.getSpicPath().split(",");
								for(String s : ss) {
									if(s.startsWith("http://") || s.startsWith("https://")) {
										sb.append(s).append(",");
									} else {
										sb.append(Constants.PREFIX_URI + s).append(",");
									}
								}
								detailVo.setSpicPath(sb.substring(0, sb.length() - 1));
							}
						}
					}
					
					// 查询该订单收货地址
					MallUserAddress orderAddress = mallUserAddressMapper.selectByPrimaryKey(orderDetail.getReceiverId());
					orderDetail.setAddress(orderAddress);
					
					VenderFactoryOrder venderFactoryOrder = venderFactoryOrderMapper.qryVenderFactoryOrder(req.getOrderNo());
					if(venderFactoryOrder != null) {
						orderDetail.setMainDeliveryOrder(venderFactoryOrder);
						List<VenderFactoryOrderDetail> deliveryList = venderFactoryOrderDetailMapper.findFactoryOrderDetailByFolid(venderFactoryOrder.getFolid());
						if(deliveryList != null && deliveryList.size() > 0) {
							orderDetail.setDeliveryOrders(deliveryList);
						} else {
							orderDetail.setDeliveryOrders(new ArrayList<VenderFactoryOrderDetail>());
						}
					}
					rtMap.put("data", orderDetail);
					
					rtMap.put("status", 200);
					rtMap.put("msg", "success");
				} else {
					rtMap.put("status", 500);
					rtMap.put("msg", "订单不存在！");
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
	 * 5、查询订单轨迹
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> getOrderTrack(OrderTrackReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		try {
			// 参数验证
			if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId()) 
					|| StringUtil.isNullOrEmpty(req.getToken()) || req.getUserId() == null) {
				rtMap.put("status", 500);
				rtMap.put("msg", "参数错误！");
				return rtMap;
			}
			if(StringUtil.isNullOrEmpty(req.getOrderNo()) && StringUtil.isNullOrEmpty(req.getSplitNo())) {
				rtMap.put("status", 500);
				rtMap.put("msg", "参数错误！");
				return rtMap;
			}
			
			User currentUser = userMapper.selectByPrimaryKey(req.getUserId());
			if(currentUser != null) {
				// 验证用户token
				UserToken userToken = userTokenMapper.selectByUserId(currentUser.getId());
				if(!req.getToken().equals(userToken.getToken())) {
					rtMap.put("status", 500);
					rtMap.put("msg", "token错误！");
					return rtMap;
				}
				
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("type", req.getType());
				if(!StringUtil.isNullOrEmpty(req.getOrderNo())) {
					params.put("orderNo", req.getOrderNo());
				}
				if(!StringUtil.isNullOrEmpty(req.getSplitNo())) {
					params.put("splitNo", req.getSplitNo());
				}
				List<VenderOrderTrack> orderTrackList = venderOrderTrackMapper.selectByParams(params);
				if(orderTrackList != null && orderTrackList.size() > 0) {
					rtMap.put("data", orderTrackList);
				} else {
					rtMap.put("data", new ArrayList<VenderOrderTrack>());
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
	 * 下单前判断是否超过预算
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> judgeOrder(OrderReq req) {
		Map<String, Object> rtMap = new HashMap<String, Object>();
		// 参数验证
		if(StringUtil.isNullOrEmpty(req.getAppId()) || !APP_ID.equals(req.getAppId())) {
			rtMap.put("status", 500);
			rtMap.put("msg", "参数错误！");
			return rtMap;
		}
		
		rtMap.put("status", 200);
		rtMap.put("msg", "success");
		rtMap.put("data", true);
		return rtMap;
	}

}