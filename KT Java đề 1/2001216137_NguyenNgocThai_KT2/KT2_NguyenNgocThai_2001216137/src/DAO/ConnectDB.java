package DAO;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.*;

public class ConnectDB {

    private Connection conn;
    private static final String SERVER = "ThaiDepTroai\\SQLEXPRESS";
    private static final String USER = "ngocthai";
    private static final String PASSWORD = "310803";
    private static final String DATABASE = "qllophoc";
    private static final int PORT = 1433;

    public static Connection open() throws ClassNotFoundException {
        try {
            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setTrustServerCertificate(true); 
            ds.setUser(USER);
            ds.setPassword(PASSWORD);
            ds.setDatabaseName(DATABASE);
            ds.setServerName(SERVER);
            ds.setPortNumber(PORT);
             return ds.getConnection(); 
        } catch (SQLException e) {
                System.out.println("Database connection error: " + e.getMessage());
        }
        return null;
    }

    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    public ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try{
            Statement sm = conn.createStatement();
            rs = sm.executeQuery(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int executeUpdate(String sql) {
        int n = -1;
        try{
            Statement sm = conn.createStatement();
            n = sm.executeUpdate(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }
}
