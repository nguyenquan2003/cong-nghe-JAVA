import java.util.Scanner;

class Diem {
    protected int x, y;

    public Diem() {
        // Hàm xây dựng mặc định
    }

    public Diem(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void nhapDiem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap hoanh do: ");
        x = scanner.nextInt();
        System.out.print("Nhap tung do: ");
        y = scanner.nextInt();
    }

    public void hienThi() {
        System.out.println("Toa do: (" + x + ", " + y + ")");
    }

    public void doiDiem(int dx, int dy) {
        x += dx;
        y += dy;
    }
}

class DiemMau extends Diem {
    private String mau;

    public DiemMau() {
        // Hàm xây dựng mặc định
    }

    public DiemMau(int x, int y, String mau) {
        super(x, y);
        this.mau = mau;
    }

    public void ganMau(String mauMoi) {
        mau = mauMoi;
    }

    @Override
    public void hienThi() {
        System.out.println("Toa do: (" + x + ", " + y + "), Mau: " + mau);
    }
}

public class SDDiemMau {
    public static void main(String[] args) {
        // Tạo điểm màu A có tọa độ (5, 10) và màu trắng
        DiemMau A = new DiemMau(5, 10, "Trang");
        System.out.println("Thong tin diem A:");
        A.hienThi();

        // Tạo điểm màu tổng quát B, nhập giá trị từ bàn phím
        DiemMau B = new DiemMau();
        System.out.println("\nNhap thong tin diem B:");
        B.nhapDiem();

        // Dời điểm B đi (10, 8)
        B.doiDiem(10, 8);
        System.out.println("\nToa do diem B sau khi doi:");
        B.hienThi();

        // Gán màu mới cho điểm B là "Vang"
        B.ganMau("Vang");
        System.out.println("\nThong tin diem B sau khi gan mau:");
        B.hienThi();
    }
}