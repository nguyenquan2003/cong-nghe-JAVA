package bai11;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("nhập số nguyên dương n : ");
    int n = scanner.nextInt();
    System.out.print("tất cả các ước số của " + n + " : ");
    int dem = 0;
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        dem++;
        System.out.print(i + " ");
      }
    }
    System.out.println();
    System.out.print("số lượng của các ước số : " + dem);

  }
}
