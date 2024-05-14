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
public class Bai14 {
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Nhập số nguyên dương n từ người dùng
        System.out.print("Nhập số nguyên dương n: ");
        int n = scanner.nextInt();

        // Đóng đối tượng Scanner sau khi đã sử dụng xong
        scanner.close();

        // Kiểm tra SNT n
        int countDivisors = KTSNT(n);
        if(countDivisors==1)
        {
        System.out.println(n+" Là số nguyên tố" );
        }
        else
            System.out.println(n+" Khong là số nguyên tố" );
    }

    // Hàm đếm số lượng ước số của một số nguyên dương
    private static int KTSNT(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0 ) {
                return 0;
            }
        }
        return 1;
    }
}
