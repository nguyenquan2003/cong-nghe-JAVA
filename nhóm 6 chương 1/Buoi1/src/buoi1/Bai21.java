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
public class Bai21 {
     public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Nhập số nguyên dương h từ người dùng
        System.out.print("Nhập chiều cao h: ");
        int h = scanner.nextInt();

        // Đóng đối tượng Scanner sau khi đã sử dụng xong
        scanner.close();

        // Xuất tam giác cân rỗng chiều cao h
        printHollowIsoscelesTriangle(h);
    }

    // Hàm xuất tam giác cân rỗng chiều cao h
    private static void printHollowIsoscelesTriangle(int h) {
        for (int i = 1; i <= h; i++) {
            // In khoảng trắng phía trước mỗi dòng để tạo ra tam giác cân
            for (int j = 1; j <= h - i; j++) {
                System.out.print("  ");
            }

            // In dấu '*' hoặc khoảng trắng tương ứng với chiều cao của dòng hiện tại
            for (int k = 1; k <= 2 * i - 1; k++) {
                if (k == 1 || k == 2 * i - 1 || i == h) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }

            // Xuống dòng sau mỗi dòng
            System.out.println();
        }
    }
}
