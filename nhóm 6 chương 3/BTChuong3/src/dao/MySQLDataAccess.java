package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

public class MySQLDataAccess {

	private Connection connection;
	public void open() {
        try {
            Properties properties = new Properties();
            properties.setProperty("user", "sa");
            properties.setProperty("password", "123");
            properties.setProperty("encrypt", "true");
            properties.setProperty("trustServerCertificate", "true");
            String url = "jdbc:sqlserver://DESKTOP-J9MDADE\\BAO;databaseName=QL_NhaSach;";
            connection = DriverManager.getConnection(url, properties);      
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
	public void close() {
		try {
			this.connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			java.sql.Statement sm = connection.createStatement();
			rs = sm.executeQuery(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	public int executeUpdate(String sql) {
		int n = -1;
		try {
			java.sql.Statement sm = connection.createStatement();
			n = sm.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}
	
}
