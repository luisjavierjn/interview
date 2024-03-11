package Questions.StaticBlock;

// What will be the output of the following program?
// a) compilation error
// b) howhi
// c) hihow
// d) runtime error
// e) hi
public class Main {
    public static void main(String[] args) {
        System.out.print("hi");
    }
    static {
        System.out.print("how");
    }
}
