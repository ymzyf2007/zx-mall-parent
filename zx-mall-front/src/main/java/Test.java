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
import com.zx.mall.front.pojo.OrderProductDetail;
import com.zx.mall.front.pojo.OrderReq;
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
		for(int i = 0; i < 20; i++) {
			mallOrder();
		}
		
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
	
	public static void mallOrder() throws JsonProcessingException {
		Random random = new Random();
		Long[] lidArray = {6L, 10L};
		Long[] priceArray = {100L, 105L};
		OrderReq req = new OrderReq();
		req.setAppId("zx_mall");
		req.setUserId(494);	// 用户ID
		req.setToken("3e178819-e1cc-4b2e-9d4b-99178964f4f6");
		req.setReceiverId(12L);
		
		int purseCount = 0;	// 购买数量
		Float totalPrice = 0f;
		List<OrderProductDetail> productList = new ArrayList<OrderProductDetail>();
		for(int j = 0; j < 2; j++) {
			OrderProductDetail sku = new OrderProductDetail();
			int r = random.nextInt(10);
			int num = 15 - r;
			purseCount += num;
			totalPrice += num * priceArray[j];
			sku.setSkuId(lidArray[j]);
			sku.setPrice(Float.valueOf(String.valueOf(priceArray[j])));
			sku.setQuantity(num);
			sku.setTotal(Float.valueOf(num * priceArray[j]));
			productList.add(sku);
		}
		req.setProductList(productList);
		req.setTotalCount(purseCount);
		req.setTotalPrice(totalPrice);
		
		ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String body = mapper.writeValueAsString(req);
        System.out.println("body=" + body);
		String rsp = HttpClientUtil.doPost("http://127.0.0.1:8080/front/rest/order/saveOrder", body);
		System.out.println("rsp=" + rsp);
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