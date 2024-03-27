package CacPhuongThuc;

import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args){
    int a = 10, b = 20;
    int tong = add(200,30);
    System.out.println("tong : " + tong);

    int[] numbers = {1,2,3,4,5};
    float TBC = TBC(numbers);
        System.out.println("gia tri trung binh : " + TBC);
    }


    public static int add(int a,int b){
        int sum = a + b;
        return sum;
    }
    public static float TBC(int[] arr){
        int sum = 0;
        for(int i: arr){
            sum += i;
        }
        return (float) sum/arr.length;
    }

}
