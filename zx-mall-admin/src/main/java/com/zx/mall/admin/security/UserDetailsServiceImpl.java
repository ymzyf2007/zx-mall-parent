package com.zx.mall.admin.security;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.zx.mall.admin.dao.SysUserMapper;
import com.zx.mall.admin.module.SysUser;
import com.zx.mall.admin.pojo.OperatorDetails;

@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {

	Log log = LogFactory.getLog(UserDetailsServiceImpl.class);

	@Autowired
	private SysUserMapper sysUserMapper;

	/**
	 * 获取用户Details信息的回调函数.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		SysUser sysUser = sysUserMapper.findUserByUserName(username);
		if (sysUser == null) {
			log.error("用户" + username + " 不存在");
			throw new UsernameNotFoundException("用户名或密码错误");
		}

		Set<GrantedAuthority> grantedAuths = obtainGrantedAuthorities(sysUser);

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		OperatorDetails userDetails = new OperatorDetails(sysUser.getName(), sysUser.getPwd(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);
		
		// 加入登录时间信息和用户角色
		userDetails.setRoleList(sysUser.getRoleList());
		
		return userDetails;
	}

	/**
	 * 获得用户所有角色的权限集合.
	 */
	@SuppressWarnings("deprecation")
	private Set<GrantedAuthority> obtainGrantedAuthorities(SysUser sysUser) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();

		/*for (Authority authority : sysUser.getAuthorityList()) {
			authSet.add(new GrantedAuthorityImpl(authority.getPrefixedName()));
		}*/
		
		authSet.add(new GrantedAuthorityImpl("ROLE_INDEX"));

		return authSet;
	}
	
}