import java.util.ArrayList;
import java.util.Scanner;

// Lớp chung cho bất động sản
class BatDongSan {
    protected String maSo;
    protected double chieuDai;
    protected double chieuRong;

    public BatDongSan(String maSo, double chieuDai, double chieuRong) {
        this.maSo = maSo;
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    public double tinhGiaBan() {
        return 0; // Phương thức này sẽ được ghi đè trong các lớp con
    }

    @Override
    public String toString() {
        return "Ma so: " + maSo + ", Chieu dai: " + chieuDai + ", Chieu rong: " + chieuRong + ", Gia ban: " + tinhGiaBan();
    }
}

// Lớp con cho đất trống
class DatTrong extends BatDongSan {
    public DatTrong(String maSo, double chieuDai, double chieuRong) {
        super(maSo, chieuDai, chieuRong);
    }

    @Override
    public double tinhGiaBan() {
        return chieuDai * chieuRong * 10000;
    }
}

// Lớp con cho nhà ở
class NhaO extends BatDongSan {
    private int soLau;

    public NhaO(String maSo, double chieuDai, double chieuRong, int soLau) {
        super(maSo, chieuDai, chieuRong);
        this.soLau = soLau;
    }

    @Override
    public double tinhGiaBan() {
        return chieuDai * chieuRong * 10000 + soLau * 100000;
    }
}

// Lớp con cho khách sạn
class KhachSan extends BatDongSan {
    private int soSao;

    public KhachSan(String maSo, double chieuDai, double chieuRong, int soSao) {
        super(maSo, chieuDai, chieuRong);
        this.soSao = soSao;
    }

    @Override
    public double tinhGiaBan() {
        return 100000 + soSao * 50000;
    }
}

// Lớp con cho biệt thự
class BietThu extends BatDongSan {
    public BietThu(String maSo, double chieuDai, double chieuRong) {
        super(maSo, chieuDai, chieuRong);
    }

    @Override
    public double tinhGiaBan() {
        return chieuDai * chieuRong * 400000;
    }

    public double tinhPhiKinhDoanh() {
        return chieuDai * 1000;
    }
}


public class bds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BatDongSan> danhSachBatDongSan = new ArrayList<>();

        // Nhập thông tin bất động sản
        System.out.print("Nhap so luong dat trong: ");
        int soDatTrong = scanner.nextInt();
        nhapBatDongSan(scanner, danhSachBatDongSan, soDatTrong, "Dat Trong");

        System.out.print("Nhap so luong nha o: ");
        int soNhaO = scanner.nextInt();
        nhapBatDongSan(scanner, danhSachBatDongSan, soNhaO, "Nha O");

        System.out.print("Nhap so luong khach san: ");
        int soKhachSan = scanner.nextInt();
        nhapBatDongSan(scanner, danhSachBatDongSan, soKhachSan, "Khach San");

        System.out.print("Nhap so luong biet thu: ");
        int soBietThu = scanner.nextInt();
        nhapBatDongSan(scanner, danhSachBatDongSan, soBietThu, "Biet Thu");

        // Xuất thông tin bất động sản
        System.out.println("\nThong tin bat dong san:");
        xuatThongTinBatDongSan(danhSachBatDongSan);

        // Tính giá bán của từng loại bất động sản và tổng giá bán
        double tongGiaBan = 0;
        for (BatDongSan batDongSan : danhSachBatDongSan) {
            tongGiaBan += batDongSan.tinhGiaBan();
        }
        System.out.println("\nTong gia ban cua tat ca cac bat dong san: " + tongGiaBan);

        scanner.close();
    }

    // Phương thức nhập thông tin bất động sản
    private static void nhapBatDongSan(Scanner scanner, ArrayList<BatDongSan> danhSachBatDongSan, int soLuong, String loaiBatDongSan) {
        for (int i = 0; i < soLuong; i++) {
            System.out.println("\nNhap thong tin " + loaiBatDongSan + " thu " + (i + 1) + ":");
            System.out.print("Nhap ma so: ");
            scanner.nextLine(); // Tiêu thụ dòng trống
            String maSo = scanner.nextLine();
            System.out.print("Nhap chieu dai: ");
            double chieuDai = scanner.nextDouble();
            System.out.print("Nhap chieu rong: ");
            double chieuRong = scanner.nextDouble();

            if (loaiBatDongSan.equals("Dat Trong")) {
                danhSachBatDongSan.add(new DatTrong(maSo, chieuDai, chieuRong));
            } else if (loaiBatDongSan.equals("Nha O")) {
                System.out.print("Nhap so lau: ");
                int soLau = scanner.nextInt();
                danhSachBatDongSan.add(new NhaO(maSo, chieuDai, chieuRong, soLau));
            } else if (loaiBatDongSan.equals("Khach San")) {
                System.out.print("Nhap so sao: ");
                int soSao = scanner.nextInt();
                danhSachBatDongSan.add(new KhachSan(maSo, chieuDai, chieuRong, soSao));
            } else if (loaiBatDongSan.equals("Biet Thu")) {
                danhSachBatDongSan.add(new BietThu(maSo, chieuDai, chieuRong));
            }
        }
    }

    // Phương thức xuất thông tin bất động sản
    private static void xuatThongTinBatDongSan(ArrayList<BatDongSan> danhSachBatDongSan) {
        for (BatDongSan batDongSan : danhSachBatDongSan) {
            System.out.println(batDongSan);
        }
    }
}
