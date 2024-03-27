package VLapDoWhile;

public class Main {
    public static void main(String[] args) {
        int n = 20, i = 1;
        float sum = 0;
        do {
            sum += 1.0f / i;
            i++;
        } while(i <= n);
        System.out.println("tổng: " + sum);
    }
}
