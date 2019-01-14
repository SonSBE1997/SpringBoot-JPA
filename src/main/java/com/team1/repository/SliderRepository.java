package com.team1.repository;

import com.team1.entity.Slider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @author ntmduyen
 * Created date: Jan 14, 2019
 * Created time: 9:58:55 AM
 * Description: TODO - Slide repository extends JPA repository to use JPD library in Spring JPA
 */
@Repository
public interface SliderRepository extends JpaRepository<Slider, Integer> {

}
