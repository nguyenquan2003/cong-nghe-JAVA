package MangMotChieu;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        String[] strings = {"abc", "def", "ghi", "ijk"};
        float[] marks = {6.5f, 7.8f, 8.9f, 9.8f};
        System.out.println("Độ dài của mảng friends: " + strings.length);
        System.out.println("Độ dài của mảng numbers: " + numbers.length);
        System.out.println("Độ dài của mảng marks: " + marks.length);
        System.out.println();

        for(int i = 0; i< strings.length; i++)
        {
            System.out.println("String[" + i + "]= "+ strings[i]);
        }
    }
}
