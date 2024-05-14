package code;

import java.util.ArrayList;

public class DSNguoiLaoDong {
    private ArrayList<NguoiLaoDong> dsNLD;

    public DSNguoiLaoDong()
    {
        this.dsNLD = new ArrayList<NguoiLaoDong>();
    }

    public DSNguoiLaoDong(ArrayList<NguoiLaoDong> dsNLD)
    {
        this.dsNLD = dsNLD;
    }

    public void themNguoiLaoDong(NguoiLaoDong nguoiLaoDong) {
        dsNLD.add(nguoiLaoDong);
    }
    public void nhapDanhSach() {
        // Nhập thông tin cho từng người lao động trong danh sách
        for (NguoiLaoDong nguoiLaoDong : dsNLD) {
            nguoiLaoDong.nhap();
        }
    }
    public void xuatDanhSach() {
        // Xuất thông tin của từng người lao động trong danh sách
        for (NguoiLaoDong nguoiLaoDong : dsNLD) {
            nguoiLaoDong.xuat();
        }
    }
    public double tinhTongLuong() {
        double tongLuong = 0.0;
        // Tính tổng lương của tất cả người lao động trong danh sách
        for (NguoiLaoDong nguoiLaoDong : dsNLD) {
            tongLuong += nguoiLaoDong.tinhLuong();
        }
        return tongLuong;
    
    }
}
