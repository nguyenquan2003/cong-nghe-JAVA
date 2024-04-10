package bai5;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("nhập số năm : ");
    int nam = scanner.nextInt();
    if ((nam % 400 == 0) || ((nam % 4 == 0))) {
      System.out.println("năm nhuần ");
    } else {
      System.out.println("năm không nhuần");
    }
  }
}