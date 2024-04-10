/*
test code trước khi làm vô bài chính :))
package bai9;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("nhập ngày: ");
    int ngay = scanner.nextInt();
    System.out.println("nhập tháng: ");
    int thang = scanner.nextInt();
    System.out.println("nhập năm: ");
    int nam = scanner.nextInt();if (ngay <= 30 || ngay <= 31) {
      System.out.println("ngày hợp lệ");
    } else {
      System.out.println("ngày không hợp lệ");
    }
    if (thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 8 || thang == 10 || thang == 12) {
      System.out.println("tháng có 31 ngày");
    } else if (thang == 4 || thang == 6 || thang == 9 || thang == 11) {
      System.out.println("tháng có 30 ngày");
    }
    if (nam > 0) {
      System.out.println("năm hợp lệ");
    } else {
      System.out.println("năm không hợp lệ");
    }
    if (thang == 2) {
      if ((nam % 400 == 0) || ((nam % 4 == 0) && (nam % 100 != 0))) {
        System.out.println("năm nhuần.");
        System.out.println("tháng 2 có 29 ngày.");
      } else {
        System.out.println("năm không nhuần.");
        System.out.println("tháng 2 có 28 ngày.");
      }
    }
  }
}
*/

package bai9;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("nhập ngày: ");
    int ngay = scanner.nextInt();
    System.out.println("nhập tháng: ");
    int thang = scanner.nextInt();
    System.out.println("nhập năm: ");
    int nam = scanner.nextInt();

    if (nam > 0) { // Kiểm tra năm dương
      if (thang >= 1 && thang <= 12) { // Kiểm tra tháng hợp lệ
        if (ngay >= 1 && ngay <= 31) { // Kiểm tra ngày hợp lệ
          // Kiểm tra số ngày của tháng và năm nhuận
          int soNgayTrongThang;
          if (thang == 2) { // Tháng 2
            if ((nam % 400 == 0) || ((nam % 4 == 0) && (nam % 100 != 0))) {
              soNgayTrongThang = 29;
              System.out.println("năm nhuận.");
            } else {
              soNgayTrongThang = 28;
              System.out.println("năm không nhuận.");
            }
          } else if (thang == 4 || thang == 6 || thang == 9 || thang == 11) {
            soNgayTrongThang = 30;
          } else {
            soNgayTrongThang = 31;
          }

          // Kiểm tra số ngày nhập vào có hợp lệ với số ngày trong tháng không
          if (ngay <= soNgayTrongThang) {
            System.out.println("ngày hợp lệ.");
          } else {
            System.out.println("ngày không hợp lệ.");
          }
        } else {
          System.out.println("ngày không hợp lệ.");
        }
      } else {
        System.out.println("tháng không hợp lệ.");
      }
    } else {
      System.out.println("năm không hợp lệ.");
    }
  }
}