package EvaluateReversePolishNotation;

import java.util.Stack;

public class NaiveApproach implements Strategy {
    @Override
    public int evalRPN(String[] tokens) {
        int returnValue = 0;
        String operators = "+-*/";
        Stack<String> stack = new Stack<>();
        for (String t : tokens) {
            if (!operators.contains(t)) { //push to stack if it is a number
                stack.push(t);
            } else {//pop numbers from stack if it is an operator
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                switch (t) {
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(b - a));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }
        returnValue = Integer.parseInt(stack.pop());
        return returnValue;
    }
}
