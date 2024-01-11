package RotateArray;

// Rotate an array of n elements to the right by k steps. For example, with n
// = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]
public class Main {
    static Strategy sol1 = new IntermediateArray();
    static BubbleRotate sol2 = new BubbleRotate();
    static Reversal sol3 = new Reversal();

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 2;
        sol3.rotate(nums,k);
        for(int i = 0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
