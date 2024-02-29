package Others.RotateArray;

import java.util.Arrays;

// 🚀Crack #coding round: Rotate Array in clock wise problem using #java💻
// https://www.youtube.com/watch?v=YqjFPT5SHcA
public class Main {

    public static void main(String... rotateArray) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] copiedArray = Arrays.copyOf(array, array.length);
        System.out.println(Arrays.toString(array));
        int rotationCount = 3;
        rotateClockwiseArray(array, rotationCount);
        System.out.println(Arrays.toString(array));
        rotateAntiClockwiseArray(copiedArray, rotationCount);
        System.out.println(Arrays.toString(copiedArray));
    }

    private static void rotateClockwiseArray(int[] array, int rotationCount) {
        if (array.length < 2 && rotationCount >= array.length)
            System.out.println("Wrong parameters");

        //Step1 : Reverse Whole array
        reverseArray(array, 0, array.length-1);
        //Step2 : Reverse 0 to RC
        reverseArray(array, 0, rotationCount-1);
        //Step3 : Reverse RC to end of array
        reverseArray(array, rotationCount, array.length-1);
    }

    private static void rotateAntiClockwiseArray(int[] array, int rotationCount) {
        if (array.length < 2 && rotationCount >= array.length)
            System.out.println("Wrong parameters");

        //Step1 : Reverse 0 to RC
        reverseArray(array, 0, rotationCount-1);
        //Step2 : Reverse RC to end of array
        reverseArray(array, rotationCount, array.length-1);
        //Step3 : Reverse Whole array
        reverseArray(array, 0, array.length-1);
    }

    private static void reverseArray(int[] array, int start, int end) {
        while(start < end) {
            int temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        }
    }
}
