package com.ssm.chapter14.dao;

import org.springframework.stereotype.Repository;

import com.ssm.chapter14.pojo.Role;

import java.util.List;

@Repository
public interface RoleDao {
	
	public Role getRole(Long id);
	public List<Role> findRole();
	public int insertRole(Role role);
}
