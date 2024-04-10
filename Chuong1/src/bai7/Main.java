package bai7;

import com.sun.security.jgss.GSSUtil;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("nhập điểm : ");
    float diem = scanner.nextFloat();
    /*Khi sử dụng toán tử |, nếu một trong hai điều kiện là đúng, thì kết quả sẽ là đúng.
    Trong trường hợp của chúng ta, nếu sử dụng toán tử |, thì điều kiện sẽ luôn đúng nếu
    điểm nhập vào lớn hơn hoặc bằng 8.4 hoặc lớn hơn hoặc bằng 7.0. Điều này sẽ không chính xác
    với yêu cầu ban đầu của bài toán, vì 7.0 phải đạt được để có điểm B, và điểm không thể đồng thời là B và A cùng một lúc.
    Do đó, trong trường hợp này, ta cần sử dụng toán tử && để đảm bảo rằng điểm nhập vào nằm trong khoảng giữa hai giá trị được chỉ định.*/
    if (diem <= 10 && diem >= 8.5) {
      System.out.println("điểm A");
    } else if (diem <= 8.4 && diem >= 7.0) {
      System.out.println("điểm B");
    } else if (diem <= 6.9 && diem >= 5.5) {
      System.out.println("điểm C");
    } else if (diem <= 5.4 && diem >= 4.0) {
      System.out.println("điểm D");
    } else if (diem < 4 && diem >= 0) {
      System.out.println("điểm F");
    } else {
      System.out.println("điểm không hợp lệ");
    }
  }
}
