import java.util.Scanner;

public class bt23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số hàng (m <= 50): ");
        int m = scanner.nextInt();
        System.out.print("Nhập số cột (n <= 100): ");
        int n = scanner.nextInt();

        int[][] matrix = new int[m][n];

        // Menu
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Nhập giá trị cho m x n phần tử của mảng từ bàn phím");
            System.out.println("2. Phát sinh giá trị ngẫu nhiên từ -99 đến 99 cho m x n phần tử của mảng");
            System.out.println("3. Xuất giá trị các phần tử ra màn hình");
            System.out.println("4. Tính tổng giá trị các số lẻ");
            System.out.println("5. Tính tổng các giá trị dương trên dòng k cho trước");
            System.out.println("6. Đếm số lượng số dương");
            System.out.println("7. Đếm số lượng số nguyên tố trên một dòng của ma trận");
            System.out.println("8. Kiểm tra ma trận có tồn tại số âm hay không");
            System.out.println("9. Kiểm tra các phần tử trên dòng k cho trước có tăng dần từ trái qua phải hay không");
            System.out.println("10. Liệt kê dòng có chứa số nguyên tố");
            System.out.println("0. Thoát");

            System.out.print("Chọn chức năng (0-10): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                    break;
                case 1:
                    nhapGiaTri(matrix, m, n, scanner);
                    break;
                case 2:
                    phatSinhNgauNhien(matrix, m, n);
                    break;
                case 3:
                    xuatMaTran(matrix, m, n);
                    break;
                case 4:
                    tinhTongSoLe(matrix, m, n);
                    break;
                case 5:
                    System.out.print("Nhập dòng k: ");
                    int k = scanner.nextInt();
                    tinhTongDuongDongK(matrix, m, n, k);
                    break;
                case 6:
                    demSoLuongDuong(matrix, m, n);
                    break;
                case 7:
                    demSoLuongNguyenToTrenDong(matrix, m, n);
                    break;
                case 8:
                    kiemTraTonTaiSoAm(matrix, m, n);
                    break;
                case 9:
                    System.out.print("Nhập dòng k: ");
                    int rowK = scanner.nextInt();
                    kiemTraTangDanDongK(matrix, m, n, rowK);
                    break;
                case 10:
                    lietKeDongChuaNguyenTo(matrix, m, n);
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void nhapGiaTri(int[][] matrix, int m, int n, Scanner scanner) {
        System.out.println("Nhập giá trị cho m x n phần tử của mảng:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Nhập phần tử thứ [" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static void phatSinhNgauNhien(int[][] matrix, int m, int n) {
        System.out.println("Phát sinh giá trị ngẫu nhiên từ -99 đến 99 cho m x n phần tử của mảng:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) (Math.random() * 199) - 99;
            }
        }
        System.out.println("Phát sinh giá trị ngẫu nhiên thành công.");
    }

    private static void xuatMaTran(int[][] matrix, int m, int n) {
        System.out.println("Ma trận hiện tại:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void tinhTongSoLe(int[][] matrix, int m, int n) {
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] % 2 != 0) {
                    sum += matrix[i][j];
                }
            }
        }
        System.out.println("Tổng giá trị các số lẻ trong ma trận: " + sum);
    }

    private static void tinhTongDuongDongK(int[][] matrix, int m, int n, int k) {
        if (k >= 1 && k <= m) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[k - 1][j] > 0) {
                    sum += matrix[k - 1][j];
                }
            }
            System.out.println("Tổng giá trị dương trên dòng " + k + ": " + sum);
        } else {
            System.out.println("Dòng k không hợp lệ.");
        }
    }

    private static void demSoLuongDuong(int[][] matrix, int m, int n) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0) {
                    count++;
                }
            }
        }
        System.out.println("Số lượng số dương trong ma trận: " + count);
    }

    private static void demSoLuongNguyenToTrenDong(int[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (isSoNguyenTo(matrix[i][j])) {
                    count++;
                }
            }
            System.out.println("Dòng " + (i + 1) + ": " + count + " số nguyên tố");
        }
    }

    private static void kiemTraTonTaiSoAm(int[][] matrix, int m, int n) {
        boolean tonTaiSoAm = false;
        outerLoop:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 0) {
                    tonTaiSoAm = true;
                    break outerLoop;
                }
            }
        }
        if (tonTaiSoAm) {
            System.out.println("Ma trận có tồn tại số âm.");
        } else {
            System.out.println("Ma trận không tồn tại số âm.");
        }
    }

    private static void kiemTraTangDanDongK(int[][] matrix, int m, int n, int k) {
        if (k >= 1 && k <= m) {
            boolean tangDan = true;
            for (int j = 1; j < n; j++) {
                if (matrix[k - 1][j] < matrix[k - 1][j - 1]) {
                    tangDan = false;
                    break;
                }
            }
            if (tangDan) {
                System.out.println("Dòng " + k + " tăng dần từ trái qua phải.");
            } else {
                System.out.println("Dòng " + k + " không tăng dần từ trái qua phải.");
            }
        } else {
            System.out.println("Dòng k không hợp lệ.");
        }
    }

    private static void lietKeDongChuaNguyenTo(int[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            boolean chuaNguyenTo = false;
            for (int j = 0; j < n; j++) {
                if (isSoNguyenTo(matrix[i][j])) {
                    chuaNguyenTo = true;
                    break;
                }
            }
            if (chuaNguyenTo) {
                System.out.println("Dòng " + (i + 1) + " chứa số nguyên tố.");
            }
        }
    }

    private static boolean isSoNguyenTo(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
