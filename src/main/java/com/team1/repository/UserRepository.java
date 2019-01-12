/**
 * Project name: Team1-SpringBoot-JPA
 * Package name: com.team1.repository
 * File name: UserRepository.java
 * Author: Sanero.
 * Created date: Jan 11, 2019
 * Created time: 8:50:11 AM
 */

package com.team1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team1.entity.User;

/*
 * @author Sanero.
 * Created date: Jan 11, 2019
 * Created time: 8:50:11 AM
 * Description: TODO - 
 */
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select u from User u where u.email like ?1%")
	  List<User> findBy(String email);
	@Query("select u from User u where u.email=?1")
	 User findByEmail(String email);
}
