package com.zx.mall.admin.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

/**
 * 访问拒绝处理
 * Spring默认的AccessDeniedHandler中只有对页面请求的处理，而没有对Ajax的处理，添加对Ajax支持
 *
 */
public class AjaxAccessDeniedHandlerImpl extends AccessDeniedHandlerImpl {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException reason) throws IOException, ServletException {
		if(isAjaxRequest(request)) {
//			String jsonObject = "{\"systemMessage\":" + "{\"errorMessages\":[\"没有权限\"]," + "\"infoMessages\":null,"
//					+ "\"warnMessages\":null}}";
			String contentType = "application/json";
			response.setContentType(contentType);
			response.getWriter().print("{\"status\":500, \"msg\": \"没有权限\"}");
			response.getWriter().flush();
		} else {
			super.handle(request, response, reason);
		}
	}
	
	protected boolean isAjaxRequest(HttpServletRequest request) {
		return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
	}
}