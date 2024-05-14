package dao;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import pojo.HoaDonPOJO;

public class HoadonDAO {
	public static ArrayList<HoaDonPOJO> layDanhSachHoaDon() { 
		ArrayList<HoaDonPOJO> ds = new ArrayList<HoaDonPOJO>();
		try{
			String sql = "SELECT * FROM HOADON";
			MySQLDataAccess helper = new MySQLDataAccess(); 
			helper.open();
			ResultSet rs = helper.executeQuery(sql); 
			while (rs.next()) {
				HoaDonPOJO hd = new HoaDonPOJO();
				hd.setiHD_ID(rs.getInt("HD_ID"));
				hd.setdNgay(rs.getDate("Ngay")); 
				hd.setiND_ID(rs.getInt("ND_ID")); 
				hd.setStrTenKhachHang(rs.getString("TenKhachHang"));
				hd.setStrGhiChu(rs.getString("GhiChu")); 
				ds.add(hd);
			}
			
			helper.close();
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return ds;
	}
	public static int themHoaDon(Date date, int Nd_id, String tenKH,String ghichu)
	{
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    String ngay = dateFormat.format(date);
			String insertQuery = "INSERT INTO HoaDon (Ngay,ND_ID,TenKhachHang,GhiChu) VALUES ('"+ngay+"',"+Nd_id+",'"+ tenKH+"','"+ ghichu+"')";
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
	public static int xoaHoaDon(int ID)
	{
		try {
			String insertQuery = "DELETE FROM HoaDon WHERE HD_ID ="+ID;
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
	
	public static int suaHoaDon(int ID,Date date, int Nd_id, String tenKH,String ghichu)
	{
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    String ngay = dateFormat.format(date);
			String insertQuery = "UPDATE HoaDon SET ";
			insertQuery+= "Ngay = '"+ngay+"'";
			insertQuery+= ",Nd_id = "+Nd_id;
			insertQuery+= ",TenKhachHang = '"+tenKH+"'";
			insertQuery+= ",GhiChu = '"+ghichu+"'";
			insertQuery+=" WHERE HD_ID ="+ID;
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
