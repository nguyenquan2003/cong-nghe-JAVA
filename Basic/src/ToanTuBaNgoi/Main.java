package ToanTuBaNgoi;

public class Main {
    public static void main(String[] args) {
        int a = 100;
        String str1 = "a là số chẵn", str2 = "a là số lẻ", str = "";
        str = (a % 2 == 0) ? str1 : str2;
        System.out.println("thông điệp: "+str);
    }
}
