/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi1;
import java.util.Scanner;
/**
 *
 * @author Administrator
 */
public class Bai19 {
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Nhập hai số nguyên dương m, n từ người dùng
        System.out.print("Nhập số nguyên dương m: ");
        int m = scanner.nextInt();

        System.out.print("Nhập số nguyên dương n: ");
        int n = scanner.nextInt();

        // Đóng đối tượng Scanner sau khi đã sử dụng xong
        scanner.close();

        // Xuất hình chữ nhật rỗng kích thước m x n
        printHollowRectangle(m, n);
    }

    // Hàm xuất hình chữ nhật rỗng kích thước m x n
    private static void printHollowRectangle(int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  "); // In khoảng trắng thay vì dấu *
                }
            }
            System.out.println(); // Xuống dòng sau mỗi hàng
        }
    }
}
