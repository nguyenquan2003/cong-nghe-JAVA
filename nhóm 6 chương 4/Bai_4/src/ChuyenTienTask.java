/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class ChuyenTienTask implements Runnable{
    private TaiKhoan taiKhoan;

    public ChuyenTienTask(TaiKhoan chuyenTien) {
        this.taiKhoan = chuyenTien;
    }
    @Override
    public void run() {
        try {
            this.taiKhoan.chuyenTien(taiKhoan.soTienChuyen);
            System.out.println(this.taiKhoan.tongTien);
        } catch(InterruptedException ex ) {
            System.err.println(ex);
        }
    }
}
