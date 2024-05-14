/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai4.Model;

/**
 *
 * @author ADMIN
 */
public class DanhMuc {
    private String maDM;
    private String tenDM;
    private boolean isDelete;

    public DanhMuc() {
    }

    public DanhMuc(String maDM, String tenDM, boolean isDelete) {
        this.maDM = maDM;
        this.tenDM = tenDM;
        this.isDelete = isDelete;
    }

    
    public String getMaDM() {
        return maDM;
    }

    public void setMaDM(String maDM) {
        this.maDM = maDM;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}

