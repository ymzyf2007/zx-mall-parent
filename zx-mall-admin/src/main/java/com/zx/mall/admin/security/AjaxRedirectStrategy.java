package com.zx.mall.admin.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.RedirectStrategy;

public class AjaxRedirectStrategy implements RedirectStrategy {

	private boolean contextRelative;

	public void setContextRelative(boolean useRelativeContext) {
		this.contextRelative = useRelativeContext;
	}

	public void sendRedirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
		String redirectUrl = calculateRedirectUrl(request.getContextPath(), url);
		redirectUrl = response.encodeRedirectURL(redirectUrl);

		if (isAjaxRequest(request)) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "SESSION_TIMED_OUT");
			response.getWriter().flush();
		} else {
			response.sendRedirect(redirectUrl);
		}
	}

	protected String calculateRedirectUrl(String contextPath, String url) {
		if(!url.startsWith("http://") && !url.startsWith("https://")) {
			if (contextRelative) {
				return url;
			} else {
				return contextPath + url;
			}
		}
		if(!contextRelative) {
			return url;
		}

		url = url.substring(url.indexOf("://") + 3);
		url = url.substring(url.indexOf(contextPath) + contextPath.length());

		if (url.length() > 1 && url.charAt(0) == '/') {
			url = url.substring(1);
		}
		return url;
	}

	private boolean isAjaxRequest(HttpServletRequest request) {
		return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
	}

}