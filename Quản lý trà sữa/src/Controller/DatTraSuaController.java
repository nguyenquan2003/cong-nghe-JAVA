/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import Model.KetNoi;
import Model.TraSua;
import Model.DatTraSua;
import bantrasua_bientieulinh_nguyencattuong.KhachHang;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyen Cat Tuong
 */
public class DatTraSuaController {
     public ArrayList<TraSua> getTraSua()
    {
                   ArrayList<TraSua> lsTenTraSua = new ArrayList<>();

       try
          {
            Connection con;
            con = KetNoi.connectToDatabase();
            
            String sql= "select  TENTRASUA, IdHinh from TRASUA";
            
               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery(sql);
              while (rs.next())
              {
                lsTenTraSua.add(new TraSua(rs.getString("TENTRASUA"),rs.getString("IdHinh")));
              }
        
        } catch (SQLException ex) {
             Logger.getLogger(DatTraSuaController.class.getName()).log(Level.SEVERE, null, ex);
         }
     
return lsTenTraSua;
    }
     
     public ArrayList<String> getGiaBan ()
     {
         ArrayList<String> lsGiaBan = new ArrayList<>();
         try
          {
            Connection con;
            con = KetNoi.connectToDatabase();
            
            String sql= "select * from TRASUA";
            
               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery(sql);
              while (rs.next())
              {
                  Object o = rs.getInt("GiaBan");
                  lsGiaBan.add(o.toString());
              }
        
        } catch (SQLException ex) {
             Logger.getLogger(DatTraSuaController.class.getName()).log(Level.SEVERE, null, ex);
         }
         return lsGiaBan;
     }
     
    public ArrayList<TraSua> getInforTraSua ()
     {
         TraSua traSua = new TraSua();
         ArrayList<TraSua> lsTraSua = new ArrayList<>();
         Connection connection;
         try {
             connection = KetNoi.connectToDatabase();
             String sql = "select TRASUA.MATRASUA, TRASUA.TENTRASUA, TRASUA.GiaBan, NhaCungCap.TenNCC,TRASUA.IdHinh from TRASUA JOIN NhaCungCap on TRASUA.MaNCC = NhaCungCap.MaNCC";
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql);
             ImageIcon icon = null;
             while (rs.next())
             {
                    lsTraSua.add(new TraSua(rs.getString("MATRASUA"),rs.getString("TENTRASUA"),rs.getFloat("GiaBan"),rs.getString("TenNCC"),rs.getString("IdHinh")));
                
             }
           
         } catch (SQLException ex) {
             Logger.getLogger(DatTraSuaController.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return lsTraSua;
     }
     
//     public ArrayList<String> getIdImg()
//     {
//         ArrayList<String> lsIdHinh =  new ArrayList<>();
//        try
//        {
//             Connection connection = KetNoi.connectToDatabase();
//             String sql = "select IdHinh from TRASUA";
//         Statement st = connection.createStatement();
//         ResultSet rs = st.executeQuery(sql);
//         while (rs.next())
//         {
//             lsIdHinh.add(rs.getString("IdHinh"));
//         }
//        } catch (SQLException ex) {
//             Logger.getLogger(DatTraSuaController.class.getName()).log(Level.SEVERE, null, ex);
//         }
//        return lsIdHinh;
//     }
     
     public String makeNewMaHDB()
     {
         String MahDB = new String();
         try
         {
             
                      Connection connection = KetNoi.connectToDatabase();
                      String sql = "select count(*) AS count from ChiTietHoaDon";
                      PreparedStatement st = connection.prepareStatement(sql);
                      ResultSet rs = st.executeQuery();
                      if(rs.next())
                      {
                          int stt = rs.getInt("count");
                              MahDB = "HD" + stt+1 + "";
 
                      }
                          
         } catch (SQLException ex) {
             Logger.getLogger(DatTraSuaController.class.getName()).log(Level.SEVERE, null, ex);
         }
         return MahDB;
     }
         public String getIdTraSua(String tenTraSua)
         {
                             String ma = new String();
            try
            {
                String sql = "Select MATRASUA from TRASUA where TENTRASUA = N'" +tenTraSua+"'";
                 Connection connection = KetNoi.connectToDatabase();
                 Statement st = connection.createStatement();
                 ResultSet rs = st.executeQuery(sql);
                 
                 if (rs.next())
                 {
                     ma = rs.getString("MATRASUA");
                 }
            } catch (SQLException ex) {
             Logger.getLogger(DatTraSuaController.class.getName()).log(Level.SEVERE, null, ex);
         }
             return ma;
         }
     
//  public void taoHoaDon()
//  {
//    try
//    {
//         Connection connection = KetNoi.connectToDatabase();
//         DatTraSua datTraSua = new DatTraSua();
//     String sql = "insert into ChiTietHoaDon (MaHDB,MATRASUA,SoLuong,TongTien) values '"+makeNewMaHDB()+"','" +getIdTraSua(datTraSua.getTenTraSua())+"','"+datTraSua.getSoLuong()+"','";
//    }
//  }
          
     public String makeMaHoaDon()
     {
         String hoaDonId = null;
          try 
          {
              String sql = "Select count(MaHDB) as MaHDB from HoaDonBan";
              Connection conn = KetNoi.connectToDatabase();
              Statement st = conn.createStatement();
              ResultSet rs = st.executeQuery(sql);
              int idHoDon = 0;
              if(rs.next())
              {
                                 idHoDon = rs.getInt("MaHDB");

              }
              if(idHoDon < 9 && idHoDon >= 0)
                  hoaDonId = "HD00" + (idHoDon+1);
              else if(idHoDon >= 9 && idHoDon < 99)
                  hoaDonId = "HD0" + (idHoDon + 1);
              else if(idHoDon >= 99  && idHoDon <999)
                  hoaDonId = "HD" + (idHoDon + 1);
              else
                  hoaDonId = "Full";
          } catch (SQLException ex) {
             Logger.getLogger(DatTraSuaController.class.getName()).log(Level.SEVERE, null, ex);
         }
          return hoaDonId;
     }
    
   
     public ArrayList<String> getTenNhanVien()
    {
                   ArrayList<String> lsNhanVien = new ArrayList<>();

       try
          {
            Connection con;
            con = KetNoi.connectToDatabase();
            
            String sql= "select * from NHANVIEN";
            
               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery(sql);
              while (rs.next())
              {
                  Object o = rs.getString("TENNV");
                  lsNhanVien.add(o.toString());
              }
        
        } catch (SQLException ex) {
             Logger.getLogger(DatTraSuaController.class.getName()).log(Level.SEVERE, null, ex);
         }
     
return lsNhanVien;
    }
     
     public String getTenKH (String soDienThoai)
     {
            KhachHang khachHang = new KhachHang();
         String tenKH = khachHang.getTenKhachHang();
        try
        {
          Connection conn = KetNoi.connectToDatabase();
        String sql = "Select TENKH as tenkh from KHACHHANG where SDT = '" +soDienThoai+ "'";
        Statement st  = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        if(rs.next())
            tenKH = rs.getString("tenkh");
        } catch (SQLException ex) { 
             Logger.getLogger(DatTraSuaController.class.getName()).log(Level.SEVERE, null, ex);
         }
        return tenKH;
     }
     
     
     public String getIdNhanVien(String tenNhanVien)
     {
         String idNhanVien = null;
         try
         {
             Connection conn = KetNoi.connectToDatabase();
             String sql  = "Select MANV as manv from NHANVIEN where TENNV = N'"+tenNhanVien+"'";
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql);
             if(rs.next())
             idNhanVien = rs.getString("manv");
         } catch (SQLException ex) {
             Logger.getLogger(DatTraSuaController.class.getName()).log(Level.SEVERE, null, ex);
         }
         return idNhanVien;
     }
     
     public  String getIdKhachHang(String soDienThoai)
     {
         String idKhach  = null;
         try 
         {
              Connection conn = KetNoi.connectToDatabase();
             String sql  = "Select MAKH as makh from KHACHHANG where SDT = '"+soDienThoai+"'";
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql);
             if(rs.next())
             idKhach = rs.getString("makh");
         } catch (SQLException ex) {
             Logger.getLogger(DatTraSuaController.class.getName()).log(Level.SEVERE, null, ex);
         }
         return idKhach;
     }
     
     public String taoMaKhachHang()
     {
         String idKhachHang = "";
        try
        {
             Connection con;
            con = KetNoi.connectToDatabase();
            String sql= "select count(*) from KHACHHANG";
            
            Statement st = (Statement) con.createStatement();
            ResultSet result = st.executeQuery(sql);
            
            int number = 0;
            while (result.next())
            {
                 number  = result.getInt(1);
               
            }
             if (number >= 0 && number < 10)
                idKhachHang = "KH00" + String.valueOf(number + 1);
            else if (number >= 10 && number < 100) 
                idKhachHang ="KH0" + String.valueOf(number +1);
            else if (number >= 100 && number < 1000)
                idKhachHang = "KH" + String.valueOf(number + 1);
            else
                JOptionPane.showMessageDialog(null, "Hóa đơn trong cơ sở dữ liệu đã đầy. Vui lòng liên hệ nhà phát triển để tăng ô chứa dữ liệu!");
        } catch (SQLException ex) {
             Logger.getLogger(DatTraSuaController.class.getName()).log(Level.SEVERE, null, ex);
         }
        return idKhachHang;
     }
     
     public void themKhachHangMoi(String tenKhachHang, String soDienThoai,int trangThai)
     {
         String idKhachHang = taoMaKhachHang();
         try 
                 {
                     String sql = "insert into KHACHHANG values (?,?,?,?)";
                     Connection conn = KetNoi.connectToDatabase();
                     PreparedStatement psm = conn.prepareStatement(sql);
                     psm.setString(1, idKhachHang);
                     psm.setString(2, tenKhachHang);
                     psm.setString(3, soDienThoai);
                     psm.setInt(4, trangThai);
                     psm.executeUpdate();
                     psm.close();
                     JOptionPane.showMessageDialog(null, "Khách hàng mới");
                 } catch (SQLException ex) {
             Logger.getLogger(DatTraSuaController.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     public float getGiamGia(Object o )
     {
         return Float.parseFloat(o.toString());
     }
     
      public float getThanhTien(Object o )
     {
         return Float.parseFloat(o.toString());
     }
      
     public void themHoaDon(DatTraSua datTraSua)
     {
         
          
          String maKhachHang = "";
           maKhachHang = getIdKhachHang(datTraSua.getSoDienThoai());
          if(maKhachHang.isEmpty())
          {
              maKhachHang = taoMaKhachHang();
          } 
                  
          String maNhanVien = getIdNhanVien(datTraSua.getTenNhanVien());

                try
         {
             Connection conn = KetNoi.connectToDatabase();
             String sql = "insert into HoaDonBan values(?,?,?,?,?)";

         PreparedStatement st = conn.prepareStatement(sql);
         
         st.setString(1, datTraSua.getMaHDB());
         st.setString(2,maNhanVien);
         st.setString(3, maKhachHang);
         st.setFloat(4,datTraSua.getThanhTien());
         st.setFloat(5, datTraSua.getKhuyenMai());
         st.executeUpdate();
         
        JOptionPane.showMessageDialog(null, "success");
       
        conn.close();
         
         
       
         } catch (SQLException ex) {
             Logger.getLogger(DatTraSuaController.class.getName()).log(Level.SEVERE, null, ex);
         }
         
     }
     
     
     public  String getMaTraSua(String tenTraSua)
     {
         String maTraSua = "";
         try 
                 {
                     Connection conn = KetNoi.connectToDatabase();
                     String sql = "select MATRASUA as matrasua FROM TRASUA WHERE TENTRASUA = N'"+tenTraSua+"'";
                     Statement st = conn.createStatement();
                     ResultSet rs = st.executeQuery(sql);
                     if(rs.next())
                       maTraSua =   rs.getString("matrasua");
                 } catch (SQLException ex) {
             Logger.getLogger(DatTraSuaController.class.getName()).log(Level.SEVERE, null, ex);
         }
         return maTraSua;
     }
     
     public void themChiTietHoaDon(DatTraSua datTraSua)
     {
         try 
         {
             
             
             String sql = "insert into ChiTietHoaDon values (?,?,?,?,?)";
             String maTraSua = getMaTraSua(datTraSua.getTenTraSua());
             Connection conn = KetNoi.connectToDatabase();
             PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,datTraSua.getMaHDB());
            st.setString(2, maTraSua);
            st.setInt(3, datTraSua.getSoLuong());
            st.setFloat (4, datTraSua.getKhuyenMai());
            st.setFloat(5, datTraSua.getThanhTien());
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã lưu đơn hàng thành công");
            
         } catch (SQLException ex) {
             Logger.getLogger(DatTraSuaController.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}

