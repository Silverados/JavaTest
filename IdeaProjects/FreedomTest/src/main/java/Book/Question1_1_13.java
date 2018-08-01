package Book;

import java.util.Arrays;

public class Question1_1_13 {
    public static void main(String[] args){
        Object[][] a = {{1,2},{3,4},{5,6}};
        revert(a);
    }

    public static void revert(Object[][] array){
        int M = array.length;
        int N = array[0].length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(array[j][i]);
                if (j != M-1) System.out.print(" ");
            }
            System.out.println();
        }

    }
}
