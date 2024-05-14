package Dao;

import Pojo.PhieuNhapSachPOJO;

import java.util.ArrayList;

import Gui.PhieuNhapSach;

import java.sql.*;
import java.text.SimpleDateFormat;

public class PhieuNhapSachDAO {
	public static ArrayList<PhieuNhapSachPOJO> LayDSPhieuNhapSach() {
		ArrayList<PhieuNhapSachPOJO> ds = new ArrayList<PhieuNhapSachPOJO>();
		try {
			String sql = "SELECT * FROM PhieuNhapSach";
			MSSQLDataAccess helper = new MSSQLDataAccess();
			helper.Open();
			ResultSet rs = helper.ExecuteQuery(sql);
			while (rs.next()) {
				PhieuNhapSachPOJO s = new PhieuNhapSachPOJO();
				s.setiID(rs.getInt("PNS_ID"));
				s.setStrGhiChu(rs.getString("GhiChu"));
				s.setNgay(rs.getString("Ngay"));
				s.setStrNhanVien(rs.getString("NhanVien"));
				
				ds.add(s);
			}
			helper.Close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}
	
	public static boolean ThemPNS(String GhiChu, String Ngay,  String NhanVien) {
	    boolean kq = false;
	    String sql = String.format("INSERT INTO PhieuNhapSach (GhiChu, Ngay, NhanVien) VALUES (N'%s', '%s', N'%s');", GhiChu, Ngay, NhanVien);
	    MSSQLDataAccess provider = new MSSQLDataAccess();
	    provider.Open();
	    int n = provider.ExecuteUpdate(sql);
	    if (n == 1) {
	        kq = true;
	    }
	    provider.Close();
	    return kq;
	}
		
	public static boolean XoaPNS(int id) {
		boolean kq = false;
		String sql = String.format("DELETE FROM PhieuNhapSach WHERE PNS_ID=%d", id);
		MSSQLDataAccess provider = new MSSQLDataAccess();
		provider.Open();
		int n = provider.ExecuteUpdate(sql);
		if (n == 1) {	
			kq= true;
		}
		provider.Close();
		return kq;
	}
	
	public static boolean SuaPNS(String GhiChu, String Ngay,  String NhanVien, int id) {
		boolean kq = false;
		String sql = String.format("UPDATE PhieuNhapSach SET GhiChu=N'%s', Ngay='%s', NhanVien=N'%s', WHERE PNS_ID=%d", GhiChu, Ngay, NhanVien, id);
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
