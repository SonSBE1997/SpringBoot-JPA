package com.team1.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="role_menu")
@IdClass(MenuRole.class)
public class MenuRole implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String status;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(name="role_id", nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Role role;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(name="menu_id", nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Menu menu;

	
	public MenuRole() {
		super();
	}

	public MenuRole(Role role, Menu menu, String status) {
		super();
		this.role = role;
		this.menu = menu;
		this.status = status;
	}
	
	public MenuRole(String status, Role role, Menu menu) {
		super();
		this.status = status;
		this.role = role;
		this.menu = menu;
	}


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
