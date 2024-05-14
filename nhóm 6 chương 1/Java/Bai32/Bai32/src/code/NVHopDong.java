package code;

import java.util.Scanner;

public class NVHopDong extends LDNgoaiBienChe implements XetKhenThuong{
    private int ngayCong;

    public NVHopDong(String maSo, String hoTen, int namSinh, double mucLuong, int ngayCong) {
        super(maSo, hoTen, namSinh, mucLuong);
        this.ngayCong = ngayCong;
    }

    public NVHopDong() {
        super("000", "b", 2000, 30000000);
        this.ngayCong = 1;
    }

    public int getNgayCong() {
        return ngayCong;
    }

    public void setNgayCong(int ngayCong) {
        this.ngayCong = ngayCong;
    }

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.println("Nhap so ngay cong: ");
        ngayCong = sc.nextInt();

    }

    @Override
    public double tinhLuong() {
        return super.tinhLuong()*ngayCong;
    }

    @Override
    public double tinhKhenThuong() {
    if(ngayCong > 25)
    {
        return 1500000;
    }
    else 
    {
        return 0;
    }
}
    @Override
    public void xuat() {
        System.out.println("Nhan vien hop dong");
        super.xuat();
        System.out.printf("Luong: %.0f", tinhLuong());
        System.out.println("Khen thuong: " + tinhKhenThuong());
    }

}
