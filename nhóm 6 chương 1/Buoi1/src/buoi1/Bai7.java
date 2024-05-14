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
public class Bai7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // Nhập tháng từ người dùng
        System.out.print("Nhập tháng (1-12): ");
        int month = sc.nextInt();

        // Kiểm tra xem tháng có hợp lệ không
        if (month < 1 || month > 12) {
            System.out.println("Tháng không hợp lệ.");
            return;
        }

        // Kiểm tra tháng 2 để xác định số ngày (yêu cầu nhập thêm năm)
        int daysInMonth;
        if (month == 2) {
            System.out.print("Nhập năm: ");
            int year = sc.nextInt();

            // Kiểm tra xem năm có là năm nhuần hay không
            boolean isLeapYear = (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));

            // Xác định số ngày trong tháng 2
            daysInMonth = isLeapYear ? 29 : 28;
        } else {
            // Xác định số ngày trong các tháng còn lại
            switch (month) {
                case 1:
                    daysInMonth = 31;
                    break;
                case 3:
                    daysInMonth = 31;
                    break;
                case 5:
                    daysInMonth = 31;
                    break;
                case 7:
                    daysInMonth = 31;
                    break;
                case 8:
                    daysInMonth = 31;
                    break;
                case 10:
                    daysInMonth = 31;
                    break;
                case 12:
                    daysInMonth = 31;
                    break;    
                case 4:
                    daysInMonth = 30;
                    break;
                case 6:
                    daysInMonth = 30;
                    break;
                case 9:
                    daysInMonth = 30;
                    break;
                case 11:
                    daysInMonth = 30;
                    break;
                default:
                    daysInMonth = -1; // Đoạn mã này sẽ không bao giờ được thực hiện
            }
        }

        // In kết quả ra màn hình
        if (daysInMonth != -1) {
            System.out.println("Tháng " + month + " có " + daysInMonth + " ngày.");
        } else {
            System.out.println("Có lỗi xảy ra khi xác định số ngày trong tháng.");
        }

        // Đóng đối tượng Scanner sau khi đã sử dụng xong
        sc.close();
    }
}
