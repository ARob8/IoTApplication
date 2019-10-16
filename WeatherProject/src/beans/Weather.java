package beans;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Weather {
	
	private float temperature;
	private float humidity;
	private float pressure;
	private String datetime;
	public Weather()
	{
		this.temperature = 0;
		this.humidity = 0;
		this.pressure = 0;
	}
	
	public Weather(float temperature, float humidity, float pressure) {
		super();
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}
	public Weather(float temperature, float humidity, float pressure,String datetime) {
		super();
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		this.datetime = datetime;
	}
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public float getHumidity() {
		return humidity;
	}
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	public float getPressure() {
		return pressure;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
}
