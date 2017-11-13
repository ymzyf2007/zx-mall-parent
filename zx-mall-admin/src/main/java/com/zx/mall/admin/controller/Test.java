package com.zx.mall.admin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.zx.mall.front.pojo.OrderProductDetail;
import com.zx.mall.util.HttpClientUtil;

public class Test {
	
	public static String getTradeNo() {
		String base = "01234567890123456789";
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		sb.append(sdf.format(new Date()));
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		
		
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("hosttel", "12009");
//		params.put("timestamp", "1505704024440");
//		params.put("sign", "2EBF185CB90F87D861BE6FE6004C377E");
//		
//		ObjectMapper mapper = new ObjectMapper();
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        String body = mapper.writeValueAsString(params);
//        System.out.println("body=" + body);
//		String rsp = HttpClientUtil.doPost("http://10.194.19.104:8080/wx/rs/wechat/accesstoken", body);
//		System.out.println("rsp=" + rsp);
		
//		System.out.println(getTradeNo());
	}
	
	public static void mallOrder() {
//		OrderReq req = new OrderReq();
//		private Integer userId;	// 用户ID
//		private String token;	// TOKEN
//		private Long receiverId; // 收货地址ID
//		private Integer totalCount; // 总共商品数量
//		private Float totalPrice; // 总金额
//		private List<OrderProductDetail> productList = new ArrayList<OrderProductDetail>();
	}
	
	public static void venderOrder() throws JsonProcessingException {
		Random random = new Random();
		int[] lidArray = {447, 451};
		int[] priceArray = {100, 105};
		for(int i = 0; i < 20; i++) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("token", "900df893652545182dd4370003a7304c");
			params.put("ordernumber", getTradeNo());
			List<Map<String, Object>> skuList = new ArrayList<Map<String, Object>>();
			int purseCount = 0;	// 购买数量
			int totalPrice = 0;
			for(int j = 0; j < 2; j++) {
				Map<String, Object> sku = new HashMap<String, Object>();
				sku.put("lid", lidArray[j]);
				int r = random.nextInt(10);
				int num = 15 - r;
				purseCount += num;
				sku.put("num", num);
				sku.put("price", priceArray[j]);
				sku.put("shellingprice", priceArray[j]);
				totalPrice += num * priceArray[j];
				sku.put("wlid", 1);
				skuList.add(sku);
			}
			params.put("sku", skuList);
			params.put("ordertime", sdf.format(new Date()));
			params.put("purchaser", "18588880081");
			params.put("purchasingunit", "中国电信集团公司广东省分公司综合部");
			params.put("amount", purseCount);
			params.put("total", totalPrice);
			params.put("clid", 302);	// 企业主键
			params.put("dlid", 428);
			
			ObjectMapper mapper = new ObjectMapper();
	        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	        String body = mapper.writeValueAsString(params);
	        System.out.println("body=" + body);
			String rsp = HttpClientUtil.doPost("http://39.108.149.156:8088/platform/api/order/submit", body);
			System.out.println("rsp=" + rsp);
		}
	}

}