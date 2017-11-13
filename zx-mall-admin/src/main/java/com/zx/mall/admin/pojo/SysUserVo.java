package com.zx.mall.admin.pojo;

public class SysUserVo {

	private String username;
	private boolean accountNonExpired;
	private boolean enabled;
	private String descr;

	public SysUserVo(String username, boolean accountNonExpired,
			boolean enabled, String descr) {
		this.username = username;
		this.accountNonExpired = accountNonExpired;
		this.enabled = enabled;
		this.descr = descr;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

}