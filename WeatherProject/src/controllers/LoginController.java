package controllers;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.BusinessInterface;
import business.UserBusiness;


@ManagedBean
@ViewScoped
public class LoginController {
	@Inject
	BusinessInterface service;
	public String register() {
		FacesContext context = FacesContext.getCurrentInstance();
		User user= context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);	
		if(service.findUser(user.getUserName()))
		{
			return "RegisterError.xhtml";
		}		
		service.create(user);
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user",user);
		return "RegisterPass.xhtml";
		
	}
	public String userLogin() {
		UserBusiness service = new UserBusiness();
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		

		if (service.Authenticate(user)) {
		
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
			return "LoginPass.xhtml";
		} else
			return "LoginError.xhtml";
	}
}