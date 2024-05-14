package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class MSSQLDataAccess {
	private Connection connection;

	public void Open() {
		String ServerName = "DESKTOP-1HLJNV7";
		String DatabaseName = "RENT_BOOK";
		String UserName = "sa";
	    String Password = "123";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL = "jdbc:sqlserver://" + ServerName + ":1433;databaseName=" + DatabaseName + ";user=" + UserName + ";password=" + Password + ";encrypt=true;trustServerCertificate=true";
			
	        connection = DriverManager.getConnection(connectionURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Close() {
		try {
			this.connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet ExecuteQuery(String sql) {
		ResultSet rs = null;
		try {
			Statement sm = connection.createStatement();
			rs = sm.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public int ExecuteUpdate(String sql) {
		int n = -1;
		try {
			Statement sm = connection.createStatement();
			n = sm.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}
}
