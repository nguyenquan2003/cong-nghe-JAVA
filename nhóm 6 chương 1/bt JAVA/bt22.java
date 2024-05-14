import java.util.Scanner;

public class bt22 {
    public static void main(String[] args) {
        Scanner inputData = new Scanner(System.in);
        int[] arr = new int[500];
        int n = 0;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Nhập giá trị cho n phần tử mảng từ bàn phím");
            System.out.println("2. Phát sinh giá trị ngẫu nhiên từ -199 đến 199 cho n phần tử mảng");
            System.out.println("3. Xuất mảng ra màn hình");
            System.out.println("4. Liệt kê các giá trị âm có trong mảng");
            System.out.println("5. Liệt kê các số nguyên tố có trong mảng");
            System.out.println("6. Liệt kê các phần tử có giá trị nằm trong đoạn [a, b]");
            System.out.println("7. Tính tổng giá trị các phần tử là số nguyên tố");
            System.out.println("8. Tính trung bình cộng của các phần tử dương có trong mảng");
            System.out.println("9. Đếm số phần tử có giá trị lớn hơn x");
            System.out.println("10. Đếm số phần tử có giá trị là số nguyên tố trong mảng");
            System.out.println("11. Kiểm tra mảng có phải là mảng chứa toàn số nguyên tố");
            System.out.println("12. Kiểm tra mảng có phải là mảng tăng dần");
            System.out.println("13. Tìm giá trị lớn nhất trong mảng");
            System.out.println("14. Tìm giá trị nhỏ nhất trong mảng");
            System.out.println("15. Tìm số âm lớn nhất trong mảng");
            System.out.println("16. Đảo ngược mảng");
            System.out.println("0. Thoát");

            System.out.print("Chọn chức năng (0-16): ");
            int choice = inputData.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("Nhập số lượng phần tử n (n <= 500): ");
                    n = inputData.nextInt();
                    nhapMang(arr, n, inputData);
                    break;
                case 2:
                    System.out.print("Nhập số lượng phần tử n (n <= 500): ");
                    n = inputData.nextInt();
                    phatSinhNgauNhien(arr, n);
                    break;
                case 3:
                    xuatMang(arr, n);
                    break;
                case 4:
                    lietKeAm(arr, n);
                    break;
                case 5:
                    lietKeSoNguyenTo(arr, n);
                    break;
                case 6:
                    System.out.print("Nhập giá trị a: ");
                    int a = inputData.nextInt();
                    System.out.print("Nhập giá trị b: ");
                    int b = inputData.nextInt();
                    lietKeTrongDoan(arr, n, a, b);
                    break;
                case 7:
                    tinhTongSoNguyenTo(arr, n);
                    break;
                case 8:
                    tinhTrungBinhCongDuong(arr, n);
                    break;
                case 9:
                    System.out.print("Nhập giá trị x: ");
                    int x = inputData.nextInt();
                    demSoLonHonX(arr, n, x);
                    break;
                case 10:
                    demSoNguyenTo(arr, n);
                    break;
                case 11:
                    kiemTraMangNguyenTo(arr, n);
                    break;
                case 12:
                    kiemTraMangTangDan(arr, n);
                    break;
                case 13:
                    timGiaTriLonNhat(arr, n);
                    break;
                case 14:
                    timGiaTriNhoNhat(arr, n);
                    break;
                case 15:
                    timSoAmLonNhat(arr, n);
                    break;
                case 16:
                    daoNguocMang(arr, n);
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void nhapMang(int[] arr, int n, Scanner inputData) {
        System.out.println("Nhập giá trị cho các phần tử mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = inputData.nextInt();
        }
    }

    private static void phatSinhNgauNhien(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 399) - 199;
        }
        System.out.println("Phát sinh giá trị ngẫu nhiên thành công.");
    }

    private static void xuatMang(int[] arr, int n) {
        System.out.println("Mảng hiện tại:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void lietKeAm(int[] arr, int n) {
        System.out.println("Các giá trị âm trong mảng:");
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    private static void lietKeSoNguyenTo(int[] arr, int n) {
        System.out.println("Các số nguyên tố trong mảng:");
        for (int i = 0; i < n; i++) {
            if (isSoNguyenTo(arr[i])) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    private static void lietKeTrongDoan(int[] arr, int n, int a, int b) {
        System.out.println("Các phần tử có giá trị nằm trong đoạn [" + a + ", " + b + "]:");
        for (int i = 0; i < n; i++) {
            if (arr[i] >= a && arr[i] <= b) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    private static void tinhTongSoNguyenTo(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (isSoNguyenTo(arr[i])) {
                sum += arr[i];
            }
        }
        System.out.println("Tổng các số nguyên tố trong mảng: " + sum);
    }

    private static void tinhTrungBinhCongDuong(int[] arr, int n) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                sum += arr[i];
                count++;
            }
        }
        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("Trung bình cộng các phần tử dương trong mảng: " + average);
        } else {
            System.out.println("Không có phần tử dương trong mảng.");
        }
    }

    private static void demSoLonHonX(int[] arr, int n, int x) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > x) {
                count++;
            }
        }
        System.out.println("Số phần tử có giá trị lớn hơn " + x + ": " + count);
    }

    private static void demSoNguyenTo(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isSoNguyenTo(arr[i])) {
                count++;
            }
        }
        System.out.println("Số phần tử là số nguyên tố trong mảng: " + count);
    }

    private static void kiemTraMangNguyenTo(int[] arr, int n) {
        boolean isAllPrime = true;
        for (int i = 0; i < n; i++) {
            if (!isSoNguyenTo(arr[i])) {
                isAllPrime = false;
                break;
            }
        }
        if (isAllPrime) {
            System.out.println("Mảng chứa toàn số nguyên tố.");
        } else {
            System.out.println("Mảng không chứa toàn số nguyên tố.");
        }
    }

    private static void kiemTraMangTangDan(int[] arr, int n) {
        boolean isIncreasing = true;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                isIncreasing = false;
                break;
            }
        }
        if (isIncreasing) {
            System.out.println("Mảng là mảng tăng dần.");
        } else {
            System.out.println("Mảng không là mảng tăng dần.");
        }
    }

    private static void timGiaTriLonNhat(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Giá trị lớn nhất trong mảng: " + max);
    }

    private static void timGiaTriNhoNhat(int[] arr, int n) {
        int min = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Giá trị nhỏ nhất trong mảng: " + min);
    }

    private static void timSoAmLonNhat(int[] arr, int n) {
        int maxNegative = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0 && arr[i] > maxNegative) {
                maxNegative = arr[i];
            }
        }
        if (maxNegative != Integer.MIN_VALUE) {
            System.out.println("Số âm lớn nhất trong mảng: " + maxNegative);
        } else {
            System.out.println("Không có số âm trong mảng.");
        }
    }

    private static void daoNguocMang(int[] arr, int n) {
        System.out.println("Mảng sau khi đảo ngược:");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
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
