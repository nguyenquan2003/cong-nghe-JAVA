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
public class Bai9 {
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Nhập chỉ số điện cũ và mới từ người dùng
        System.out.print("Nhập chỉ số điện cũ: ");
        int oldReading = scanner.nextInt();

        System.out.print("Nhập chỉ số điện mới: ");
        int newReading = scanner.nextInt();

        // Đóng đối tượng Scanner sau khi đã sử dụng xong
        scanner.close();

        // Kiểm tra nếu chỉ số điện cũ lớn hơn chỉ số điện mới
        if (oldReading > newReading) {
            System.out.println("Dữ liệu nhập không hợp lệ. Chỉ số điện mới phải lớn hơn hoặc bằng chỉ số điện cũ.");
            return;
        }

        // Tính số kWh tiêu thụ
        int consumption = newReading - oldReading;

        // Tính tiền điện theo quy định
        double totalCost;
        if (consumption <= 50) {
            totalCost = consumption * 1480;
        } else if (consumption <= 100) {
            totalCost = 50 * 1480 + (consumption - 50) * 1533;
        } else if (consumption <= 200) {
            totalCost = 50 * 1480 + 50 * 1533 + (consumption - 100) * 1786;
        } else if (consumption <= 300) {
            totalCost = 50 * 1480 + 50 * 1533 + 100 * 1786 + (consumption - 200) * 2242;
        } else {
            totalCost = 50 * 1480 + 50 * 1533 + 100 * 1786 + 100 * 2242 + (consumption - 300) * 2503;
        }

        // In kết quả ra màn hình
        System.out.println("Số kWh tiêu thụ: " + consumption);
        System.out.println("Tổng tiền điện phải trả: " + totalCost + " VNĐ");
    }
}
