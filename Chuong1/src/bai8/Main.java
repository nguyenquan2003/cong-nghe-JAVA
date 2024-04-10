package bai8;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhập số điện (kWh): ");
    float soDien = scanner.nextFloat();
    float tienDien;
    int bac1 = 1480, bac2 = 1533, bac3 = 1786, bac4 = 2242, bac5 = 2503;
    if (soDien < 0) {
      System.out.println("Vui lòng nhập số điện không được nhỏ hơn 0!");
    } else if (soDien <= 50) {
      tienDien = soDien * bac1;
      System.out.println("bạn đã dùng điện trong khoảng 0-50 kWh, số tiền bạn phải trả là: " + tienDien);
    } else if (soDien <= 100) {
      tienDien = 50 * bac1 + ((soDien - 50) * bac2);
      System.out.println("bạn đã dùng điện trong khoảng 51-100 kWh, số tiền bạn phải trả là: " + tienDien);
    } else if (soDien <= 200) {
      tienDien = 50 * bac1 + 50 * bac2 + ((soDien - 100) * bac3);
      System.out.println("bạn đã dùng điện trong khoảng 101-200 kWh, số tiền bạn phải trả là: " + tienDien);
    } else if (soDien <= 300) {
      tienDien = 50 * bac1 + 50 * bac2 + 100 * bac3 + ((soDien - 200) * bac4);
      System.out.println("bạn đã dùng điện trong khoảng 201-300 kWh, số tiền bạn phải trả là: " + tienDien);
    } else {
      tienDien = 50 * bac1 + 50 * bac2 + 100 * bac3 + 100 * bac4 + ((soDien - 300) * bac5);
      System.out.println("bạn đã dùng điện trên 301 kWh, số tiền bạn phải trả là: " + tienDien);
    }
  }
}
