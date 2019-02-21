package ca.sheridan.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerDataSource {
	public Connection getConnection() throws SQLException{
		Connection conn = null;
		String driverName = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			 e.printStackTrace();
		}
		
		
		String conURL = "jdbc:mysql://localhost/EJD?useSSL=false";
		String user = "root";
		String pass = "sheridan";
		try {
			conn = DriverManager.getConnection(conURL, user, pass);
		} catch (SQLException e) {
			// TODO Handle the exception
			e.printStackTrace();
		}
			
		
		return conn;

	}

}
