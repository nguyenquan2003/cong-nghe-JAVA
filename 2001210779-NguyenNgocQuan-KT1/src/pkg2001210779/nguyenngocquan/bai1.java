/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg2001210779.nguyenngocquan;
import java.util.*;
/**
 *
 * @author admin
 */
public class bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input : ");

        int n = scanner.nextInt();
        scanner.nextLine();

        Set<String> alcohols = new HashSet<>(Arrays.asList("ABSINTH", "BEER", "BRANDY", "CHAMPAGNE", "GIN", "RUM", "SAKE", "TEQUILA", "VODKA", "WHISKEY", "WINE"));
        List<String> customers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            customers.add(scanner.nextLine().toUpperCase());
        }

        int countToCheck = 0;

        // Duyệt qua từng khách hàng
        for (String customer : customers) {
            if (isUnderageOrDrinking(customer, alcohols)) {
                // Nếu khách hàng dưới 18 tuổi hoặc uống rượu, tăng số lượng cần kiểm tra lên 1
                countToCheck++;
            }
        }

        System.out.println("Output : "+countToCheck);
    }

    private static boolean isUnderageOrDrinking(String info, Set<String> alcohols) {
        try {
            int age = Integer.parseInt(info);
            return age < 18;
        } catch (NumberFormatException e) {
            return alcohols.contains(info);
        }
    }
}