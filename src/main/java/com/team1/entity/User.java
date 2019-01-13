/**
 * Project name: Team1-SpringBoot-JPA
 * Package name: com.team1.entity
 * File name: User.java
 * Author: Sanero.
 * Created date: Jan 11, 2019
 * Created time: 8:49:49 AM
 */

package com.team1.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*
 * @author Sanero.
 * Created date: Jan 11, 2019
 * Created time: 8:49:49 AM
 * Description: TODO - 
 */
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;
	private String email;
	private String password;
	private String status;
	@Column(name = "full_name")
	private String fullName;
	private String mobile;
	@OneToMany(mappedBy="user",fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<UserRole> userRoles;
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
   
}