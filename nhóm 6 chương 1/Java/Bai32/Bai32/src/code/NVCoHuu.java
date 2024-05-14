package code;

import java.util.Scanner;

public class NVCoHuu extends LDBienChe implements XetKhenThuong{
    private int soGioLamThem;

    public NVCoHuu(String maSo, String hoTen, int namSinh, double HSL, int soGioLamThem) {
        super(maSo, hoTen, namSinh, HSL);
        this.soGioLamThem = soGioLamThem;
    }
      
    public NVCoHuu() {
        super("000", "B", 2000, 3.0);
        this.soGioLamThem = 5;
    }

    public int getSoGioLamThem() {
        return soGioLamThem;
    }

    public void setSoGioLamThem(int soGioLamThem) {
        this.soGioLamThem = soGioLamThem;
    }

    @Override
    public double tinhKhenThuong() {
        
        if(soGioLamThem > 40)
        {
            return 1000000;
        }     
        else
        {
            return 0;
        }
    }


    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.println("Nhap so gio lam them: ");
        soGioLamThem = sc.nextInt();
    }


    @Override
    public double tinhLuong() {
        return super.tinhLuong() + soGioLamThem*50000;
    }


    @Override
    public void xuat() {
        System.out.println("Nhan vien co huu");
        super.xuat();
        System.out.printf("Luong: %.0f", tinhLuong());
        System.out.printf("Khen thuong: %.0f", tinhKhenThuong());
    }
}
