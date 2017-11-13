package com.zx.mall.interceptors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 拦截客户端请求
 */
@Service("inputInterceptor")
public class InputInterceptor extends AbstractPhaseInterceptor<Message> {
	
	public static final String AUTHCODE_PATH = "/train/rest/sys/authCode";
	public static final String REG_PATH = "/train/rest/sys/register";
	
	private static Logger logger = LoggerFactory.getLogger(InputInterceptor.class);

	public InputInterceptor(String phase) {
		super(phase);
	}

	public InputInterceptor() {
		super(Phase.RECEIVE);
	}
	
	private static String inputStream2String(InputStream is) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i = -1;
		while((i = is.read()) != -1) {
			baos.write(i);
		}
		baos.flush();
		baos.close();
		return baos.toString();
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		message.setId(System.currentTimeMillis() + "");
		if("GET".equals(message.get(Message.HTTP_REQUEST_METHOD))) {
			String reqParams = (String) message.get(Message.QUERY_STRING);
			Request request = new Request(message.get(Message.PATH_INFO).toString(), HttpRequestParser.getParamsMap(reqParams));
			logger.info("\nMessageId: " + message.getId() + "\n" + 
					"PATH: " + request.getRequestURI() + "\n" + 
					"GET-PARAM: " + request.getParamsJsonStr());
		} else if("POST".equals(message.get(Message.HTTP_REQUEST_METHOD))) {
			try {
				InputStream is = message.getContent(InputStream.class);
				String str = inputStream2String(is);
				logger.info("\nMessageId: " + message.getId() + "\n" + 
							"PATH: " + message.get(Message.PATH_INFO).toString() + "\n" + 
							"POST-PARAM: " + str);
				message.setContent(InputStream.class, new ByteArrayInputStream(new String(str).getBytes()));
			} catch (Exception e) {
				Fault fault = new Fault(e);
				e.printStackTrace();
				throw fault;
			}
		}
	}
	
}