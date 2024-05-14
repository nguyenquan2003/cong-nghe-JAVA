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
public class Bai4 {


    public static void main(String[] args) {
        // Tạo một đối tượng Scanner để nhập dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Nhập vào 3 số nguyên
        System.out.print("Nhập số thứ nhất: ");
        int num1 = scanner.nextInt();

        System.out.print("Nhập số thứ hai: ");
        int num2 = scanner.nextInt();

        System.out.print("Nhập số thứ ba: ");
        int num3 = scanner.nextInt();

        // Đóng đối tượng Scanner sau khi đã sử dụng xong
        scanner.close();

        // Tìm số nhỏ nhất và số lớn nhất
        int min = Math.min(Math.min(num1, num2), num3);
        int max = Math.max(Math.max(num1, num2), num3);

        // In kết quả ra màn hình
        System.out.println("Số nhỏ nhất là: " + min);
        System.out.println("Số lớn nhất là: " + max);
    }


}
