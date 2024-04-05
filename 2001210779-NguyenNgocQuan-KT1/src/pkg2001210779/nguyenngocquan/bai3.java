/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2001210779.nguyenngocquan;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author admin
 */
public class bai3 {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input : ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] known = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            known[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            known[a].add(b);
            known[b].add(a);
        }
        int minRecognitions = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j : known[i]) {
                for (int k : known[j]) {
                    if (known[k].contains(i)) {
                        int totalRecognitions = known[i].size() + known[j].size() + known[k].size() - 6;
                        minRecognitions = Math.min(minRecognitions, totalRecognitions);
                    }
                }
            }
        }
        if (minRecognitions == Integer.MAX_VALUE) {
            System.out.println("Output : " + " -1");
        } else {
            System.out.println("Output : "+minRecognitions);
        }
    }
}