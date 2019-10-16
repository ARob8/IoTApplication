package data;

import java.util.List;

public interface WeatherDAOInterface <T>{

	    public boolean insert(T model);
	    
	    public List<T> getWeather();
}
