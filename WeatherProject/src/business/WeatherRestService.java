package business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import beans.ResponseDataModel;

import beans.Weather;

import util.LoggingInterceptor;
import util.WeatherNotFoundException;

import beans.DataFactory;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
@Interceptors(LoggingInterceptor.class)
@RequestScoped
@Path("/weather")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class WeatherRestService {
	
	Logger logger = LoggerFactory.getLogger(WeatherRestService.class);
	
	@Inject
	 WeatherBusinessInterface service;

	@POST
	@Path("/save")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean saveTemperature(Weather model) {
		logger.info("Entering WeatherRestService.saveTemperature()");
			
			return service.create(model);
			
	}
	
/*	
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Weather> getWeatherAsJson() {
		logger.info("Entering WeatherRestService.getWeatherAsJson()");
		return service.getWeather();
	}
	*/
	@GET
	@Path("/getjson1")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseDataModel getWeatherJ() throws WeatherNotFoundException {
		logger.info("Entering WeatherRestService.getWeatherAsJson()");	
		List<Weather> weathers = new ArrayList<Weather>();
		try {
			weathers = service.getWeather();
			DataFactory responseFactory = new DataFactory();
			ResponseDataModel response  = responseFactory.createDTO(1, "OK", weathers);
		
			return response;
		} 
		 catch (Exception e2) {
			DataFactory responseFactory = new DataFactory();
			ResponseDataModel response  = responseFactory.createDTO(-1, "Failed", weathers);
			return response;
		}
	}
	
	


	

}
