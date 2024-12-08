/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Cat Tuong
 */

public class KetNoi {
          private static final String  user="sa";
          private static  final String   pass="123"; 
         private static  final String    url="jdbc:sqlserver://DESKTOP-KSEC4J7\\SQLEXPRESS:1433;databaseName=QL_QUAN_TRA_SUA";
  
    /**
     *
     * @return
     * @throws SQLException
     */
    public static Connection connectToDatabase() throws SQLException
    {
        try
        {
              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }     catch (ClassNotFoundException ex) {
                  Logger.getLogger(KetNoi.class.getName()).log(Level.SEVERE, null, ex);
              }
          return DriverManager.getConnection(url, user,pass);

    }
}
