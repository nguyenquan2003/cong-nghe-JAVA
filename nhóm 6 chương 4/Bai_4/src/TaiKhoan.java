/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class TaiKhoan {
    public String threadName;
    public int soTienChuyen;
    public int chuyenTuTK;
    public int chuyenToiTK;
    public int tongTien;

    public TaiKhoan(String threadName, int soTienChuyen, int chuyenTuTK, int chuyenToiTK, int tongTien) {
        this.threadName = threadName;
        this.soTienChuyen = soTienChuyen;
        this.chuyenTuTK = chuyenTuTK;
        this.chuyenToiTK = chuyenToiTK;
        this.tongTien = tongTien;
    }
    
    public synchronized void chuyenTien(int a) throws InterruptedException {
        if(this.tongTien >= 0 && (this.tongTien - a) >= 0) {
            //Thread.sleep(1000);
            this.tongTien = this.tongTien - a;
        }
    }
}
