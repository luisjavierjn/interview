package Tests.ThePowerSum;

// Find the number of ways that a given integer, X, can be expressed as the sum of the Nth  powers of unique, natural numbers.
// For example, if X = 13 and N = 2, we have to find all combinations of unique squares adding up to 13. The only solution is 2^2 + 3^2.
//
// Function Description
//
// Complete the powerSum function in the editor below. It should return an integer that represents the number of possible combinations.
//
// powerSum has the following parameter(s):
//
// X: the integer to sum to
// N: the integer power to raise numbers to
//
// Input Format
//
// The first line contains an integer X.
// The second line contains an integer N.
//
// Constraints
//
// 1 <= X <= 1000
// 2 <= N <= 10
//
// Output Format
//
// Output a single integer, the number of possible combinations caclulated.
//
// Sample Input 0
// 10
// 2
//
// Sample Output 0
// 1
//
// Explanation 0
// If X = 10 and N = 2, we need to find the number of ways that 10  can be represented as the sum of squares of unique numbers.
// 10 = 1^2 + 3^2
//
// This is the only way in which  can be expressed as the sum of unique squares.
//
// Sample Input 1
// 100
// 2
//
// Sample Output 1
// 3
//
// Explanation 1
// 100 = (10^2) = (6^2 + 8^2) = (1^2 + 3^2 + 4^2 + 5^2 + 7^2)
//
// Sample Input 2
// 100
// 3
//
// Sample Output 2
// 1
//
// Explanation 2
// 100 can be expressed as the sum of the cubes of 1,2,3,4.
// (1+8+27+64=100). There is no other way to express  as the sum of cubes.
public class Main {
    /*
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER X
     *  2. INTEGER N
     */

    public static int powerSum(int X, int N) {
        // Start the recursive function with initial number 1
        return powerSumRecursive(X, N, 1);
    }

    private static int powerSumRecursive(int x, int n, int num) {
        // Calculate the power of the current number
        int pow = (int)Math.pow(num, n);

        // If the power is more than x, no solution is possible with this and further numbers
        if (pow > x) {
            return 0;
        }
        // If the power is exactly x, a solution is found
        else if (pow == x) {
            return 1;
        }
        // Otherwise, explore two possibilities: including or not including the current number
        else {
            // Include the current number and move to the next, reducing x by the current number's power
            int includeCurrent = powerSumRecursive(x - pow, n, num + 1);
            // Exclude the current number and move to the next without changing x
            int excludeCurrent = powerSumRecursive(x, n, num + 1);
            // Return the sum of both possibilities
            return includeCurrent + excludeCurrent;
        }
    }

    public static void main(String[] args) {
        System.out.println(powerSum(10,2));
        System.out.println(powerSum(100,2));
    }
}
