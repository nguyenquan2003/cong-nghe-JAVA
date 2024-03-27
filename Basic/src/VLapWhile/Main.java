package VLapWhile;

public class Main {
    public static void main(String[] args) {
        int n = 10, i = 1;
        float sum = 0;
        while(i <= n)
        {
            sum += (float) 1 / i;
            i++;
        }
        System.out.println("tổng: "+ sum);
    }
}
