package com.ons.springsecurity.managedBean;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.ons.springsecurity.model.User;
import com.ons.springsecurity.repository.UserRepository;

@Component (value = "loginBean")
@ELBeanName (value = "loginBean")
@Scope (value = "session")
public class LoginBean {
	private String username;
	private String password;
	Logger logger= Logger.getLogger(getClass().getName());
	
	@Autowired
	private UserRepository userRepository;

	public String authenticateUser() {
		User user=userRepository.findByUsername(username);
		System.out.println("user: "+user);
		if(user!=null) {
			if(user.getPassword().equals(this.getPassword())) {
				System.out.println("if condition true");
				
				getCurrentSession().setAttribute("id", user.getId());
				getCurrentSession().setAttribute("userId", user.getUserId());
				getCurrentSession().setAttribute("firstName", user.getFirstName());
				getCurrentSession().setAttribute("lastName", user.getLastName());
				getCurrentSession().setAttribute("username", user.getUsername());
				getCurrentSession().setAttribute("reportingManager", user.getReportingManager());
				System.out.println("idu bartide..");
				System.out.println(user.getRoles().get(0).getRolename());
				getCurrentSession().setAttribute("role", user.getRoles().get(0).getRolename());
				return "dashboard?faces-redirect=true";		
			}
			else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, " User Name and Password",
					"Username and password do not match! Please Enter valid credentials"));
					return "login";
				}
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, " User Name",
					"Username Does Not exists !"));
					return "login";
		}
	}
	
	public String logout() {
		System.out.println("session will be invalidated..."+getCurrentSession().getId());
		getCurrentSession().invalidate();
		return "login";
	}
	
	//GET CURRENT SESSION
	public HttpSession getCurrentSession() {
		FacesContext facesContext=FacesContext.getCurrentInstance();
		HttpSession session=(HttpSession) facesContext.getExternalContext().getSession(false);
		return session;
	}
	
	//GETTERS AND SETTERS
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

}
