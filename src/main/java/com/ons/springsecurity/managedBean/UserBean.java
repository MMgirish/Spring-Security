package com.ons.springsecurity.managedBean;

import java.util.ArrayList;
import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ons.springsecurity.model.Role;
import com.ons.springsecurity.model.User;
import com.ons.springsecurity.repository.UserRepository;

@Component (value = "userBean")
@ELBeanName (value = "userBean")
@Scope (value = "request")

public class UserBean{

	@Autowired
	private UserRepository userRepository;
	
	private String userId;
	private String firstName;
	private String lastName;
	private String reportingManager;
	private String username;
	private String password;
	private boolean isEnabled=true;
	private String roleAssigned;
	private List<Role> roles;
	private List<User> userList;
	
	
	public List<User> getUserList(){
		userList= new ArrayList<User>();
		userList=userRepository.findAll();
		return userList;
	}
	
	public User getUser(long id) {
		User user=userRepository.getOne(id);
		return user;
		
	}
	
	public String add(UserBean theUser) {
		User user= new User();
		user.setUserId(getUserId());
		user.setFirstName(this.getFirstName());
		user.setLastName(this.getLastName());
		user.setReportingManager(this.getReportingManager());
		user.setEnabled(isEnabled);
		user.setUsername(getUsername());
		user.setPassword(this.getPassword());
		
		Role newRole=new Role();
		newRole.setRolename(getRoleAssigned());
		
		List<Role> roles=new ArrayList<Role>();
		roles.add(newRole);
		user.setRoles(roles);
		userRepository.save(user);
		return "user-list?faces-redirect=true";
	}
	
	public void update(User user) {
		userRepository.save(user);
	}
	
	public String delete(long id) {
		userRepository.deleteById(id);
		return "user-list.xhtml?faces-redirect=true";
	}

	
	//getters and setters
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleAssigned() {
		return roleAssigned;
	}

	public void setRoleAssigned(String roleAssigned) {
		this.roleAssigned = roleAssigned;
	}
	
}
