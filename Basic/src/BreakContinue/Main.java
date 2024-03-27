package BreakContinue;

public class Main {
    public static void main(String[] args) {
        /*lệnh break
        int sum = 0, n = 10;
        for(int i = 0; i < n; i++)
        {
            sum += i;
            System.out.println("i = " + i);
            if(i == 5) //kt nếu i = 5 thì thoát khỏi vỏng lặp
            {
                break;
            }
        }
        System.out.println("tổng: " + sum); //tức là sau khi kt dkien thì sẽ tính tổng từ i = 0 đến = 5
         */

        //lệnh continue
        int sum =0 , n =10;
        for(int i = 0; i < n; i++)
        {
            if(i % 2 != 0)
            {
                continue;
            }
            System.out.println("các số chẵn: " +i);
        }
    }
}
