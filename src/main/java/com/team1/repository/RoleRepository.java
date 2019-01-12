package com.team1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team1.entity.Role;

/*
 * @author Hai95.
 * Created date: Jan 11, 2019
 * Created time: 8:49:43 AM
 * Description: TODO - 
 */

@Repository(value="roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
