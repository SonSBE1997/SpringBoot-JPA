package com.team1.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team1.entity.Menu;

/*
 * @author Hung.
 * Created date: Jan 14, 2019
 * Created time: 11:19:15 AM
 * Description: TODO - 
 */
public interface MenuRepository extends JpaRepository<Menu, Integer>{
  @Query("select m from Menu m where m.name like %:name%")
  List<Menu> findByNameContaining(@Param("name") String Name);
}
