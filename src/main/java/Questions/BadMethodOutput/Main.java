package Questions.BadMethodOutput;

public class Main {
    public static void main(String[] args) {
        try {
            badMethod();
            System.out.println("A");
        } catch (Exception ex) {
            System.out.println("B");
        } finally {
            System.out.println("C");
        }
        System.out.println("D");
    }

    private static void badMethod() {
    }
}
