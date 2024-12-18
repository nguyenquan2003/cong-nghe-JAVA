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
public class Bai10 {
     public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Nhập ngày, tháng, năm từ người dùng
        System.out.print("Nhập ngày: ");
        int day = scanner.nextInt();

        System.out.print("Nhập tháng: ");
        int month = scanner.nextInt();

        System.out.print("Nhập năm: ");
        int year = scanner.nextInt();

        // Đóng đối tượng Scanner sau khi đã sử dụng xong
        scanner.close();

        // Kiểm tra năm, tháng, ngày có hợp lệ hay không
        boolean isValidDate = isValidYear(year) && isValidMonth(month) && isValidDay(day, month, year);

        // In kết quả ra màn hình
        if (isValidDate) {
            System.out.println("Hợp lệ.");
        } else {
            System.out.println("Không hợp lệ.");
        }
    }

    // Hàm kiểm tra năm có hợp lệ hay không
    private static boolean isValidYear(int year) {
        return year > 0;
    }

    // Hàm kiểm tra tháng có hợp lệ hay không
    private static boolean isValidMonth(int month) {
        return month >= 1 && month <= 12;
    }

    // Hàm kiểm tra ngày có hợp lệ hay không
    private static boolean isValidDay(int day, int month, int year) {
        if (day >= 1 && day <= getMaxDaysInMonth(month, year)) {
            return true;
        }
        return false;
    }

    // Hàm tính số ngày tối đa của một tháng trong năm
    private static int getMaxDaysInMonth(int month, int year) {
        switch (month) {
            case 1:
                return 31;
            case 3:
                return 31;
            case 5:
                return 31;
            case 7:
                return 31;
            case 8:
                return 31;
            case 10:
                return 31;
            case 12:
               return 31;  
            case 4:
               return 30;
            case 6:
               return 30;
            case 9:
                return 30;
            case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return -1; // Đoạn mã này sẽ không bao giờ được thực hiện
        }
    }

    // Hàm kiểm tra năm nhuần
    private static boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }
}
