package com.team1.repository;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

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
	
	/**
	 * @param role_id
	 * Description: retrieved role_id and status field by role_id from menu_role
	 * @return
	 */
	@Query("SELECT ml.role_id, ml.status FROM menu_role ml where ml.role_id = :role_id")
	MenuRole findStatusByRole(@Param("role_id") int role_id);
	
	/**
	 * @param menu_id
	 * Description: retrieved menu_id and status field by menu_id from menu_role
	 * @return
	 */
	@Query("SELECT ml.menu_id, ml.status FROM menu_role ml where ml.menu_id = :menu_id")
	MenuRole findStatusByMenu(@Param("menu_id") int menu_id);
	
	@Async
	Future<List<String>> findByStatus();
}
