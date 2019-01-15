package com.team1.service.impl;

import com.team1.entity.Role;
import com.team1.entity.User;
import com.team1.entity.UserRole;
import com.team1.repository.UserRepository;
import com.team1.service.UserService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
  @Autowired
  UserRepository userRepository;
  @PersistenceContext
  EntityManager entityManager;
  @Autowired
  private BCryptPasswordEncoder encoder;

  @Override
  public List<User> getAllUser() {

    return userRepository.findAll();
  }

  @Override
  public void deleteUser(int userId) {
    userRepository.deleteById(userId);

  }

  @Override
  public User findUser(int userId) {

    return userRepository.findById(userId).get();
  }

  @Override
  public void addUser(User user) {
    User findByEmail = userRepository.findByEmail(user.getEmail());
    if (findByEmail != null) {
      user.setStatus("That Bại");
      return;
    }
    user.setPassword(encoder.encode(user.getPassword()));

    UserRole userRole = new UserRole();
    userRole.setCreatedDate(new Date());
    Role role = new Role();
    userRole.setRole(role);
    userRole.setUser(user);

    List<UserRole> userRoles = new ArrayList<UserRole>();
    userRoles.add(userRole);
    user.setUserRoles(userRoles);
    userRepository.save(user);

  }

  public void updateUser(User user) {
    entityManager.merge(user);

  }

  @SuppressWarnings("unchecked")
  @Override
  public List<String> getRoleName(int id) {
    String sql = "Select ur.role.name from " + UserRole.class.getName() + " ur " //
        + " where ur.user.userId = :userId ";

    Query query = this.entityManager.createQuery(sql, String.class);
    query.setParameter("userId", id);
    return query.getResultList();
  }

  public User findUserByEmailAndPassword(String email, String password) {
    return userRepository.findUserByEmailAndPassword(email, password);
  }

}
