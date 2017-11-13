package com.zx.mall.module.vo;

public class VenderProductKindVo {

	private Long id;
	private String name;
	private boolean binding; // 是否绑定

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isBinding() {
		return binding;
	}

	public void setBinding(boolean binding) {
		this.binding = binding;
	}

}