package Questions.CallArray;

// What is the result of compiling and running the following program?
// a) 1,2
// b) 5,2
// c) 1,6
// d) 5,6
public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        call_array(arr[0], arr);
        System.out.println(arr[0] + "," + arr[1]);
    }

    private static void call_array(int i, int[] arr) {
        arr[i] = 6;
        i = 5;
    }
}
