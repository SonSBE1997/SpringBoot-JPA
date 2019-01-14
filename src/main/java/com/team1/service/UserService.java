/**
 * Project name: Team1-SpringBoot-JPA
 * Package name: com.team1.service
 * File name: UserService.java
 * Author: Sanero.
 * Created date: Jan 11, 2019
 * Created time: 8:50:30 AM
 */

package com.team1.service;

import java.util.List;

import com.team1.entity.User;
import com.team1.entity.UserRole;

/*
 * @author Sanero.
 * Created date: Jan 11, 2019
 * Created time: 8:50:30 AM
 * Description: TODO - 
 */
public interface UserService {
	public List<User> getAllUser();

	public void deleteUser(int userId);

	public User findUser(int userId);

	public void addUser(User user);

	public void updateUser(User user);
	
	public List<String> getRoleName(int id);
	
	
}
