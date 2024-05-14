package Dao;

import Pojo.LoaiSachPOJO;
import java.sql.ResultSet;
import java.util.ArrayList;

import Gui.DanhMucLoaiSach;

import java.sql.*;

public class LoaiSachDAO {

	public static ArrayList<LoaiSachPOJO> LayDSLoaiSach() {
		ArrayList<LoaiSachPOJO> ds = new ArrayList<LoaiSachPOJO>();
		try {
			String sql = "SELECT * FROM LoaiSach";
			MSSQLDataAccess helper = new MSSQLDataAccess();
			helper.Open();
			ResultSet rs = helper.ExecuteQuery(sql);
			while (rs.next()) {
				LoaiSachPOJO ls = new LoaiSachPOJO();
				ls.setiID(rs.getInt("LS_ID"));
				ls.setStrTen(rs.getString("Ten"));
				ls.setStrMoTa(rs.getString("MoTa"));
				
				ds.add(ls);
			}
			helper.Close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}
	
	public static boolean ThemLoaiSach(String txtTen, String txtMoTa) {
	    boolean kq = false;
	    String sql = String.format("INSERT INTO LoaiSach (Ten, MoTa) VALUES (N'%s', N'%s');", txtTen, txtMoTa);
	    MSSQLDataAccess provider = new MSSQLDataAccess();
	    provider.Open();
	    int n = provider.ExecuteUpdate(sql);
	    if (n == 1) {
	        kq = true;
	    }
	    provider.Close();
	    return kq;
	}
		
	public static boolean XoaLoaiSach (int id) {
		boolean kq = false;
		String sql = String.format("DELETE FROM LoaiSach WHERE LS_ID=%d", id);
		MSSQLDataAccess provider = new MSSQLDataAccess();
		provider.Open();
		int n = provider.ExecuteUpdate(sql);
		if (n == 1) {	
			kq= true;
		}
		provider.Close();
		return kq;
	}
	
	public static boolean SuaLoaiSach (String txtTen, String txtMoTa, int id) {
		boolean kq = false;
		String sql = String.format("UPDATE LoaiSach SET Ten=N'%s', MoTa=N'%s' WHERE LS_ID=%d", txtTen, txtMoTa, id);
		MSSQLDataAccess provider = new MSSQLDataAccess();
		provider.Open();
		int n = provider.ExecuteUpdate(sql);
		if (n == 1) {	
			kq= true;
			provider.Close();
		}
		return kq;
	}

}
