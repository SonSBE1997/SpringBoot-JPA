package com.team1.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*
 * @author Hung.
 * Created date: Jan 11, 2019
 * Created time: 10:10:38 AM
 * Description: create entity menu
 */
@Entity
public class Menu {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int menu_id;
  @Column(length = 50)
  private String name;
  @Column(length = 50)
  private String description;
  @Column(length = 50)
  private String controller;
  @Column(length = 50)
  private String action;
  
  @OneToMany(mappedBy = "menu", cascade=CascadeType.ALL)
  private List<MenuRole> menuRole;

  public Menu() {

  }

  /**
   * Author: Hung.
   * Created date: Jan 11, 2019
   * Created time: 11:04:50 AM
   * Description: - .
   * @param menu_id
   * @param name
   * @param desc
   * @param controller
   * @param function
   */
  public Menu(int menu_id, String name, String desc, String controller,
      String function) {
    super();
    this.menu_id = menu_id;
    this.name = name;
    this.description = desc;
    this.controller = controller;
    this.action = function;
  }

  public int getMenu_id() {
    return menu_id;
  }

  public void setMenu_id(int menu_id) {
    this.menu_id = menu_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String desc) {
    this.description = desc;
  }

  public String getController() {
    return controller;
  }

  public void setController(String controller) {
    this.controller = controller;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String function) {
    this.action = function;
  }

}
