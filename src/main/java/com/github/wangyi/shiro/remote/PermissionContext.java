package com.github.wangyi.shiro.remote;

import java.io.Serializable;

import java.util.Set;

/**
 * 授权上下文
 * <p>User: wangyi
 * <p>Date: 2016-9-22
 * <p>Version: 1.0
 */

public class PermissionContext implements Serializable{

	private static final long serialVersionUID = -9124569085892215349L;

	private Set<String> roles;  //所有角色 
	
	private Set<String> permissions; //所有权限

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public Set<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}

	@Override
	public String toString() {
		return "PermissionContext [roles=" + roles + ", permissions="
				+ permissions + "]";
	}
	
	
}
