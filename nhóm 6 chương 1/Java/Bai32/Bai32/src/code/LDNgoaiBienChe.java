package code;

import java.util.Scanner;

public class LDNgoaiBienChe extends NguoiLaoDong{
    protected double mucLuong;

    public LDNgoaiBienChe(String maSo, String hoTen, int namSinh, double mucLuong)
    {
        super(maSo, hoTen, namSinh);
        this.mucLuong = mucLuong;
    }

    public double getMucLuong()
    {
        return mucLuong;
    }
    public void setMucLuong(double mucLuong)
    {
        this.mucLuong = mucLuong;
    }

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma so: ");
        maSo = sc.nextLine();
        System.out.println("Nhap ho va ten: ");
        hoTen = sc.nextLine();
        System.out.println("Nhap nam sinh: ");
        namSinh = sc.nextInt();
        System.out.println("Nhap mucLuong: ");
        mucLuong = sc.nextDouble();
    }

    @Override
    public void xuat() {
        System.out.println("[maSo=" + maSo + ", hoTen=" + hoTen + ", namSinh=" + namSinh + "]");
    }

    @Override
    public double tinhLuong() {
        return mucLuong;
    }
}
