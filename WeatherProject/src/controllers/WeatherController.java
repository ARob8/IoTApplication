package controllers;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;

import business.WeatherBusinessInterface;
import util.LoggingInterceptor;
@Named 
//@ManagedBean
@ViewScoped
@Interceptors(LoggingInterceptor.class) 
public class WeatherController implements Serializable{
	/**
	 * 
	 */
	Logger logger = LoggerFactory.getLogger(WeatherController.class);
	private static final long serialVersionUID = 1L;
	@Inject
	WeatherBusinessInterface weatherBusiness;

	public String getWeather() {
		logger.info("Entering weather controller get weather");
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("weathers",
				weatherBusiness.getWeather());
		return "ShowWeather.xhtml";
	}
	public WeatherBusinessInterface getWeatherBusiness() {
		return weatherBusiness;
	}
}
