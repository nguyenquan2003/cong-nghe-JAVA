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
public class Bai12 {
     public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Nhập số nguyên dương n từ người dùng
        System.out.print("Nhập số nguyên dương n: ");
        int n = scanner.nextInt();

        // Đóng đối tượng Scanner sau khi đã sử dụng xong
        scanner.close();

        // Kiểm tra và in số lượng ước số của n
        int countDivisors = countDivisors(n);
        System.out.println("Số lượng ước số của " + n + " là: " + countDivisors);
    }

    // Hàm đếm số lượng ước số của một số nguyên dương
    private static int countDivisors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count;
    }
}
