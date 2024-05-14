import java.util.ArrayList;

class NhanVien {
    private String hoTen;
    private int namVaoLam;
    private double luongCoBan;

    public NhanVien(String hoTen, int namVaoLam, double luongCoBan) {
        this.hoTen = hoTen;
        this.namVaoLam = namVaoLam;
        this.luongCoBan = luongCoBan;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double tinhLuong() {
        return 0;
    }

    @Override
    public String toString() {
        return "Ho ten: " + hoTen + ", Nam vao lam: " + namVaoLam + ", Luong co ban: " + luongCoBan;
    }
}

class NhanVienVanPhong extends NhanVien {
    private int soNgayLamViec;
    private double troCap;

    public NhanVienVanPhong(String hoTen, int namVaoLam, double luongCoBan, int soNgayLamViec, double troCap) {
        super(hoTen, namVaoLam, luongCoBan);
        this.soNgayLamViec = soNgayLamViec;
        this.troCap = troCap;
    }

    public int getSoNgayLamViec() {
        return soNgayLamViec;
    }

    public void setSoNgayLamViec(int soNgayLamViec) {
        this.soNgayLamViec = soNgayLamViec;
    }

    public double getTroCap() {
        return troCap;
    }

    public void setTroCap(double troCap) {
        this.troCap = troCap;
    }

    @Override
    public double tinhLuong() {
        return getLuongCoBan() + soNgayLamViec * 100000 + troCap;
    }
}

class NhanVienSanXuat extends NhanVien {
    private int soSanPham;

    public NhanVienSanXuat(String hoTen, int namVaoLam, double luongCoBan, int soSanPham) {
        super(hoTen, namVaoLam, luongCoBan);
        this.soSanPham = soSanPham;
    }

    public int getSoSanPham() {
        return soSanPham;
    }

    public void setSoSanPham(int soSanPham) {
        this.soSanPham = soSanPham;
    }

    @Override
    public double tinhLuong() {
        return getLuongCoBan() + soSanPham * 2000;
    }
}

class NhanVienQuanLy extends NhanVien {
    private double heSoChucVu;
    private double thuong;

    public NhanVienQuanLy(String hoTen, int namVaoLam, double luongCoBan, double heSoChucVu, double thuong) {
        super(hoTen, namVaoLam, luongCoBan);
        this.heSoChucVu = heSoChucVu;
        this.thuong = thuong;
    }

    public double getHeSoChucVu() {
        return heSoChucVu;
    }

    public void setHeSoChucVu(double heSoChucVu) {
        this.heSoChucVu = heSoChucVu;
    }

    public double getThuong() {
        return thuong;
    }

    public void setThuong(double thuong) {
        this.thuong = thuong;
    }

    @Override
    public double tinhLuong() {
        return getLuongCoBan() * heSoChucVu + thuong;
    }
}

public class CongTy {
    private ArrayList<NhanVien> danhSachNhanVien;

    public CongTy() {
        danhSachNhanVien = new ArrayList<>();
    }

    public void themNhanVien(NhanVien nv) {
        danhSachNhanVien.add(nv);
    }

    public void xuatThongTinNhanVien() {
        for (NhanVien nv : danhSachNhanVien) {
            System.out.println(nv.toString());
        }
    }

    public double tinhTongLuongCongTy() {
        double tongLuong = 0;
        for (NhanVien nv : danhSachNhanVien) {
            tongLuong += nv.tinhLuong();
        }
        return tongLuong;
    }

    public double tinhTongLuongTheoLoai(Class<? extends NhanVien> loaiNhanVien) {
        double tongLuong = 0;
        for (NhanVien nv : danhSachNhanVien) {
            if (loaiNhanVien.isInstance(nv)) {
                tongLuong += nv.tinhLuong();
            }
        }
        return tongLuong;
    }

    public static void main(String[] args) {
        CongTy congTy = new CongTy();

        NhanVienVanPhong nvVanPhong = new NhanVienVanPhong("Nguyen Van A", 2010, 1500000, 20, 500000);
        NhanVienSanXuat nvSanXuat = new NhanVienSanXuat("Tran Thi B", 2015, 1500000, 100);
        NhanVienQuanLy nvQuanLy = new NhanVienQuanLy("Le Van C", 2018, 1500000, 1.5, 1000000);

        congTy.themNhanVien(nvVanPhong);
        congTy.themNhanVien(nvSanXuat);
        congTy.themNhanVien(nvQuanLy);

        System.out.println("Thong tin nhan vien:");
        congTy.xuatThongTinNhanVien();

        System.out.println("Tong luong cong ty: " + congTy.tinhTongLuongCongTy());
        System.out.println("Tong luong nhan vien van phong: " + congTy.tinhTongLuongTheoLoai(NhanVienVanPhong.class));
        System.out.println("Tong luong nhan vien san xuat: " + congTy.tinhTongLuongTheoLoai(NhanVienSanXuat.class));
        System.out.println("Tong luong nhan vien quan ly: " + congTy.tinhTongLuongTheoLoai(NhanVienQuanLy.class));
    }
}
