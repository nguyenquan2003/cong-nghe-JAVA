import java.util.Scanner;

class Diem {
    private double x;
    private double y;

    public Diem() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Diem(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Các phương thức get/set cho thuộc tính x và y
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

class TamGiac {
    private Diem diemA;
    private Diem diemB;
    private Diem diemC;

    public TamGiac() {
        this.diemA = new Diem();
        this.diemB = new Diem();
        this.diemC = new Diem();
    }

    public TamGiac(Diem diemA, Diem diemB, Diem diemC) {
        this.diemA = diemA;
        this.diemB = diemB;
        this.diemC = diemC;
    }

    public TamGiac(TamGiac tamGiac) {
        this.diemA = new Diem(tamGiac.diemA.getX(), tamGiac.diemA.getY());
        this.diemB = new Diem(tamGiac.diemB.getX(), tamGiac.diemB.getY());
        this.diemC = new Diem(tamGiac.diemC.getX(), tamGiac.diemC.getY());
    }

    // Các phương thức get/set cho các điểm A, B, C
    public Diem getDiemA() {
        return diemA;
    }

    public void setDiemA(Diem diemA) {
        this.diemA = diemA;
    }

    public Diem getDiemB() {
        return diemB;
    }

    public void setDiemB(Diem diemB) {
        this.diemB = diemB;
    }

    public Diem getDiemC() {
        return diemC;
    }

    public void setDiemC(Diem diemC) {
        this.diemC = diemC;
    }

    // Phương thức nhập tam giác từ bàn phím
    public void nhapTamGiac() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập tọa độ điểm A:");
        double xA = scanner.nextDouble();
        double yA = scanner.nextDouble();
        diemA.setX(xA);
        diemA.setY(yA);

        System.out.println("Nhập tọa độ điểm B:");
        double xB = scanner.nextDouble();
        double yB = scanner.nextDouble();
        diemB.setX(xB);
        diemB.setY(yB);

        System.out.println("Nhập tọa độ điểm C:");
        double xC = scanner.nextDouble();
        double yC = scanner.nextDouble();
        diemC.setX(xC);
        diemC.setY(yC);
    }

    // Phương thức xuất thông tin tam giác
    public void xuatTamGiac() {
        System.out.println("Điểm A: (" + diemA.getX() + ", " + diemA.getY() + ")");
        System.out.println("Điểm B: (" + diemB.getX() + ", " + diemB.getY() + ")");
        System.out.println("Điểm C: (" + diemC.getX() + ", " + diemC.getY() + ")");
    }

    // Phương thức tính diện tích tam giác
    public double tinhDienTich() {
        // Sử dụng công thức diện tích tam giác Heron
        double a = Math.sqrt(Math.pow(diemB.getX() - diemA.getX(), 2) + Math.pow(diemB.getY() - diemA.getY(), 2));
        double b = Math.sqrt(Math.pow(diemC.getX() - diemB.getX(), 2) + Math.pow(diemC.getY() - diemB.getY(), 2));
        double c = Math.sqrt(Math.pow(diemA.getX() - diemC.getX(), 2) + Math.pow(diemA.getY() - diemC.getY(), 2));

        double p = (a + b + c) / 2; // Nửa chu vi tam giác
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    // Phương thức tính chu vi tam giác
    public double tinhChuVi() {
        double a = Math.sqrt(Math.pow(diemB.getX() - diemA.getX(), 2) + Math.pow(diemB.getY() - diemA.getY(), 2));
        double b = Math.sqrt(Math.pow(diemC.getX() - diemB.getX(), 2) + Math.pow(diemC.getY() - diemB.getY(), 2));
        double c = Math.sqrt(Math.pow(diemA.getX() - diemC.getX(), 2) + Math.pow(diemA.getY() - diemC.getY(), 2));

        return a + b + c;
    }
}

public class bt26 {
    public static void main(String[] args) {
        TamGiac tamGiac1 = new TamGiac();
        tamGiac1.nhapTamGiac();
        tamGiac1.xuatTamGiac();

        TamGiac tamGiac2 = new TamGiac(new Diem(1.0, 2.0), new Diem(3.0, 4.0), new Diem(5.0, 6.0));
        tamGiac2.xuatTamGiac();

        System.out.println("Diện tích tam giác 1: " + tamGiac1.tinhDienTich());
        System.out.println("Chu vi tam giác 1: " + tamGiac1.tinhChuVi());

        System.out.println("Diện tích tam giác 2: " + tamGiac2.tinhDienTich());
        System.out.println("Chu vi tam giác 2: " + tamGiac2.tinhChuVi());
    }
}
