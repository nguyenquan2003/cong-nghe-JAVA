package bai2;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("nhập số nguyên a : ");
        int a = scanner.nextInt();
        System.out.println("nhập số nguyên b : ");
        int b = scanner.nextInt();
        if(a<b){
            System.out.println("số nhỏ nhất : "+a );
            System.out.println("số lớn nhất :"+b);
        }
        else if (a==b) {
            System.out.println("hai số bằng nhau ");
        }
        else {
            System.out.println("số lớn nhất : "+a );
            System.out.println("số nhỏ nhất :"+b);
        }

    }
}
