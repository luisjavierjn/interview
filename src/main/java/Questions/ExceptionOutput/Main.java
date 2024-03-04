package Questions.ExceptionOutput;

class Exc0 extends Exception { }
class Exc1 extends Exc0 { } /* Line 4 */

// What will be the output?
// a) Exception caught
// b) Ex0 caught
// c) Compilation fails because of an error at line 4
// d) Compilation fails because of an error at line 14
public class Main {
    public static void main(String[] args) {
        try {
            throw new Exc1(); /* Line 14 */
        } catch (Exc0 e0) { /* Line 15 */
            System.out.println("Ex0 caught");
        } catch (Exception e) {
            System.out.println("exception caught");
        }
    }
}
