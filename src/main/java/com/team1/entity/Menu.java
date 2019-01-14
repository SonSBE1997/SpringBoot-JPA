package com.team1.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="menu")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="menu_id", length=10, nullable=false)
	private int menuId;
	
	@NotNull
	@Size(max=5)
	@Column(name="name", length=25)
	private String name;
	
	@Column(name="description", length=255)
	private String desc;
	
	@Column(name="controller", length=25)
	private String controller;
	
	@Column(name="action",length=50, nullable=false)
	private String function;
	
	@OneToMany(mappedBy = "menu", cascade=CascadeType.ALL)
	private List<MenuRole> menuRole;

	public Menu() {
		
	}
	
	public Menu(int menuId, String name, String desc, String controller, String function) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.desc = desc;
		this.controller = controller;
		this.function = function;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<MenuRole> getMenuRole() {
		return menuRole;
	}

	public void setMenuRole(List<MenuRole> menuRole) {
		this.menuRole = menuRole;
	}
	
}
