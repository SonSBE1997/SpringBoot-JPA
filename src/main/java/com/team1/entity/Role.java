package com.team1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	@Id
	@Column(name="role_id", length=10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	@Column(name="name", length=50, nullable=false)
	private String name;
	@Column(name="description", length=255)
	private String desc;
	
	public Role() {
		
	}
	
	public Role(int role_id, String name, String desc) {
		super();
		this.roleId = role_id;
		this.name = name;
		this.desc = desc;
	}
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
