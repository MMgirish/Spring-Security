package com.ons.springsecurity.managedBean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.stereotype.Component;

@Component (value = "securityBean")
@ELBeanName (value = "securityBean")
public class SecurityBean {
	
	private String role;

	public String loggedInUserRole() {
		HttpSession session=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String role=session.getAttribute("role").toString();
		return role;
	}

	public String getRole() {
		return this.loggedInUserRole();
	}
	
}
