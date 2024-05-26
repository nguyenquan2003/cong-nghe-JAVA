package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection getJDBCConnection() {
		final String url = "jdbc:sqlserver://DESKTOP-K2L5MCI:1433;databaseName=ClassManagement;user=sa;password=1234567890;trustServerCertificate=true;";
		final String user = "sa";
		final String password = "1234567890";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			try {
				return DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public static void main(String[] args) {
		Connection connection = getJDBCConnection();
		if(connection != null)
		{
			System.out.println("Thanh Cong");
		}
		else {
			System.out.println("That bai");
		}
	}
}
