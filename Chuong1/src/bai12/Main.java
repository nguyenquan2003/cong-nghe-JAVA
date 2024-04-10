package bai12;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("nhập số nguyên dương n : ");
    int n = scanner.nextInt();
    System.out.print("tất cả các ước số lẻ của " + n + " : ");
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        if (i % 2 != 0) {
          System.out.print(i + " ");
        }
      }
    }
  }
}