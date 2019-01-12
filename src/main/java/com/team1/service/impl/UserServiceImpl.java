package com.team1.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team1.entity.Role;
import com.team1.entity.User;
import com.team1.entity.UserRole;
import com.team1.repository.UserRepository;
import com.team1.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
    @Autowired
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

		return userRepository.getOne(userId);
	}

	@Override
	public void addUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		List<UserRole> userRoles=new ArrayList<>();
		UserRole userRole=new UserRole();
		userRole.setCreatedDate(new Date());
		Role role=new Role();
		role.setDesc("abcd");
		userRole.setRole(role);
		userRole.setUser(user);
		userRoles.add(userRole);
		user.setUserRoles(userRoles);
		userRepository.save(user);

	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
		
	}

}
