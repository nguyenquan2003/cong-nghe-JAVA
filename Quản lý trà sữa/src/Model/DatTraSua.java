/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Nguyen Cat Tuong
 */
public class DatTraSua {
    
    String maHDB;
    String soDienThoai;
    String tenNhanVien;
    String tenKhachHang;
    String tenTraSua; 
    int soLuong;
    float donGia;
    float khuyenMai;
    float thanhTien;

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

   
    public String getMaHDB() {
        return maHDB;
    }

    public void setMaHDB(String maHDB) {
        this.maHDB = maHDB;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public float getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(float khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getTenTraSua() {
        return tenTraSua;
    }

    public void setTenTraSua(String tenTraSua) {
        this.tenTraSua = tenTraSua;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public DatTraSua() {
    }

    public DatTraSua(String tenTraSua, int soLuong, float donGia) {
        this.tenTraSua = tenTraSua;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public DatTraSua(String tenNhanVien, String tenKhachHang, String tenTraSua, int soLuong, float donGia) {
        this.tenNhanVien = tenNhanVien;
        this.tenKhachHang = tenKhachHang;
        this.tenTraSua = tenTraSua;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public DatTraSua(String maHDB, String soDienThoai, String tenNhanVien, String tenKhachHang, String tenTraSua, int soLuong, float donGia, float khuyenMai,float thanhTien) {
        this.maHDB = maHDB;
        this.soDienThoai = soDienThoai;
        this.tenNhanVien = tenNhanVien;
        this.tenKhachHang = tenKhachHang;
        this.tenTraSua = tenTraSua;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.khuyenMai = khuyenMai;
        this.thanhTien = thanhTien;

    }

    public DatTraSua(String maHDB, String soDienThoai, String tenNhanVien, float khuyenMai, float thanhTien) {
        this.maHDB = maHDB;
        this.soDienThoai = soDienThoai;
        this.tenNhanVien = tenNhanVien;
        this.khuyenMai = khuyenMai;
        this.thanhTien = thanhTien;
    }

    public DatTraSua(String maHDB, String tenTraSua, int soLuong, float khuyenMai, float thanhTien) {
        this.maHDB = maHDB;
        this.tenTraSua = tenTraSua;
        this.soLuong = soLuong;
        this.khuyenMai = khuyenMai;
        this.thanhTien = thanhTien;
    }

  
    
    
    
}
