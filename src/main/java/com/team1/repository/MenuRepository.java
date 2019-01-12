package com.team1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team1.entity.Menu;

@Repository(value="menuRepository")
public interface MenuRepository extends JpaRepository<Menu, Integer>{
	
}
