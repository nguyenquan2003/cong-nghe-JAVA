package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import pojo.NguoiDungPOJO;

public class NguoiDungDAO {
	public static ArrayList<NguoiDungPOJO> layDanhSachNguoiDung() { 
		ArrayList<NguoiDungPOJO> ds = new ArrayList<NguoiDungPOJO>();
		try{
			String sql = "SELECT * FROM NGUOIDUNG";
			MySQLDataAccess helper = new MySQLDataAccess(); 
			helper.open();
			ResultSet rs = helper.executeQuery(sql); 
			while (rs.next()) {
				NguoiDungPOJO ls = new NguoiDungPOJO();
				ls.setiND_ID(rs.getInt("ND_ID")); 
				ls.setStrHoTen(rs.getString("HoTen"));
				ds.add(ls);
			}
			
			helper.close();
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return ds;
	}
}
