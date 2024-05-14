package dao;
import java.sql.ResultSet;

import java.util.ArrayList;

import pojo.SachPOJO;
public class SachDAO {
	public static ArrayList<SachPOJO> layDanhSachSach() { 
		ArrayList<SachPOJO> ds = new ArrayList<SachPOJO>();
		try{
			String sql = "SELECT * FROM Sach";
			MySQLDataAccess helper = new MySQLDataAccess(); 
			helper.open();
			ResultSet rs = helper.executeQuery(sql); 
			while (rs.next()) {
				SachPOJO s = new SachPOJO();
				s.setiS_ID(rs.getInt("S_ID")); 
				s.setStrTieuDe(rs.getString("TieuDe"));
				s.setStrTacGia(rs.getString("TacGia")); 
				s.setiNamXuatBan(rs.getInt("NamXuatBan")); 
				s.setiLS_ID(rs.getInt("LS_ID")); 
				s.setStrMota(rs.getString("MoTa")); 
				ds.add(s);
			}
			
			helper.close();
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return ds;
	}
	public static int themSach(String tieude, String tacgia, int namxb ,int ls_id, String mota)
	{
		try {
			String insertQuery = "INSERT INTO SACH (TieuDe,TacGia,NamXuatBan,LS_ID,MoTa) VALUES ('"+tieude+"','"+ tacgia+"',"+namxb+","+ls_id+",'"+mota+"')";
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
	public static int xoaSach(int ID)
	{
		try {
			String insertQuery = "DELETE FROM SACH WHERE S_ID ="+ID;
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
	
	public static int suaSach(int ID,String tieude, String tacgia, int namxb ,int ls_id, String mota)
	{
		try {
			String insertQuery = "UPDATE SACH SET ";
			insertQuery+= "TieuDe = '"+tieude+"'";
			insertQuery+= ",TacGia = '"+tacgia+"'";
			insertQuery+= ",NamXuatBan = "+namxb;
			insertQuery+= ",LS_ID = "+ls_id;
			insertQuery+= ",MOTA = '"+mota+"'";
			insertQuery+=" WHERE S_ID ="+ID;
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
