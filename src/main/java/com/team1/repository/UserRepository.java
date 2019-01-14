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
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*
 * @author Sanero.
 * Created date: Jan 10, 2019
 * Created time: 5:10:18 PM
 * Description: TODO - user repository.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
  @Query("select u from user u where u.email like ?1%")
  List<User> findBy(String email);

  @Query("select u from user u where u.email=?1")
  User findByEmail(String email);

  User findUserByEmailAndPassword(String email, String password);
}
