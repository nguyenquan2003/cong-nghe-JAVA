package dao;
import java.sql.ResultSet;

import java.util.ArrayList;

import pojo.LoaiSachPOJO;
public class LoaiSachDAO {
	public static ArrayList<LoaiSachPOJO> layDanhSachLoaiSach() { 
		ArrayList<LoaiSachPOJO> ds = new ArrayList<LoaiSachPOJO>();
		try{
			String sql = "SELECT * FROM LoaiSach";
			MySQLDataAccess helper = new MySQLDataAccess(); 
			helper.open();
			ResultSet rs = helper.executeQuery(sql); 
			while (rs.next()) {
				LoaiSachPOJO ls = new LoaiSachPOJO();
				ls.setiID(rs.getInt("LS_ID")); 
				ls.setStrTen(rs.getString("Ten"));
				ls.setStrMoTa(rs.getString("MoTa")); 
				ds.add(ls);
			}
			
			helper.close();
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return ds;
	}
	public static int themLoaiSach(String tensach, String mota)
	{
		try {
			String insertQuery = "INSERT INTO LOAISACH (TEN,MOTA) VALUES ('"+tensach+"','"+ mota+"')";
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
	public static int xoaLoaiSach(int ID)
	{
		try {
			String insertQuery = "DELETE FROM LOAISACH WHERE LS_ID ="+ID;
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
	
	public static int suaLoaiSach(int ID,String tensach, String mota)
	{
		try {
			String insertQuery = "UPDATE LOAISACH SET ";
			if(!tensach.isEmpty())
			{
				insertQuery+= "TEN = '"+tensach+"'";
			}
			
			if(!mota.isEmpty() )
			{
				if(!tensach.isEmpty() )
				{
					insertQuery+=",";
				}
				insertQuery+= "MOTA = '"+mota+"'";
			}
			insertQuery+=" WHERE LS_ID ="+ID;
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
