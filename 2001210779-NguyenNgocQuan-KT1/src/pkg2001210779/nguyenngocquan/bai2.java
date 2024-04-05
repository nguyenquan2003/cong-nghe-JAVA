/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2001210779.nguyenngocquan;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author admin
 */
public class bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input : ");
        int n = scanner.nextInt();
        int[] groups = new int[n];
        for (int i = 0; i < n; i++) {
            groups[i] = scanner.nextInt();
        }
        Arrays.sort(groups);
        int taxiCount = 0;
        int trai = 0;
        int phai = n - 1;

        while (trai <= phai) {
            if (groups[trai] + groups[phai] <= 4) {
                trai++;
            }
            phai--;
            taxiCount++;
        }
        System.out.println("Output : "+taxiCount);
    }
}