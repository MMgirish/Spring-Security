package com.ons.springsecurity.managedBean;

import java.util.ArrayList;
import java.util.List;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ons.springsecurity.controller.UserController;
import com.ons.springsecurity.rest.RestUser;

@Component (value = "restBean")
@ELBeanName (value = "restBean")
@Scope (value = "request")
public class RestBean {
	
	private List<RestUser> userAssets;
	
	@Autowired
	private UserController userController;
	
	public List<RestUser> displayUserAssets(){
		userAssets=new ArrayList<RestUser>();
		userAssets=userController.UserAssets();
		return userAssets;
	}

	//getters,setters
	public List<RestUser> getUserAssets() {
		return displayUserAssets();
	}

	public void setUserAssets(List<RestUser> userAssets) {
		this.userAssets = userAssets;
	}
	
}
