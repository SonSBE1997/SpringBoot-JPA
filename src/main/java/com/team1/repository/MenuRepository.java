package com.team1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	
	@Query("select m from Menu m where m.name like :name%")
	List<Menu> findByName(@Param("name") String name);
}
