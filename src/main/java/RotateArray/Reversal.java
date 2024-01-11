package RotateArray;

// we do this in O(1) space and in O(n) time
// the array [1,2,3,4,5,6] and order is 2
// 1. Divide the array two parts: 1,2,3,4 and 5, 6
// 2. Reverse first part: 4,3,2,1,5,6
// 3. Reverse second part: 4,3,2,1,6,5
// 4. Reverse the whole array: 5,6,1,2,3,4
public class Reversal implements Strategy {
    @Override
    public void rotate(int[] arr, int order) {
        if (arr == null || arr.length==0 || order < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }
        if(order > arr.length){
            order = order %arr.length;
        }

        //length of first part
        int a = arr.length - order;
        reverse(arr, 0, a-1);
        reverse(arr, a, arr.length-1);
        reverse(arr, 0, arr.length-1);
    }

    private void reverse(int[] arr, int left, int right){
        if(arr == null || arr.length == 1)
            return;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
