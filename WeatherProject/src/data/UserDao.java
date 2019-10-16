package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.Local;
import javax.ejb.Stateless;

import beans.User;

@Stateless
@Local
public class UserDao implements DaoInterface {
	public UserDao() {
	}

	public Connection mysqlConnect() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/weather";

		try {
			// checks if the driver exist
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public boolean findBy(User user) {
		// TODO Auto-generated method stub
		Connection conn = mysqlConnect();
		try {
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM USERS";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if (rs.getString("USERNAME").equals(user.getUserName())
						&& rs.getString("PASSWORD").equals(user.getPassword())) {

					rs.close();
					return true;
				}
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public boolean create(User user) {
		Connection conn = mysqlConnect();
		try {
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO USERS (FIRSTNAME, LASTNAME, USERNAME, PASSWORD, EMAIL) VALUES (" + "'"
					+ user.getFirstName() + "'" + ", " + "'" + user.getLastName() + "'" + ", " + "'"
					+ user.getUserName() + "'" + ", " + "'" + user.getPassword() + "'" + ", " + "'" + user.getEmail()
					+ "'" + ")";
			stmt.execute(sql);

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL statement error");
			e.printStackTrace();
			return false;
		}

	}

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

			System.out.println("SQL statement error");
			e.printStackTrace();
			return false;
		}
		return false;
	}

}
