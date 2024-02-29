package Others.ReverseArrayWithFrequencyCount;

import java.util.Arrays;

public class Main {

    public static void main(String... reverseWithFrequencyArray) {
        int[] array = {2, 3, 4, 5, 1, 6, 7, 8, 12, 14, 17};
        int length = array.length;
        int fc = 3;
        System.out.println(Arrays.toString(array));
        for (int i=0; i<length; i=i+fc) {
            int start = i;
            int end = Math.min(i+fc-1, length-1);
            while (start < end) {
                int temp = array[start];
                array[start++] = array[end];
                array[end--] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
