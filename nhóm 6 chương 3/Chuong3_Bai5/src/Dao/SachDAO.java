package Dao;

import Pojo.SachPOJO;
import java.sql.ResultSet;
import java.util.ArrayList;

import Gui.Sach;

import java.sql.*;

public class SachDAO {
	public static ArrayList<SachPOJO> LayDSSach() {
		ArrayList<SachPOJO> ds = new ArrayList<SachPOJO>();
		try {
			String sql = "SELECT * FROM Sach";
			MSSQLDataAccess helper = new MSSQLDataAccess();
			helper.Open();
			ResultSet rs = helper.ExecuteQuery(sql);
			while (rs.next()) {
				SachPOJO s = new SachPOJO();
				s.setiID(rs.getInt("S_ID"));
				s.setStrTen(rs.getString("TieuDe"));
				s.setStrTacGia(rs.getString("TacGia"));
				s.setNXB(rs.getInt("NamXuatBan"));
				s.setiLSID(rs.getInt("LS_ID"));
				s.setStrMoTa(rs.getString("MoTa"));
				
				ds.add(s);
			}
			helper.Close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ds;
	}
	
	public static boolean ThemSach(String txtTen, String txtTacGia, int txtNXB, int txtTheLoai, String txtMoTa) {
	    boolean kq = false;
	    String sql = String.format("INSERT INTO Sach (TieuDe, TacGia, NamXuatBan, LS_ID, MoTa) VALUES (N'%s', N'%s', %d, %d, N'%s');", txtTen, txtTacGia, txtNXB, txtTheLoai, txtMoTa);
	    MSSQLDataAccess provider = new MSSQLDataAccess();
	    provider.Open();
	    int n = provider.ExecuteUpdate(sql);
	    if (n == 1) {
	        kq = true;
	    }
	    provider.Close();
	    return kq;
	}
		
	public static boolean XoaSach (int id) {
		boolean kq = false;
		String sql = String.format("DELETE FROM Sach WHERE S_ID=%d", id);
		MSSQLDataAccess provider = new MSSQLDataAccess();
		provider.Open();
		int n = provider.ExecuteUpdate(sql);
		if (n == 1) {	
			kq= true;
		}
		provider.Close();
		return kq;
	}
	
	public static boolean SuaSach (String txtTen, String txtTacGia, int txtNXB, int txtTheLoai, String txtMoTa, int id) {
		boolean kq = false;
		String sql = String.format("UPDATE Sach SET TieuDe=N'%s', TacGia=N'%s', NamXuatBan=%d, LS_ID=%d, MoTa=N'%s' WHERE S_ID=%d", txtTen, txtTacGia, txtNXB, txtTheLoai, txtMoTa, id);
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
