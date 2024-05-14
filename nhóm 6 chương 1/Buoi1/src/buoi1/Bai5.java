/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buoi1;
import java.util.Scanner;
/**
 *
 * @author Administrator
 */
public class Bai5 {
     public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

        // Nhập vào 3 số nguyên
        System.out.print("Nhập số a thứ nhất: ");
        int a = scanner.nextInt();

        System.out.print("Nhập số b thứ hai: ");
        int b = scanner.nextInt();
        
        System.out.print("Nhập số c thứ hai: ");
        int c = scanner.nextInt();
        
        double delta = b * b - 4 * a * c;
        if(a==0)
        {
        System.out.print("Ngiệm của pt bậc 2 là: "+(-c/b));
        }
        // Biện luận kết quả
        else if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Phương trình có 2 nghiệm phân biệt:");
            System.out.println("Nghiệm 1: " + root1);
            System.out.println("Nghiệm 2: " + root2);
        } else if (delta == 0) {
            double root = -b / (2 * a);
            System.out.println("Phương trình có nghiệm kép:");
            System.out.println("Nghiệm: " + root);
        } else {
            System.out.println("Phương trình không có nghiệm thực.");
        }
     }
}
