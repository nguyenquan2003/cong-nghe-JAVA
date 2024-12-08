/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhom11_qltrasua;

/**
 *
 * @author nguye
 */
public class HoaDon {
    private String maHD;
    private String maNV;
    private String maKH;
    private String tenSP;
    private int soluong;
    private double thanhtien;

    public HoaDon(String maHD, String maNV, String maKH, String tenSP, int soluong, double thanhtien) {
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.tenSP = tenSP;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }


    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(float thanhtien) {
        this.thanhtien = thanhtien;
    }
    
}
