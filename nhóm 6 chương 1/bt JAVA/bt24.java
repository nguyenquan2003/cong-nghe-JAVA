import java.util.Scanner;

public class bt24 {
    public static void main(String[] args) {
        Diem2D diemA = new Diem2D();
        diemA.nhapDiem();

        System.out.print("Tọa độ điểm A: ");
        diemA.hienThi();

        System.out.println("Khoảng cách từ điểm A đến gốc tọa độ: " + diemA.khoangCach());

        Diem2D diemB = new Diem2D(3, 4);
        System.out.print("Tọa độ điểm B: ");
        diemB.hienThi();

        System.out.println("Khoảng cách từ điểm A đến điểm B: " + diemA.khoangCach(diemB));
    }
}

class Diem2D {
    private int x, y;

    // Hàm khởi tạo mặc định
    public Diem2D() {
        this.x = 0;
        this.y = 0;
    }

    // Hàm khởi tạo có tham số
    public Diem2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Nhập tọa độ cho điểm từ bàn phím
    public void nhapDiem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập giá trị x: ");
        this.x = scanner.nextInt();
        System.out.print("Nhập giá trị y: ");
        this.y = scanner.nextInt();
    }

    // Hiển thị tọa độ điểm
    public void hienThi() {
        System.out.println("(" + x + "," + y + ")");
    }

    // Dời điểm đi 1 độ dời (dx, dy)
    public void doiDiem(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    // Lấy giá trị hoành độ của điểm
    public int giaTriX() {
        return x;
    }

    // Lấy giá trị tung độ của điểm
    public int giaTriY() {
        return y;
    }

    // Tính khoảng cách từ điểm đến gốc tọa độ
    public float khoangCach() {
        return (float) Math.sqrt(x * x + y * y);
    }

    // Tính khoảng cách từ điểm đến 1 điểm khác
    public float khoangCach(Diem2D d) {
        int deltaX = this.x - d.x;
        int deltaY = this.y - d.y;
        return (float) Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
