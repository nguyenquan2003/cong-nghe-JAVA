package Bai3_5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Connect {

    public static void main(String[] args) {
        getConnection();
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Properties properties = new Properties();
            properties.setProperty("user", "sa");
            properties.setProperty("password", "123");
            properties.setProperty("encrypt", "true");
            properties.setProperty("trustServerCertificate", "true");
            String url = "jdbc:sqlserver://DESKTOP-J9MDADE\\BAO;databaseName=QL_NhaSach;";
            connection = DriverManager.getConnection(url, properties);
            System.out.println("Kết nối thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}