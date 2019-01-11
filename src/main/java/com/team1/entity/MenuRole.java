package com.team1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="menu_role")
public class MenuRole {
	
	@Id
	@Column(name="Id", nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name="role_id", nullable=false)
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Role role;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
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
	
	public MenuRole(int id, String status, Role role, Menu menu) {
		super();
		this.id = id;
		this.status = status;
		this.role = role;
		this.menu = menu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
