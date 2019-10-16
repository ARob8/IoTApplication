package business;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import beans.Weather;
import data.WeatherDAOInterface;
import util.LoggingInterceptor;
@Interceptors(LoggingInterceptor.class) 
@Stateless
@Local
@LocalBean
public class WeatherBusiness implements WeatherBusinessInterface{
	Logger logger = LoggerFactory.getLogger(UserBusiness.class);
	@EJB
	WeatherDAOInterface<Weather> dao;
	
	@Override
	public boolean create(Weather t) {
		// TODO Auto-generated method stub
		logger.info("Entering create weather");
		return dao.insert(t);
	}

	@Override
	public List<Weather> getWeather() {
		// TODO Auto-generated method stub
		logger.info("Entering retrieve weather");
		return dao.getWeather();
	}	

}
