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

@Entity
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="role_id")
	private int roleId;
	private String name="ROLE_ADMIN";
	@Column(name="description")
	private String desc;
	@OneToMany(mappedBy="role",fetch=FetchType.LAZY)
	private List<UserRole> userRoles;
	/*@OneToMany(mappedBy="role")
	private List<MenuRole> menuRoles;*/
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int role_id) {
		this.roleId = role_id;
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
	public List<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	/*public List<MenuRole> getMenuRoles() {
		return menuRoles;
	}
	public void setMenuRoles(List<MenuRole> menuRoles) {
		this.menuRoles = menuRoles;
	}*/
	
}
