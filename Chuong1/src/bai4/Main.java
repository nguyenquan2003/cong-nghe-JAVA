package bai4;

import static java.lang.Math.sqrt;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("nhập số nguyên a : ");
    int a = scanner.nextInt();
    System.out.println("nhập số nguyên b : ");
    int b = scanner.nextInt();
    System.out.println("nhập số nguyên c: ");
    int c = scanner.nextInt();

    double delta = (b * b) - 4 * (a * c);
    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
    if (delta > 0) {
      System.out.println("phương trình có 2 nghiệm phân biệt ");
      System.out.println("x1 : " + x1);
      System.out.println("x2 : " + x2);
    } else if (delta == 0) {
      double x = -b / (2 * a);
      System.out.println("phương trình có một nghiệm ");
      System.out.println("x : " + x);
    } else {
      System.out.println("phương trình không có nghiệm thực ");
    }
  }
}
