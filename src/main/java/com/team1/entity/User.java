/**
 * Project name: News
 * Package name: dev.sanero.entity
 * File name: User.java
 * Author: Sanero.
 * Created date: Jan 10, 2019
 * Created time: 2:41:55 PM
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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/*
 * @author Sanero.
 * Created date: Jan 10, 2019
 * Created time: 2:41:55 PM
 * Description: TODO - user entity.
 */
@Entity(name = "user")
public class User implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private int userId;
  @Email
  @NotEmpty
  @Column(unique = true)
  private String email;
  @Size(min = 15)
  @Size(max = 30)
  private String password;
  @Column(name = "status")
  private String status;
  @Size(min = 10)
  @Size(max = 40)
  @Column(name = "full_name")
  private String fullName;
  @Pattern(regexp = "(^$|[0-9]{10})")
  @Size(min = 10)
  @Size(max = 11)
  private String mobile;
  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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