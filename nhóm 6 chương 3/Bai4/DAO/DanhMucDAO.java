/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai4.DAO;

import Bai4.Model.DanhMuc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DanhMucDAO {

    private Connection connection;

    public DanhMucDAO(Connection connection) {
        this.connection = connection;
    }

    public List<DanhMuc> getAllDanhMuc() throws SQLException {
        List<DanhMuc> danhMucList = new ArrayList<>();
        String query = "SELECT * FROM danhmuc";
        try (PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                DanhMuc danhMuc = new DanhMuc();
                danhMuc.setMaDM(rs.getString("MaDM"));
                danhMuc.setTenDM(rs.getString("TenDM"));
                danhMuc.setDelete(rs.getBoolean("isDelete"));
                danhMucList.add(danhMuc);
            }
        }
        return danhMucList;
    }

    public void addDanhMuc(DanhMuc danhMuc) throws SQLException {
        String query = "INSERT INTO danhmuc (MaDM, TenDM, isDelete) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, danhMuc.getMaDM());
            pstmt.setString(2, danhMuc.getTenDM());
            pstmt.setBoolean(3, danhMuc.isDelete());
            pstmt.executeUpdate();
        }
    }

    public void updateDanhMuc(DanhMuc danhMuc) throws SQLException {
        String query = "UPDATE danhmuc SET TenDM = ?, isDelete = ? WHERE MaDM = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, danhMuc.getTenDM());
            pstmt.setBoolean(2, danhMuc.isDelete());
            pstmt.setString(3, danhMuc.getMaDM());
            pstmt.executeUpdate();
        }
    }

    public void deleteDanhMuc(String maDM) throws SQLException {
        String query = "DELETE FROM danhmuc WHERE MaDM = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, maDM);
            pstmt.executeUpdate();
        }
    }
    public String getMaDMByTenDM(String tenDanhMuc) throws SQLException {
        String maDanhMuc = null;
        String query = "SELECT MaDM FROM danhmuc WHERE TenDM = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, tenDanhMuc);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    maDanhMuc = rs.getString("MaDM");
                }
            }
        }
        return maDanhMuc;
    }
}
