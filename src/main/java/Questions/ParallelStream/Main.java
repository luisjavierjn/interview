package Questions.ParallelStream;

import java.util.Arrays;
import java.util.List;

// Which of the following statements about the output of the program is true?
// a) The output will always be non-deterministic
// b) The first number of the output will always be 13
// c) The first number of the output will always be 1
// d) Sometimes, not every number will be printed
public class Main {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(1 ,5 ,8 ,13);
        myList.parallelStream().forEach(i -> System.out.println(i + " "));
    }
}
