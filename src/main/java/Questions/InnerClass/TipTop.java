package Questions.InnerClass;

// What will be the result of compiling and running the following Java program?
// a) The program will fail to compile
// b) The program will compile, but throw an exception when run
// c) The program will compile and print 67, when run
// d) The program will compile but will not print anything, when run
public class TipTop {
    static final Integer i1 = 1;
    final Integer i2 = 2;
    Integer i3 = 3;
    public static void main(String[] args) {
        final Integer i4 = 4;
        Integer i5 = 5;

        class Inner {
            final Integer i6 = 6;
            Integer i7 = 7;

            Inner() {
                System.out.println(i6 + i7);
            }
        }
    }
}
