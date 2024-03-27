package ToanTuKHNhieuDK;

public class Main {

  public static void main(String[] args) {
        /*
        &&: điều kiện đồng thời, kết quả cuối cùng chỉ true khi mọi thứ được kết hợp bởi && cùng true
        ||: điều kiện hoặc, chỉ false khi tất cả các điều kiện kết hợp bởi || đều false
        !: phủ định kết quả đã có, !true = false, !false = true
         */
/*
        for(int i = 0;i < 100; i++){
            if(i % 2 == 0 && i % 5 == 0 && i % 10 == 0){
                System.out.println(i);
            }
        }
*/

    for (int i = 0; i < 100; i++) {
      if (i % 2 == 0 || i % 5 == 0 || i % 10 == 0) {
        System.out.println(i);
      }
    }

    int a = 100;
    if (!(a % 50 == 0)) { //kết quả là flase cho nên ko in ra màn hình
      System.out.println("a chia hết cho 50 : ");
    }
  }
}