/**
 * Project name: News
 * Package name: dev.sanero.repository
 * File name: UserRepository.java
 * Author: Sanero.
 * Created date: Jan 10, 2019
 * Created time: 5:10:18 PM
 */

package com.team1.repository;

import com.team1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * @author Sanero.
 * Created date: Jan 10, 2019
 * Created time: 5:10:18 PM
 * Description: TODO - user repository.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
  public User findUserByEmailAndPassword(String email, String password);
}
