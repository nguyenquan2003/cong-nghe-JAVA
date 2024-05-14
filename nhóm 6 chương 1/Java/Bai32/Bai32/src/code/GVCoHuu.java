package code;

import java.util.Scanner;

public class GVCoHuu extends LDBienChe{
    private double hsThamNien;

    public GVCoHuu(String maSo, String hoTen, int namSinh, double HSL, double hsThamNien) {
        super(maSo, hoTen, namSinh, HSL);
        this.hsThamNien = hsThamNien;
    }

    public GVCoHuu() {
        super("00", "A", 2000, 3.0);
        this.hsThamNien = 0;
    }

    public double getHsThamNien() {
        return hsThamNien;
    }
    public void setHsThamNien(double hsThamNien) {
        this.hsThamNien = hsThamNien;
    }

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.println("Nhap he so tham nien: ");
        hsThamNien = sc.nextDouble();
    }

    @Override
    public double tinhLuong() {
        return super.tinhLuong()*(1+hsThamNien);
    }

    @Override
    public void xuat() {
        System.out.println("Giao vien co huu");
        super.xuat();
        System.out.printf("Luong: %.0f" , tinhLuong());
    }

    
}
