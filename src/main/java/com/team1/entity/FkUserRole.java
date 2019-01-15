/**
 * Project name: Team1-SpringBoot-JPA
 * Package name: com.team1.entity
 * File name: FkUserRole.java
 * Author: Sanero.
 * Created date: Jan 15, 2019
 * Created time: 7:59:30 AM
 */

package com.team1.entity;

import java.io.Serializable;

/*
 * @author Sanero.
 * Created date: Jan 15, 2019
 * Created time: 7:59:30 AM
 * Description: TODO - 
 */
public class FkUserRole implements Serializable {
  private static final long serialVersionUID = 1L;
  private int user;
  private int role;

  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 7:59:55 AM
   * @return the user
   */
  public int getUser() {
    return user;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 7:59:55 AM
   * @param user the user to set
   */
  public void setUser(int user) {
    this.user = user;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 7:59:55 AM
   * @return the role
   */
  public int getRole() {
    return role;
  }

  /*
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 7:59:55 AM
   * @param role the role to set
   */
  public void setRole(int role) {
    this.role = role;
  }

  /**
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 8:00:01 AM
   * Description: - .
   * @param user
   * @param role
   */
  public FkUserRole(int user, int role) {
    super();
    this.user = user;
    this.role = role;
  }

  /**
   * Author: Sanero.
   * Created date: Jan 15, 2019
   * Created time: 8:00:06 AM
   * Description: - .
   */
  public FkUserRole() {
    super();
  }

}
