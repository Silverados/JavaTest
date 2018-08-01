package Book.sort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{5, -9, -7, 0, 5, 9, 3, 2})));
    }

    public static int[] sort(int[] ints) {
        int index = 0;
        int temp =0;
        for (int i = 0; i < ints.length; i++) {
            int min = ints[i];
            for (int j = i; j < ints.length; j++) {
                if (min >= ints[j]) {
                    min = ints[j];
                    index = j;
                }
            }
            temp = ints[i];
            ints[i] = min;
            ints[index] = temp;
        }
        return ints;
    }
}
