/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class DbConnect {
    public Connection getConnection() {
            Connection conn = null;
		try {
                    //
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			try {
				conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=QuanLiLopHoc;user=sa;password=12;encrypt=true;trustServerCertificate=true");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();		
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        return conn;
        }
}
