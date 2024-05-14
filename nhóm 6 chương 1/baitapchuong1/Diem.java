import java.util.Scanner;

class Diem {
    public int x;
    public int y;

    public Diem(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void hienThi() {
        System.out.println("Toa do diem: (" + x + ", " + y + ")");
    }

    public void doiDiem(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }
}

class DiemMau extends Diem {
    private String mau;

    public DiemMau(int x, int y, String mau) {
        super(x, y);
        this.mau = mau;
    }

    public void ganMau(String mauMoi) {
        mau = mauMoi;
    }

    public void hienThi() {
        System.out.println("Toa do diem: (" + x + ", " + y + "), Mau: " + mau);
    }
}

