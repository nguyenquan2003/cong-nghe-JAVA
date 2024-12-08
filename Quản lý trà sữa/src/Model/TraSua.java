/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Nguyen Cat Tuong
 */
public class TraSua {
    
    String maTraSua;

    public TraSua(String tenTraSua, String idHinh) {
        this.tenTraSua = tenTraSua;
        this.idHinh = idHinh;
    }
    String tenTraSua;
    float giaBan;
    float giaNhap;
    String tenNCC;
    String idHinh;

    TraSua(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMaTraSua() {
        return maTraSua;
    }

    public void setMaTraSua(String maTraSua) {
        this.maTraSua = maTraSua;
    }

    public String getTenTraSua() {
        return tenTraSua;
    }

    public void setTenTraSua(String tenTraSua) {
        this.tenTraSua = tenTraSua;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }
    

    public TraSua(String maTraSua, String tenTraSua, float giaBan, float giaNhap, String tenNCC) {
        this.maTraSua = maTraSua;
        this.tenTraSua = tenTraSua;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.tenNCC = tenNCC;
    }

    public TraSua(String maTraSua, String tenTraSua, float giaBan, String tenNCC) {
        this.maTraSua = maTraSua;
        this.tenTraSua = tenTraSua;
        this.giaBan = giaBan;
        this.tenNCC = tenNCC;
    }
   

    public TraSua() {
    }

    public String getIdHinh() {
        return idHinh;
    }

    public void setIdHinh(String idHinh) {
        this.idHinh = idHinh;
    }

    public TraSua(String maTraSua,String tenTraSua, String idHinh) {
        this.maTraSua = maTraSua;
        this.tenTraSua = tenTraSua;
        this.idHinh = idHinh;
    }

    public TraSua(String maTraSua, String tenTraSua, float giaBan, float giaNhap, String tenNCC, String idHinh) {
        this.maTraSua = maTraSua;
        this.tenTraSua = tenTraSua;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.tenNCC = tenNCC;
        this.idHinh = idHinh;
    }

    public TraSua(String maTraSua, String tenTraSua, float giaBan, String tenNCC, String idHinh) {
        this.maTraSua = maTraSua;
        this.tenTraSua = tenTraSua;
        this.giaBan = giaBan;
        this.tenNCC = tenNCC;
        this.idHinh = idHinh;
    }
    
   
    
    
    
}
