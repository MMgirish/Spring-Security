package com.ons.springsecurity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "role")
public class Role {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "id")
	private long id;
	
	@Column (name = "rolename")
	private String rolename;
	
	public Role(long id, String rolename) {
		super();
		this.id = id;
		this.rolename = rolename;
	}


	public Role() {
		// TODO Auto-generated constructor stub
	}

	//getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}
