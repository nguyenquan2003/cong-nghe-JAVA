package code;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<NguoiLaoDong> danhSachNguoiLaoDong = new ArrayList<>();
        // Nhập thông tin cho các loại nhân viên
        System.out.print("Nhap so luong nhan vien: ");
        int soLuongNhanVien = sc.nextInt();
        for (int i = 0; i < soLuongNhanVien; i++) {
            System.out.println("Chon loai nhan vien (1: GVCoHuu, 2: NVCoHuu, 3: GVThinhGiang, 4: NVHopDong): ");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear input buffer

            switch (choice) {
                case 1:
                    NguoiLaoDong gvCoHuu = new GVCoHuu();
                    gvCoHuu.nhap();
                    danhSachNguoiLaoDong.add(gvCoHuu);
                    break;
                case 2:
                    NguoiLaoDong nvCoHuu = new NVCoHuu();
                    nvCoHuu.nhap();
                    danhSachNguoiLaoDong.add(nvCoHuu);
                    break;
                case 3:
                    NguoiLaoDong GVThinhGiang = new code.GVThinhGiang();
                    GVThinhGiang.nhap();
                    danhSachNguoiLaoDong.add(GVThinhGiang);
                    break;
                case 4:
                    NguoiLaoDong nvHopDong = new NVHopDong();
                    nvHopDong.nhap();
                    danhSachNguoiLaoDong.add(nvHopDong);
                    break;
                default:
                    System.out.println("Loai nhan vien khong hop le!");
            }
        }
        // Xuất thông tin của tất cả các nhân viên
        System.out.println("\nDanh sach nhan vien:");
        for (NguoiLaoDong nguoiLaoDong : danhSachNguoiLaoDong) {
            System.out.println("-------------------------");
            nguoiLaoDong.xuat();
            System.out.println();
        }
    }
}
