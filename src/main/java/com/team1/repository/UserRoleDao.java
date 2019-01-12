package com.team1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team1.entity.UserRole;

public interface UserRoleDao extends JpaRepository<UserRole, Integer> {
	
}