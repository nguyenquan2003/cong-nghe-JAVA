package com.example;

import java.util.*;
import java.io.*;

class KhachHang {
    String maSo;
    String hoTen;
    int namSinh;

    public KhachHang(String maSo, String hoTen, int namSinh) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
    }

    @Override
    public String toString() {
        return "Mã số: " + maSo + ", Họ tên: " + hoTen + ", Năm sinh: " + namSinh;
    }
}

public class QuanLyKhachHang {
    List<KhachHang> danhSachKhachHang = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void themKhachHang() {
        System.out.println("Nhập mã số khách hàng:");
        String maSo = scanner.nextLine();
        System.out.println("Nhập họ tên khách hàng:");
        String hoTen = scanner.nextLine();
        System.out.println("Nhập năm sinh khách hàng:");
        int namSinh = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over
        danhSachKhachHang.add(new KhachHang(maSo, hoTen, namSinh));
    }

    public void hienThiDanhSachKhachHang() {
        for (KhachHang khachHang : danhSachKhachHang) {
            System.out.println(khachHang);
        }
    }

    public void ghiDanhSachKhachHangRaFile(String tenFile) throws IOException {
        PrintWriter writer = new PrintWriter(new File(tenFile));
        for (KhachHang khachHang : danhSachKhachHang) {
            writer.println(khachHang.maSo + "," + khachHang.hoTen + "," + khachHang.namSinh);
        }
        writer.close();
    }

    public void docDanhSachKhachHangTuFile(String tenFile) throws IOException {
        danhSachKhachHang.clear();
        Scanner fileScanner = new Scanner(new File(tenFile));
        while (fileScanner.hasNextLine()) {
            String[] data = fileScanner.nextLine().split(",");
            danhSachKhachHang.add(new KhachHang(data[0], data[1], Integer.parseInt(data[2])));
        }
        fileScanner.close();
    }

    public void nhapDanhSachKhachHang() {
        System.out.println("Nhập số lượng khách hàng:");
        int soLuong = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        for (int i = 0; i < soLuong; i++) {
            themKhachHang();
        }
    }

    public static void main(String[] args) throws IOException {
        QuanLyKhachHang quanLy = new QuanLyKhachHang();
        
        // Nhập danh sách khách hàng
        quanLy.nhapDanhSachKhachHang();
        quanLy.hienThiDanhSachKhachHang();
        
        // Lưu và tải danh sách khách hàng
        quanLy.ghiDanhSachKhachHangRaFile("khachhang.txt");
        quanLy.docDanhSachKhachHangTuFile("khachhang.txt");
        quanLy.hienThiDanhSachKhachHang();
    }
}
