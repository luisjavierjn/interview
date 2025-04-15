package Others.ReverseArray;

import java.util.Arrays;

// 🚀 Java Coding Mastery Series: Reverse #array problem in #java
// https://www.youtube.com/watch?v=o_hNrb2XlGw
public class Main {

    public static void main(String... reverseArray) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] copiedArray = Arrays.copyOf(array, array.length);
        System.out.println(Arrays.toString(array));
        newArrayApproach(array);
        System.out.println(Arrays.toString(copiedArray));
        swappingApproach(copiedArray);
    }

    private static void newArrayApproach(int[] array) {
        int length = array.length;
        int[] newArray = new int[length];
        for (int i=length-1,j=0; i>=0; i--,j++) {
            newArray[j] = array[i];
        }
        System.out.println(Arrays.toString(newArray));
    }

    private static void swappingApproach(int[] array) {
        int length = array.length;
        for (int i=0; i<length/2; i++) {
            int temp = array[i];
            array[i] = array[length-(i+1)];
            array[length-(i+1)] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
