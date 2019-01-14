package com.team1.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.team1.entity.Menu;
import com.team1.entity.MenuRole;

/**
 * Project name: Team1-SpringBoot-JPA
 * Package name: com.team1.controller
 * File name: ABCZ.java
 * Author: ...Hai95
 * Created date: Jan 11, 2019
 * Created time: 8:49:43 AM
 */
@Repository(value="menuRoleRepository")
public interface MenuRoleRepository extends JpaRepository<MenuRole, Integer> {
	
	@Query("select ml from MenuRole ml where ml.menu = :menu")
	MenuRole findByMenuId(@Param("menu") Menu menu);
	
	@Query("select ml from MenuRole ml where ml.status like :stus%")
	List<MenuRole> findByStatus(@Param("stus") String stus);
	
//	@Query("select ml from MenuRole ml where ml.id = :id")
//	MenuRole findById(@Param("id") int id);
}
