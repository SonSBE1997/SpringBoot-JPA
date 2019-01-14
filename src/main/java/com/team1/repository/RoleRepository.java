package com.team1.repository;

import com.team1.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * @author Hai95.
 * Created date: Jan 11, 2019
 * Created time: 8:49:43 AM
 * Description: TODO - 
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
