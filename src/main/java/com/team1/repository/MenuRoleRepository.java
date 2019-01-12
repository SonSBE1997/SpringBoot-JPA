package com.team1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team1.entity.MenuRole;

@Repository(value="menuRoleRepository")
public interface MenuRoleRepository extends JpaRepository<MenuRole, Integer> {
	
}
