package com.team1.repository;

import com.team1.entity.Slider;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/*
 * @author ntmduyen
 * Created date: Jan 14, 2019
 * Created time: 9:58:55 AM
 * Description: TODO - Slide repository extends JPA repository to use JPD library in Spring JPA
 */
@Repository
public interface SliderRepository extends JpaRepository<Slider, Integer> {
	/**
	 * Author: ntmduyen
	 * Created date: Jan 15, 2019
	 * Created time: 8:27:15 AM
	 * Description: TODO - search by name.
	 * @param name
	 * @return
	 */
	@Query("select r from Slider r where r.name like :name%")
	List<Slider> findByName(@Param("name") String name);
}