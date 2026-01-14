package K_queue.eval;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Note: the expression must be fully-parenthesized,
 * e.g., ((2.5+3)+4). Also, the only operators allowed are binary +, -, *, /, and ^.
 * We do not allow unary operators (such as -) here.
 *
 * The algorithm uses two stacks to store intermediate results:
 * one stores numbers and the other stores operators.
 *
 * As we see operators, we push them onto the symbol stack.
 * As we see numbers, we push them onto the number stack.
 * And when we see a right parenthesis, we know we have all the information for
 * a subexpression, so we evaluate it, and push the result onto the number stack.
 *
 * (From Building Java Programs ch. 14, with some modifications.)
 */
public class Evaluator {
    private final String expression;

    // better done with a Set, but we didn't cover it yet
    private static final List<String> OPERATORS = List.of("+", "-", "*", "/");

    public Evaluator(String expression) {
        this.expression = expression;
    }

    public double evaluate() {
        StringSplitter tokens = new StringSplitter(expression);
        Deque<String> operatorStack = new ArrayDeque<>();
        Deque<Double> numberStack = new ArrayDeque<>();

        while (tokens.hasNext()) {
            String token = tokens.next();

            if (token.equals(")")) {
                if (operatorStack.isEmpty() || numberStack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression: " + expression);
                } else {
                    String operator = operatorStack.pop();
                    double operand2 = numberStack.pop();
                    double operand1 = numberStack.pop();
                    double value = evaluate(operator, operand1, operand2);
                    numberStack.push(value);
                }
            } else if (isOperator(token)) {
                operatorStack.push(token);
            } else if (!token.equals("(")) {  // token should now be a number
                numberStack.push(Double.parseDouble(token));
            }

            // for debugging
            // System.out.printf("%-5s%-20s%-20s%n", token, operatorStack, numberStack);
        }

        if (numberStack.size() != 1 || !operatorStack.isEmpty()) {
            throw new IllegalArgumentException("Invalid expression: " + expression);
        } else {
            return numberStack.pop();
        }
    }

    private static boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    // Given an operator (+, -, *, or /) and two operands, returns
    // the result of applying the given operator to the given operands.
    private static double evaluate(String operator, double operand1, double operand2) {
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            default -> throw new IllegalArgumentException("Illegal operator " + operator);
        };
    }
}