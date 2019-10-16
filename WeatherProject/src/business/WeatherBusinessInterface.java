package business;

import java.util.List;

import javax.ejb.Local;

import beans.Weather;

@Local
public interface WeatherBusinessInterface {
	public boolean create(Weather t);
	public List<Weather> getWeather();
}
