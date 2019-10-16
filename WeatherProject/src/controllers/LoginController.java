package controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

import beans.User;
import business.BusinessInterface;

import util.LoggingInterceptor;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Interceptors(LoggingInterceptor.class)
@ManagedBean
@ViewScoped
public class LoginController implements Serializable{
	/**
	 * 
	 */
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	private static final long serialVersionUID = 1L;
	@Inject
	BusinessInterface service;

	public String userLogin() {
		logger.info("Entering login controller check login");
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		if (service.Authenticate(user)) {
			FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
			return "LoginPass.xhtml";
		} else
			return "LoginError.xhtml";
	}
	
	public BusinessInterface getService() {
		return service;
	}

}
