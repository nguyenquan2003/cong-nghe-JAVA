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
public class Bai15 {
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        double sum = 0;
        double currentNumber;

        do {
            // Nhập số thực từ người dùng
            System.out.print("Nhập số thực (nhập 0 để kết thúc): ");
            currentNumber = scanner.nextDouble();

            // Cộng dồn vào tổng
            sum += currentNumber;
        } while (currentNumber != 0);

        // Đóng đối tượng Scanner sau khi đã sử dụng xong
        scanner.close();

        // In tổng ra màn hình
        System.out.println("Tổng các số đã nhập là: " + sum);
    }
}
