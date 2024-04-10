package bai3;

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

    int min = Math.min(Math.min(a, b), c);
    int max = Math.max(Math.max(a, b), c);
    System.out.println("số nhỏ nhất : " + min);
    System.out.println("số lớn nhất : " + max);
  }
}
