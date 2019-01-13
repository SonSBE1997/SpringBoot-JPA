/*package com.team1.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "menu_id")
	private int menuId;
	@Column(name = "description")
	private String desc;
	private String controller;
	@Column(name="functions")
	private String function;
	@OneToMany(mappedBy="menu" ,fetch=FetchType.EAGER,cascade= CascadeType.ALL)
	private List<MenuRole> menuRoles;

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public List<MenuRole> getMenuRoles() {
		return menuRoles;
	}

	public void setMenuRoles(List<MenuRole> menuRoles) {
		this.menuRoles = menuRoles;
	}
   
}
*/