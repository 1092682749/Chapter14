package com.ssm.chapter14.service;

import com.ssm.chapter14.pojo.Role;

import java.util.List;

public interface RoleService {
	
	default public Role getRole(Long id){
		return null;
	}
	public List<Role> findeRole();
	public int insertRole(Role role);
}
