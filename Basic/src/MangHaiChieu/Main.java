package MangHaiChieu;

public class Main {
    public static void main(String[] args) {
        int[][] maxtrix =
                {
                        {1,2,3},
                        {4,5,6},
                        {7,8,9}
                };
        for(int i = 0; i < maxtrix.length; i++)
        {
            for(int j = 0; j<maxtrix.length; j++)
            {
                System.out.print(maxtrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
