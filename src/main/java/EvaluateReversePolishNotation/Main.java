package EvaluateReversePolishNotation;

// Evaluate the value of an arithmetic expression in Reverse Polish Notation. Valid operators are +, -, *, /.
// Each operand may be an integer or another expression.
// For example:
// ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
// ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
public class Main {
    static Strategy sol1 = new NaiveApproach();
    static Strategy sol2 = new AcceptedSolution();
    public static void main(String[] args) {
        String[] tokens = new String[] { "2", "1", "+", "3", "*" };
        System.out.println(sol2.evalRPN(tokens));
    }
}
