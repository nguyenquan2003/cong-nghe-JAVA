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
public class Bai17 {
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Nhập số nguyên dương n từ người dùng
        System.out.print("Nhập số nguyên dương n: ");
        int n = scanner.nextInt();

        // Đóng đối tượng Scanner sau khi đã sử dụng xong
        scanner.close();

        // Kiểm tra và in số lượng chữ số lẻ của n
        int countOddDigits = countOddDigits(n);
        System.out.println("Số lượng chữ số lẻ của " + n + " là: " + countOddDigits);
    }

    
    private static int countOddDigits(int number) {
        int sum = 0;
        while (number > 0) {
            int digit = number % 10; // Lấy chữ số cuối cùng
            if (digit % 2 == 0) {
                sum=sum+digit;
            }
            number /= 10; // Loại bỏ chữ số cuối cùng
        }
        return sum;
    }
}
