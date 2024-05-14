/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai4.DAO;

import Bai4.Model.SanPham;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class SanPhamDAO {

    private Connection connection;

    public SanPhamDAO(Connection connection) {
        this.connection = connection;
    }

    public List<SanPham> getAllSanPham() throws SQLException {
        List<SanPham> sanPhamList = new ArrayList<>();
        String query = "SELECT * FROM SanPham";
        try (PreparedStatement pstmt = connection.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setMaSP(rs.getString("MaSP"));
                sanPham.setTenSP(rs.getString("TenSP"));
                sanPham.setSoLuong(rs.getInt("SoLuong"));
                sanPham.setDonGia(rs.getFloat("DonGia"));
                sanPham.setMaDM(rs.getString("MaDM"));
                sanPham.setDelete(rs.getBoolean("isDelete"));
                sanPhamList.add(sanPham);
            }
        }
        return sanPhamList;
    }

    public void addSanPham(SanPham sanPham) throws SQLException {
        String query = "INSERT INTO SanPham (MaSP, TenSP, SoLuong, DonGia, MaDM, isDelete) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, sanPham.getMaSP());
            pstmt.setString(2, sanPham.getTenSP());
            pstmt.setInt(3, sanPham.getSoLuong());
            pstmt.setFloat(4, sanPham.getDonGia());
            pstmt.setString(5, sanPham.getMaDM());
            pstmt.setBoolean(6, sanPham.isDelete());
            pstmt.executeUpdate();
        }
    }

    public void updateSanPham(SanPham sanPham) throws SQLException {
        String query = "UPDATE SanPham SET TenSP = ?, SoLuong = ?, DonGia = ?, MaDM = ?, isDelete = ? WHERE MaSP = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, sanPham.getTenSP());
            pstmt.setInt(2, sanPham.getSoLuong());
            pstmt.setFloat(3, sanPham.getDonGia());
            pstmt.setString(4, sanPham.getMaDM());
            pstmt.setBoolean(5, sanPham.isDelete());
            pstmt.setString(6, sanPham.getMaSP());
            pstmt.executeUpdate();
        }
    }

    public void deleteSanPham(String maSP) throws SQLException {
        String query = "DELETE FROM SanPham WHERE MaSP = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, maSP);
            pstmt.executeUpdate();
        }
    }

    public List<SanPham> getSanPhamByDanhMuc(String maDanhMuc) throws SQLException {
        List<SanPham> sanPhamList = new ArrayList<>();
        String query = "SELECT * FROM sanpham WHERE MaDM = ?"; 
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, maDanhMuc);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    SanPham sanPham = new SanPham();
                    sanPham.setMaSP(rs.getString("MaSP"));
                    sanPham.setTenSP(rs.getString("TenSP"));
                    sanPham.setSoLuong(rs.getInt("SoLuong"));
                    sanPham.setDonGia(rs.getFloat("DonGia"));
                    sanPham.setMaDM(rs.getString("MaDM"));
                    sanPham.setDelete(rs.getBoolean("isDelete"));
                    sanPhamList.add(sanPham);
                }
            }
        }
        return sanPhamList;
    }
    
}
