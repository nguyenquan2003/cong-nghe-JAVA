import java.util.Scanner;

class PhanSo {
    private int tuSo;
    private int mauSo;

    // Hàm khởi tạo mặc định
    public PhanSo() {
        this.tuSo = 0;
        this.mauSo = 1; // Gán mẫu số mặc định là 1 để tránh division by zero
    }

    // Hàm khởi tạo gồm 2 tham số
    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        if (mauSo != 0) {
            this.mauSo = mauSo;
        } else {
            System.out.println("Mẫu số không được bằng 0. Mẫu số sẽ được gán mặc định là 1.");
            this.mauSo = 1;
        }
    }

    // Hàm nhập giá trị cho 1 phân số
    public void nhapPhanSo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tử số: ");
        tuSo = scanner.nextInt();

        do {
            System.out.print("Nhập mẫu số (khác 0): ");
            mauSo = scanner.nextInt();
            if (mauSo == 0) {
                System.out.println("Mẫu số không được bằng 0. Nhập lại.");
            }
        } while (mauSo == 0);
    }

    // Hàm hiển thị phân số
    public void hienThiPhanSo() {
        if (tuSo == 0) {
            System.out.println("0");
        } else if (mauSo == 1) {
            System.out.println(tuSo);
        } else {
            System.out.println(tuSo + "/" + mauSo);
        }
    }

    // Hàm nghịch đảo phân số
    public void nghichDao() {
        if (tuSo != 0) {
            int temp = tuSo;
            tuSo = mauSo;
            mauSo = temp;
        } else {
            System.out.println("Không thể nghịch đảo với tử số bằng 0.");
        }
    }

    // Hàm tính ra phân số nghịch đảo của 1 phân số
    public PhanSo giaTriNghichDao() {
        if (tuSo != 0) {
            return new PhanSo(mauSo, tuSo);
        } else {
            System.out.println("Không thể tính giá trị nghịch đảo với tử số bằng 0.");
            return new PhanSo(); // Trả về phân số 0 nếu không thể tính nghịch đảo
        }
    }

    // Hàm tính ra giá trị thực của phân số
    public double giaTriThuc() {
        return (double) tuSo / mauSo;
    }
}

public class bt25 {
    public static void main(String[] args) {
        PhanSo ps1 = new PhanSo(1, 2);
        PhanSo ps2 = new PhanSo(3, 4);

        // Hiển thị phân số
        System.out.print("Phân số 1: ");
        ps1.hienThiPhanSo();

        System.out.print("Phân số 2: ");
        ps2.hienThiPhanSo();

        // Nghịch đảo phân số
        ps1.nghichDao();
        System.out.print("Nghịch đảo phân số 1: ");
        ps1.hienThiPhanSo();

        // Tính giá trị nghịch đảo của phân số
        PhanSo psNghichDao = ps2.giaTriNghichDao();
        System.out.print("Giá trị nghịch đảo của phân số 2: ");
        psNghichDao.hienThiPhanSo();

        // Tính giá trị thực của phân số
        System.out.println("Giá trị thực của phân số 1: " + ps1.giaTriThuc());
        System.out.println("Giá trị thực của phân số 2: " + ps2.giaTriThuc());
    }
}
