package com.team1.repository;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.team1.entity.Menu;

/**
 * Project name: Team1-SpringBoot-JPA
 * Package name: com.team1.controller
 * File name: ABCZ.java
 * Author: ...Hai95
 * Created date: Jan 11, 2019
 * Created time: 8:49:43 AM
 */
@Repository(value="menuRepository")
public interface MenuRepository extends JpaRepository<Menu, Integer>{
	
	/**
	 * @param functions
	 * Description: retrieved menu_name and function field by any letter in name's functions from menu_role
	 * @return
	 */
//	@Query("SELECT m.menu_name, m.functions FROM menu m where m.functions like '%:functions%'")
//	Future<List<Menu>> findNameByFunction(@Param("functions") String functions);
	
	@Async
	Future<List<Menu>> findByController(String s);
	
	@Async
	Future<List<String>> findByName(String name);
	
	@Async
    Future<List<Menu>> findByFunction(String function);
}
