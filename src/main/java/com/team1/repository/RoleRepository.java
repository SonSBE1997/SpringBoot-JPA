package com.team1.repository;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.team1.entity.Role;

/**
 * Project name: Team1-SpringBoot-JPA
 * Package name: com.team1.controller
 * File name: ABCZ.java
 * Author: ...Hai95
 * Created date: Jan 11, 2019
 * Created time: 8:49:43 AM
 */
@Repository(value="roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	@Async
	Future<List<Role>> findByName(String name);
	
	@Async
	Future<List<Role>> findByDesc(String desc);
}
