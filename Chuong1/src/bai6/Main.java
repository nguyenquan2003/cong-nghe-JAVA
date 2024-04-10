package bai6;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("nhập tháng: ");
    int thang = scanner.nextInt();

    if (thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 8 || thang == 10 || thang == 12) {
      System.out.println("tháng có 31 ngày");
    } else if (thang == 4 || thang == 6 || thang == 9 || thang == 11) {
      System.out.println("tháng có 30 ngày");
    } else if (thang == 2) {
      System.out.println("nhập năm: ");
      int nam = scanner.nextInt();
      if ((nam % 400 == 0) || ((nam % 4 == 0) && (nam % 100 != 0))) {
        System.out.println("năm nhuần.");
        System.out.println("tháng 2 có 29 ngày.");
      } else {
        System.out.println("năm không nhuần.");
        System.out.println("tháng 2 có 28 ngày.");
      }
    } else {
      System.out.println("tháng không hợp lệ.");
    }
  }
}
