package code;

import java.util.Scanner;

public class LDBienChe extends NguoiLaoDong{
    protected double HSL;
    protected static double LCS = 1490000;

    public LDBienChe(String maSo, String hoTen, int namSinh, double HSL)
    {
        super(maSo, hoTen, namSinh);
        this.HSL = HSL;
    }

    public double getHSL()
    {
        return HSL;
    }
    public void setHSL(double HSL)
    {
        this.HSL = HSL;
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
        System.out.println("Nhap he so luong: ");
        HSL = sc.nextDouble();
    }

    @Override
    public void xuat() {
        System.out.println("[maSo=" + maSo + ", hoTen=" + hoTen + ", namSinh=" + namSinh + "]");
    }

    @Override
    public double tinhLuong() {
        return HSL*LCS;
    }
}