/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai4.Business;

import Bai4.DAO.DanhMucDAO;
import Bai4.Model.DanhMuc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ADMIN
 */
public class DanhMucBusiness {
    private DanhMucDAO danhMucDAO;

    public DanhMucBusiness(Connection connection) {
        this.danhMucDAO = new DanhMucDAO(connection);
    }

    public List<DanhMuc> getAllDanhMuc() throws SQLException {
        return danhMucDAO.getAllDanhMuc();
    }

    public void addDanhMuc(DanhMuc danhMuc) throws SQLException {
        danhMucDAO.addDanhMuc(danhMuc);
    }

    public void updateDanhMuc(DanhMuc danhMuc) throws SQLException {
        danhMucDAO.updateDanhMuc(danhMuc);
    }

    public void deleteDanhMuc(String maDM) throws SQLException {
        danhMucDAO.deleteDanhMuc(maDM);
    }
    public String getMaDanhMucByTenDanhMuc(String tenDanhMuc) throws SQLException {
        return danhMucDAO.getMaDMByTenDM(tenDanhMuc);
    }
}

