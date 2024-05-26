package DAO;

import java.beans.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import POJO.LopHoc;



public class LopHoc_DAO {
	
	public List<LopHoc> getAllClasses() {
		List<LopHoc> cddvds = new ArrayList<LopHoc>();
        Connection connection = JDBCConnection.getJDBCConnection();
        try {
        	Statement statement = (Statement) connection.createStatement();
            ResultSet rs = ((java.sql.Statement) statement).executeQuery("SELECT * FROM CLASSES");

            while (rs.next()) {
            	LopHoc cddvd = new LopHoc();

                cddvd.setTenLop(rs.getString("CLASS_NAME"));
                cddvd.setNgayBD(rs.getDate("START_DATE"));
                cddvd.setNgayKT(rs.getDate("END_DATE"));
                cddvd.setTestA(rs.getFloat("GRADE_TEST_A"));
                cddvd.setTestB(rs.getFloat("GRADE_TEST_B"));
                cddvd.setTestC(rs.getFloat("GRADE_TEST_C"));
                cddvd.setIdGV(rs.getInt("LECTURER_ID"));
                
                cddvds.add(cddvd);
            }
        }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cddvds;
	}
	/*public void addClass(Class cls) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO CLASSES (CLASS_NAME, START_DATE, END_DATE, GRADE_TEST_A, GRADE_TEST_B, GRADE_TEST_C, LECTURER_ID) VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, cls.getClassName());
            ps.setDate(2, cls.getStartDate());
            ps.setDate(3, cls.getEndDate());
            ps.setBigDecimal(4, cls.getGradeTestA());
            ps.setBigDecimal(5, cls.getGradeTestB());
            ps.setBigDecimal(6, cls.getGradeTestC());
            ps.setInt(7, cls.getLecturerId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
