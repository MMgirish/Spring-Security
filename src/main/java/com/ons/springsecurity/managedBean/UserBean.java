package com.ons.springsecurity.managedBean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.beans.factory.annotation.Autowired;

import com.ons.springsecurity.controller.UserController;
import com.ons.springsecurity.model.User;
import com.ons.springsecurity.repository.UserRepository;

@ManagedBean
public class UserBean{
	
	@Autowired
	private UserRepository userRepository;

	private long id;
	private String username;
	private List<User> users;
	
	//no-arg constructor
	public UserBean(long id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	
	//default constructor
	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	
	//crud methods
	public List<User> getAllUsers(){
		users=userRepository.findAll();
		return users;
	}
	
	//getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getUsers() {
		return this.getAllUsers();
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
