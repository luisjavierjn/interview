package Tests.ContainerWithMostWater;

// https://leetcode.com/problems/container-with-most-water/description/
// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// Find two lines that together with the x-axis form a container, such that the container contains the most water.
// Return the maximum amount of water a container can store.
// Notice that you may not slant the container.

// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
public class Main {

    public static int solution1(Integer[] array,int i, int j) {
        if(i >= j) return 0;
        int izq = array[i];
        int der = array[j];
        int dif = j-i;
        int min = Math.min(izq,der);
        int area = dif * min;

        int a = solution1(array,i+1,j);
        int b = solution1(array,i,j-1);

        return Math.max(area,Math.max(a,b));
    }

    public static int solution2(Integer[] array) {
        int i = 0;
        int j = array.length-1;
        int area = 0;

        while(i < j) {
            int izq = array[i];
            int der = array[j];
            int dif = j-i;
            int min = Math.min(izq,der);
            area = Math.max(dif * min,area);

            if(izq <= der) i++;
            if(izq > der) j--;
        }

        return area;
    }

    public static void main(String args[]) {
        Integer[] array = {1,8,6,2,5,4,8,3,7};
        int sol1= solution1(array, 0, array.length-1);
        System.out.println(sol1);

        int sol2= solution2(array);
        System.out.println(sol2);
    }
}
