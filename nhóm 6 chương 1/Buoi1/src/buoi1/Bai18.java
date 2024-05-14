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
public class Bai18 {
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

        // Xuất hình chữ nhật đặc kích thước m x n
        printRectangle(m, n);
    }

    // Hàm xuất hình chữ nhật đặc kích thước m x n
    private static void printRectangle(int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println(); // Xuống dòng sau mỗi hàng
        }
    }
}
