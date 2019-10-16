package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import beans.Weather;
import util.DatabaseException;
import util.LoggingInterceptor;
@Interceptors(LoggingInterceptor.class)
@Stateless
@Local(WeatherDAOInterface.class)
@LocalBean
public class WeatherDAO implements WeatherDAOInterface<Weather> {

	public Connection mysqlConnect() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/weather";

		try {
			// this checks if the driver exist
			Class.forName("com.mysql.jdbc.Driver");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("MySQL JDBC Driver isn't install");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, "root", "root");
		
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return conn;
	}



	@Override
	public boolean insert(Weather model) {
		// TODO Auto-generated method stubConnection conn = mysqlConnect();
		Connection conn = mysqlConnect();
		SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO WEATHER (temp, humidity, pressure, datetime) VALUES (" + "'" + model.getTemperature()
					+ "'" + ", " + "'" + model.getHumidity() + "'" + ", " + "'" + model.getPressure() + "'" + ", " + "'" + dtFormat.format(new Date()) + "'" + ")";
			stmt.execute(sql);
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL statement error");
			e.printStackTrace();
			throw new DatabaseException(e);
		}
	}
	
	public List<Weather> getWeather() {
		Connection conn = mysqlConnect();
		List<Weather> weathers = new ArrayList<Weather>();
		//SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM weather.WEATHER ORDER BY weatherID DESC LIMIT 5";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				weathers.add(new Weather(rs.getFloat("TEMP"), rs.getFloat("HUMIDITY"), rs.getFloat("PRESSURE"),rs.getDate("DATETIME").toString() + " " + rs.getTime("DATETIME").toString()));
			}
			rs.close();
		}
		catch(SQLException e) {
			System.out.println("SQL statement error");
			e.printStackTrace();
			throw new DatabaseException(e);
		}
		return weathers;
	}
	
	
	/*
	public List <Weather> findByDateRange(Date from, Date to)
	{
		Connection conn = mysqlConnect();
		List<Weather> weathers = new ArrayList<Weather>();	
		SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM weather.WEATHER WHERE DATE(datetime) >?";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				weathers.add(new Weather(rs.getFloat("TEMP"), rs.getFloat("HUMIDITY"), rs.getFloat("PRESSURE"),rs.getDate("DATETIME").toString() + " " + rs.getTime("DATETIME").toString()));
			}
			rs.close();
		}
		catch(SQLException e) {
			System.out.println("SQL statement error");
			e.printStackTrace();
			throw new DatabaseException(e);
		}
		return weathers;
		
	}
	*/
}
