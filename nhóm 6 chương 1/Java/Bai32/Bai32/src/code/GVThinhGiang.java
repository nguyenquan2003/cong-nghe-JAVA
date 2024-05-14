package code;

import java.util.Scanner;

public class GVThinhGiang extends LDNgoaiBienChe{
    private int soTietGD;
    private String trinhDo;

    public GVThinhGiang(String maSo, String hoTen, int namSinh, double mucLuong, int soTietGD, String trinhDo) {
        super(maSo, hoTen, namSinh, mucLuong);
        this.soTietGD = soTietGD;
        this.trinhDo = trinhDo;
    }

    public GVThinhGiang() {
        super("000", "c", 2000, 30000);
        this.soTietGD = 1;
        this.trinhDo = "Dai Hoc";
    }

    public int getSoTietGD() {
        return soTietGD;
    }

    public void setSoTietGD(int soTietGD) {
        this.soTietGD = soTietGD;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        super.nhap();
        System.out.println("Nhap so tiet: ");
        soTietGD = sc.nextInt();
        trinhDo = sc.nextLine();
        System.out.println("Nhap trinh do: ");   
        trinhDo = sc.nextLine();
    }

    @Override
    public double tinhLuong() {
        if(trinhDo.equalsIgnoreCase("dh") || trinhDo.equalsIgnoreCase("dai hoc"))
        {
            return mucLuong*soTietGD*1.0;
        }
        else if(trinhDo.equalsIgnoreCase("ths") || trinhDo.equalsIgnoreCase("thac si"))
        {
            return mucLuong*soTietGD*1.2;
        }
        else if(trinhDo.equalsIgnoreCase("ts") || trinhDo.equalsIgnoreCase("tien si"))
        {
            return mucLuong*soTietGD*1.5;
        }
        else if(trinhDo.equalsIgnoreCase("pgs") || trinhDo.equalsIgnoreCase("pho giao su"))
        {
            return mucLuong*soTietGD*1.8;
        }
        else if(trinhDo.equalsIgnoreCase("gs") || trinhDo.equalsIgnoreCase("giao su"))
        {
            return mucLuong*soTietGD*2.0;
        }
        else{
            return 0;
        }
    }

    @Override
    public void xuat() {
        System.out.println("Giao vien thinh giang");
        super.xuat();
        System.out.printf("Luong: %.0f", tinhLuong());
    }
}
