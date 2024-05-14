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
public class Bai6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a;
        System.out.println("Nhập năm:");
        a=sc.nextInt();
        if(a%4==0&&a%100!=0||a%400==0&&a%100!=0)
        {
            System.out.println(a+" Là năm nhuần");
        }
        else
        {
            System.out.println(a+" Là năm không nhuần");
        }
    }
}
