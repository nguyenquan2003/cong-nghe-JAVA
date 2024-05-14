package com.example;


import java.io.*;
import java.util.*;

class DanhBa implements Serializable {
    String ten;
    String soPhone;

    public DanhBa(String ten, String soPhone) {
        this.ten = ten;
        this.soPhone = soPhone;
    }

    @Override
    public String toString() {
        return "Tên: " + ten + ", Số điện thoại: " + soPhone;
    }
}

public class QuanLyDanhBa {
    List<DanhBa> danhSachDanhBa = new ArrayList<>();

    public void nhapDanhBaTuBanPhim() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng danh bạ:");
        int soLuong = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập tên:");
            String ten = sc.nextLine();
            System.out.println("Nhập số điện thoại:");
            String soPhone = sc.nextLine();
            danhSachDanhBa.add(new DanhBa(ten, soPhone));
        }
    }

    public void xuatDanhBaRaManHinh() {
        for (DanhBa danhBa : danhSachDanhBa) {
            System.out.println(danhBa);
        }
    }

    public void ghiDanhBaVaoFile() {
        try {
            FileOutputStream fos = new FileOutputStream("danhba.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(danhSachDanhBa);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void docDanhBaTuFile() {
        try {
            FileInputStream fis = new FileInputStream("danhba.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            danhSachDanhBa = (List<DanhBa>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }

    public static void main(String[] args) {
        QuanLyDanhBa quanLyDanhBa = new QuanLyDanhBa();

        // Nhập danh bạ từ bàn phím
        quanLyDanhBa.nhapDanhBaTuBanPhim();

        // Xuất danh bạ ra màn hình
        quanLyDanhBa.xuatDanhBaRaManHinh();

        // Ghi danh bạ vào file
        quanLyDanhBa.ghiDanhBaVaoFile();

        // Đọc danh bạ từ file
        quanLyDanhBa.docDanhBaTuFile();

        // Xuất danh bạ ra màn hình sau khi đọc từ file
        quanLyDanhBa.xuatDanhBaRaManHinh();
    }
}
