package VLapLongNhau;

public class Main {
    public static void main(String[] args) {
        /* vòng lặp tạo ra ma trận
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3;j++)
            {
                System.out.print(j + " ");
            }
            System.out.println("");
        }
         */

        //vòng lặp in ra hình vuông
        int n = 6,m =6;
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n;j++)
            {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1)
                {
                    System.out.print(" * ");
                }
                else
                {
                    System.out.print("   ");
                }
            }
            System.out.println("");
        }
    }
}
