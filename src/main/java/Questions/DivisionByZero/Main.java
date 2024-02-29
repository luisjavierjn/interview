package Questions.DivisionByZero;

public class Main {

    public static void main(String[] args) {
        String a = null;
        try {
            Double b = 1.0 / 0.0; // throw Exception?
            boolean c = b == Double.POSITIVE_INFINITY;
            System.out.println(c);
        } catch(Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
