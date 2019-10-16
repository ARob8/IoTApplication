package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import beans.User;
import util.DatabaseException;
import util.LoggingInterceptor;

@Interceptors(LoggingInterceptor.class)
@Stateless
@Local(DaoInterface.class)
@LocalBean
public class UserDao implements DaoInterface<User>{
	public UserDao() {
	}

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
	public boolean findBy(User user) {
		// TODO Auto-generated method stub

		Connection conn = mysqlConnect();
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM USERS WHERE USERNAME =" + "'" + user.getUserName() + "'" + " AND PASSWORD = " + "'" + user.getPassword() + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {			
					return true;
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(e);
		}
		return false;
	}

	@Override
	public boolean create(User user) {
		Connection conn = mysqlConnect();
		try {
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO USERS (FIRSTNAME, LASTNAME, USERNAME, PASSWORD, EMAIL) VALUES (" + "'" + user.getFirstName() + "'" + ", " + "'" + user.getLastName() + "'" + ", " + "'" + user.getUserName() + "'" + ", " + "'" + user.getPassword() + "'" + ", " + "'" + user.getEmail() + "'" +")";
			 stmt.execute(sql);
			 stmt.close();
					return true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DatabaseException(e);
		}
		finally {
			if(conn != null)
			{
				try 
				{
					conn.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new DatabaseException(e);
				}
			}
		}
		
	}

	@Override
	public boolean findBy(String username) {
		// TODO Auto-generated method stub

		Connection conn = mysqlConnect();
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM USERS WHERE USERNAME =" + "'" + username + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
					return true;
				
			}
			rs.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new DatabaseException(e);
		}
		return false;
	}
	
	public User findByUser(String username) {
		Connection conn = mysqlConnect();
		
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM USERS WHERE USERNAME =" + "'" + username + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
					return new User(rs.getString("USERNAME"),"");
				
			}
			rs.close();

		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new DatabaseException(e);
		}
		finally
		{
			// Cleanup Database
			if(conn != null)
			{
				try 
				{
					conn.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
					throw new DatabaseException(e);
				}
			}
		}
		return null;
	}

	

}
