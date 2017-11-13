package com.zx.mall.admin.security;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import com.zx.mall.admin.module.SysRole;
import com.zx.mall.admin.pojo.OperatorDetails;

public class SpringSecurityUtils {

	public static User getCurrentUser() {
		Authentication localAuthentication = getAuthentication();
		if (localAuthentication == null)
			return null;
		Object localObject = localAuthentication.getPrincipal();
		if (!(localObject instanceof User))
			return null;
		return (User) localObject;
	}

	public static String getCurrentUserName() {
		Authentication localAuthentication = getAuthentication();
		if ((localAuthentication == null)
				|| (localAuthentication.getPrincipal() == null))
			return "";
		return localAuthentication.getName();
	}

	public static List<SysRole> getRoleList() {
		OperatorDetails localOperatorDetails = (OperatorDetails) getCurrentUser();
		return localOperatorDetails.getRoleList();
	}

	public static String getCurrentUserIp() {
		Authentication localAuthentication = getAuthentication();
		if (localAuthentication == null)
			return "";
		Object localObject = localAuthentication.getDetails();
		if (!(localObject instanceof WebAuthenticationDetails))
			return "";
		WebAuthenticationDetails localWebAuthenticationDetails = (WebAuthenticationDetails) localObject;
		return localWebAuthenticationDetails.getRemoteAddress();
	}

	@SuppressWarnings("rawtypes")
	public static boolean hasAnyRole(String[] paramArrayOfString) {
		Authentication localAuthentication = getAuthentication();
		if (localAuthentication == null)
			return false;
		Collection localCollection = localAuthentication.getAuthorities();
		for (String str : paramArrayOfString) {
			Iterator localIterator = localCollection.iterator();
			while (localIterator.hasNext()) {
				GrantedAuthority localGrantedAuthority = (GrantedAuthority) localIterator
						.next();
				if (str.equals(localGrantedAuthority.getAuthority()))
					return true;
			}
		}
		return false;
	}

	public static void saveUserDetailsToContext(UserDetails paramUserDetails,
			HttpServletRequest paramHttpServletRequest) {
		PreAuthenticatedAuthenticationToken localPreAuthenticatedAuthenticationToken = new PreAuthenticatedAuthenticationToken(
				paramUserDetails, paramUserDetails.getPassword(),
				paramUserDetails.getAuthorities());
		if (paramHttpServletRequest != null)
			localPreAuthenticatedAuthenticationToken
					.setDetails(new WebAuthenticationDetails(
							paramHttpServletRequest));
		SecurityContextHolder.getContext().setAuthentication(
				localPreAuthenticatedAuthenticationToken);
	}

	private static Authentication getAuthentication() {
		SecurityContext localSecurityContext = SecurityContextHolder
				.getContext();
		if (localSecurityContext == null)
			return null;
		return localSecurityContext.getAuthentication();
	}
}