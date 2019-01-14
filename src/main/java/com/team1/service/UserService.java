/**
 * Project name: Team1-SpringBoot-JPA
 * Package name: com.team1.service
 * File name: UserService.java
 * Author: Sanero.
 * Created date: Jan 11, 2019
 * Created time: 8:50:30 AM
 */

package com.team1.service;

import com.team1.entity.User;
import com.team1.repository.UserRepository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @author Sanero.
 * Created date: Jan 11, 2019
 * Created time: 8:50:30 AM
 * Description: TODO - 
 */
@Service
@Transactional
public class UserService {
  @Autowired
  UserRepository userRepository;

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findUserByEmailAndPassword(String email, String password) {
    return userRepository.findUserByEmailAndPassword(email, password);
  }

  public User findUser(int id) {
    return userRepository.findById(id).get();
  }
}
