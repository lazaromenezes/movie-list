package br.com.lazarodm.movielist.core;

import java.io.Serializable;

public class CastMember implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String name) {
		this.role = role;
	}
}
