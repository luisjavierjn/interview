package Traps.StaticInitialization;

// Expected Output Value: 50
public class StaticInitialization {
    private static final int MULTIPLIER;
    private static final int VALUE = getInitialValue();

    static {
        MULTIPLIER = 10;
    }

    private static int getInitialValue() {
        return 5 * MULTIPLIER;
    }

    public static void main(String[] args) {
        System.out.println("Value: " + VALUE);
    }
}
