package NhapDLTuBanPhim;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        /*
        System.out.println("nhập số nguyên a : " );
        int a = scanner.nextInt();
        System.out.println("số nguyên đã nhập : " + a);

        System.out.println("nhập số nguyên b : ");
        int b = scanner.nextInt();
        System.out.println("số nguyên đã nhập : " + b);
         */

//        System.out.println("nhập số thực c : ");
//       float c = scanner.nextFloat();
//        System.out.println("số thực đã nhập : " + c);

        /*
        Sự khác nhau giữa next và nextLine:
        next() sẽ đọc dữ liệu nhập vào cho đến khi gặp khoảng trắng. Nó sẽ không đọc các ký tự sau khoảng trắng.
        nextLine() đọc một dòng đầu vào hoàn chỉnh bao gồm cả dòng đó và kết thúc khi gặp phím Enter (nghĩa là, nó đọc đến ký tự xuống dòng \n).
        */
    System.out.println("nhập tên : ");
    String name = scanner.next();
    System.out.println("tên đã nhập : " + name);

    System.out.println("nhập họ và tên : ");
    String FullName = scanner.nextLine();
    System.out.println("họ và tên đã nhập : " + name);
  }
}