/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai4.Business;
import Bai4.DAO.SanPhamDAO;
import Bai4.Model.SanPham;
import java.sql.*;
import java.util.List;
/**
 *
 * @author ADMIN
 */
public class SanPhamBusiness {
    private SanPhamDAO sanPhamDAO;

    public SanPhamBusiness(Connection connection) {
        this.sanPhamDAO = new SanPhamDAO(connection);
    }

    public List<SanPham> getAllSanPham() throws SQLException {
        return sanPhamDAO.getAllSanPham();
    }

    public void addSanPham(SanPham sanPham) throws SQLException {
        sanPhamDAO.addSanPham(sanPham);
    }

    public void updateSanPham(SanPham sanPham) throws SQLException {
        sanPhamDAO.updateSanPham(sanPham);
    }

    public void deleteSanPham(String maSP) throws SQLException {
        sanPhamDAO.deleteSanPham(maSP);
    }
    public List<SanPham> getSanPhamByDanhMuc(String maDanhMuc) throws SQLException {
        return sanPhamDAO.getSanPhamByDanhMuc(maDanhMuc);
    }
}