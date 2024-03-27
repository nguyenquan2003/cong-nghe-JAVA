package ForEach;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        String[] strings = {"abc", "def", "ghi", "ijk"};
        float[] marks = {6.5f, 7.8f, 8.9f, 9.8f};
        for(float mark : marks)
        {
            System.out.println(mark);
        }
        System.out.println();

        int[][] maxtrix =
                {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                };
        for(int[] m : maxtrix)
        {
            for(int i : m)
            {
                System.out.print(i+ " ");
            }
            System.out.println("");
        }
    }
}
