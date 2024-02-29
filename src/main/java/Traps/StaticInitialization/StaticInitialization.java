package Traps.StaticInitialization;

// What is the printed output?
// Expected Output Value: 50
public class StaticInitialization {
    private static final int MULTIPLIER;
    private static final int VALUE = getInitialValue();

    static {
        MULTIPLIER = 10;
        System.out.println("static block");
    }

    private static int getInitialValue() {
        return 5 * MULTIPLIER;
    }

    public static void main(String[] args) {
        System.out.println("Value: " + VALUE);
    }
}
