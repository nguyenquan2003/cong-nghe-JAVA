package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import pojo.PhieuNhapSachPOJO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class PhieuNhapSachDAO {
	public static ArrayList<PhieuNhapSachPOJO> layDanhPNS() { 
		ArrayList<PhieuNhapSachPOJO> ds = new ArrayList<PhieuNhapSachPOJO>();
		try{
			String sql = "SELECT * FROM PhieuNhapSach";
			MySQLDataAccess helper = new MySQLDataAccess(); 
			helper.open();
			ResultSet rs = helper.executeQuery(sql); 
			while (rs.next()) {
				PhieuNhapSachPOJO pns = new PhieuNhapSachPOJO();
				pns.setiPNS_ID(rs.getInt("PNS_ID"));
				pns.setStrGhiChu(rs.getString("GhiChu"));
				pns.setdNgay(rs.getDate("Ngay")); 
				pns.setStrNhanVien(rs.getString("NhanVien")); 
				ds.add(pns);
			}
			
			helper.close();
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return ds;
	}
	public static int themPhieuNhapSach(String ghichu, Date ngay, String nhanvien)
	{
		try {
			
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String dateString = dateFormat.format(ngay);
			String insertQuery = "INSERT INTO PhieuNhapSach (ghichu,ngay,nhanvien) VALUES ('"+ghichu+"','"+ dateString+"','"+nhanvien+"')";
			MySQLDataAccess helper = new MySQLDataAccess(); 
			helper.open();
			int rs = helper.executeUpdate(insertQuery); 
			helper.close();
			return rs;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}
	public static int xoaPhieuNhapSach(int ID)
	{
		try {
			String insertQuery = "DELETE FROM PhieuNhapSach WHERE PNS_ID ="+ID;
			MySQLDataAccess helper = new MySQLDataAccess(); 
			helper.open();
			int rs = helper.executeUpdate(insertQuery); 
			helper.close();
			return rs;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}
	
	public static int suaPhieuNhapSach(int ID,String ghichu, Date date, String nhanvien)
	{
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String ngay = dateFormat.format(date);
			String insertQuery = "UPDATE PhieuNhapSach SET ";
			insertQuery+= "ghichu = '"+ghichu+"'";
			insertQuery+= ",ngay = '"+ngay+"'";
			insertQuery+= ",nhanvien = '"+nhanvien+"'";
			insertQuery+=" WHERE PNS_ID ="+ID;
			MySQLDataAccess helper = new MySQLDataAccess(); 
			helper.open();
			int rs = helper.executeUpdate(insertQuery); 
			helper.close();
			return rs;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return -1;
	}
}
