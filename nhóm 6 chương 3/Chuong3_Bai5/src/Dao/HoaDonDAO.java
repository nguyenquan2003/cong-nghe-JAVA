package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import Pojo.HoaDonPOJO;

public class HoaDonDAO {
	public static ArrayList<HoaDonPOJO> LayDSSach() {
		ArrayList<HoaDonPOJO> ds = new ArrayList<HoaDonPOJO>();
		try {
			String sql = "SELECT * FROM HoaDon";
			MSSQLDataAccess helper = new MSSQLDataAccess();
			helper.Open();
			ResultSet rs = helper.ExecuteQuery(sql);
			while (rs.next()) {
				HoaDonPOJO HD = new HoaDonPOJO();
				HD.setiID(rs.getInt("HD_ID"));
				HD.setNgay(rs.getString("Ngay"));
				HD.setNhanVien(rs.getString("NhanVien"));
				HD.setTenKH(rs.getString("TenKhachHang"));
				HD.setGhiChu(rs.getString("GhiChu"));
				
				ds.add(HD);
			}
			helper.Close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}
	
	public static boolean ThemHoaDon(String Ngay, String NhanVien, String TenKH, String GhiChu) {
	    boolean kq = false;
	    String sql = String.format("INSERT INTO HoaDon (Ngay, NhanVien, TenKH, GhiChu) VALUES ('%s', N'%s', N'%s', N'%s');", Ngay, NhanVien, TenKH, GhiChu);
	    MSSQLDataAccess provider = new MSSQLDataAccess();
	    provider.Open();
	    int n = provider.ExecuteUpdate(sql);
	    if (n == 1) {
	        kq = true;
	    }
	    provider.Close();
	    return kq;
	}
		
	public static boolean XoaHoaDon (int id) {
		boolean kq = false;
		String sql = String.format("DELETE FROM HoaDon WHERE HD_ID=%d", id);
		MSSQLDataAccess provider = new MSSQLDataAccess();
		provider.Open();
		int n = provider.ExecuteUpdate(sql);
		if (n == 1) {	
			kq= true;
		}
		provider.Close();
		return kq;
	}
	
	public static boolean SuaHoaDon (String Ngay, String NhanVien, String TenKH, String GhiChu, int id) {
		boolean kq = false;
		String sql = String.format("UPDATE HoaDon SET Ngay='%s', NhanVien=N'%s', TenKH=N'%s', GhiChu=N'%s' WHERE S_ID=%d", Ngay, NhanVien, TenKH, GhiChu, id);
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
