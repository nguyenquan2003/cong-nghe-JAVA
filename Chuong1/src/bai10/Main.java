package bai10;

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

    if (nam > 0 && thang >= 1 && thang <= 12) {
      int soNgayTrongThang;
      switch (thang) {
        case 2:
          if ((nam % 400 == 0) || ((nam % 4 == 0) && (nam % 100 != 0))) {
            soNgayTrongThang = 29;
            System.out.println("năm nhuận.");
          } else {
            soNgayTrongThang = 28;
            System.out.println("năm không nhuận.");
          }
          break;
        case 4:
        case 6:
        case 9:
        case 11:
          soNgayTrongThang = 30;
          break;
        default:
          soNgayTrongThang = 31;
          break;
      }

      if (ngay >= 1 && ngay <= soNgayTrongThang) {
        // Xử lý ngày kế tiếp
        int ngayKeTiep = ngay + 1;
        int thangKeTiep = thang;
        int namKeTiep = nam;

        if (ngayKeTiep > soNgayTrongThang) {
          ngayKeTiep = 1;
          thangKeTiep++;
          if (thangKeTiep > 12) {
            thangKeTiep = 1;
            namKeTiep++;
          }
        }

        // Xử lý ngày trước đó
        int ngayTruocDo = ngay - 1;
        int thangTruocDo = thang;
        int namTruocDo = nam;

        if (ngayTruocDo < 1) {
          thangTruocDo--;
          if (thangTruocDo < 1) {
            thangTruocDo = 12;
            namTruocDo--;
          }
          switch (thangTruocDo) {
            case 2:
              if ((namTruocDo % 400 == 0) || ((namTruocDo % 4 == 0) && (namTruocDo % 100 != 0))) {
                ngayTruocDo = 29;
              } else {
                ngayTruocDo = 28;
              }
              break;
            case 4:
            case 6:
            case 9:
            case 11:
              ngayTruocDo = 30;
              break;
            default:
              ngayTruocDo = 31;
              break;
          }
        }

        System.out.println("ngày sau đó: " + ngayKeTiep + "/" + thangKeTiep + "/" + namKeTiep);
        System.out.println("ngày trước đó: " + ngayTruocDo + "/" + thangTruocDo + "/" + namTruocDo);
      } else {
        System.out.println("ngày không hợp lệ.");
      }
    } else {
      System.out.println("ngày, tháng hoặc năm không hợp lệ.");
    }
  }
}
