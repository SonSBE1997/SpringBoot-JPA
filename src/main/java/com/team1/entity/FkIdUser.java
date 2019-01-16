package com.team1.entity;

import java.io.Serializable;

public class FkIdUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int user;
	private int role;

	public FkIdUser(int user, int role) {
		super();
		this.user = user;
		this.role = role;
	}

	public FkIdUser() {
		super();
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

}
