package bai13;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("nhập số nguyên dương n : ");
    int n = scanner.nextInt();
    if (n < 2) {
      System.out.print("số " + n + " không phải là số nguyên tố");
//      return 0;
    }
    int dem = 0;
    for (int i = 2; i < Math.sqrt(n); i++) {
      if (n % i == 0) {
        dem++;
      }
    }
    if (dem == 0) {
      System.out.print("n là số nguyên tố " + n);
    } else {
      System.out.print("n là số nguyên tố " + n);
    }
  }
}