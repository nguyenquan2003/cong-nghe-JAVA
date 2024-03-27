package KieuDLString;

public class Main {
    public static void main(String[] args) {
        String msg = "Hello Word";
        System.out.println("các ký tự viết hoa trong chuỗi thành ký tự viết thường: "+msg.toLowerCase()); //hàm in thường chữ cái đầu tiên
        System.out.println("ìn vị trí của một chuỗi con trong chuỗi hiện tại: "+msg.indexOf("e"));
        System.out.println();

        String str1="hello";
        String str2="word";
        String index= str1 + " " + str2;
        System.out.println("nối chuỗi: "+index);
    }
}
