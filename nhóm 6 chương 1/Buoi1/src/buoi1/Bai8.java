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
public class Bai8 {
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // Nhập điểm từ người dùng
        System.out.print("Nhập điểm (thang điểm 10): ");
        double score = scanner.nextDouble();

        // Đóng đối tượng Scanner sau khi đã sử dụng xong
        scanner.close();

        // Chuyển điểm thành thang điểm chữ
        String grade;
        if (score >= 8.5) {
            grade = "A";
        } else if (score >= 7.0) {
            grade = "B";
        } else if (score >= 5.5) {
            grade = "C";
        } else if (score >= 4.0) {
            grade = "D";
        } else {
            grade = "F";
        }

        // In kết quả ra màn hình
        System.out.println("Điểm " + score + " ứng với thang điểm chữ: " + grade);
    }
}
