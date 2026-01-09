package J_stack;

/*
Notation    Description                     Examples

infix       operator between operands       2 + 4
                                            2 * 3
                                            (3 + 7) * 18 + 2 / 4

prefix      operator before operands        + 2 4
            (aka functional notation)       * 2 3
            (aka Polish notation)           + * + 3 7 18 / 2 4

postfix     operator after operands         2 4 +
            (aka reverse Polish notation)   2 3 *
                                            3 7 + 18 * 2 4 / +

Problem: given a String containing an expression in postfix notation,
determine the result.
For example, if the String is "5 2 + 11 3 - * 4 /", the result should be 14.
For simplicity, assume that there are spaces between all numbers and operators.

Solution: Use a stack of numbers.
- First, split the string up into tokens separated by whitespace. (Can use a Scanner.)
- Then, for each token:
    - If the token is an operator, pop two numbers off the stack,
      apply the operation to the two numbers, and push the result onto the stack.
      If there aren't two elements to pop off the stack, the expression is not valid.
    - Otherwise, if the token is a number, push it onto the stack.
    - Otherwise, the expression is not valid.
- At the end, the stack should contain exactly one number, which is the result.
  If the stack does not contain exactly one number, the expression is not valid.
 */

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluator {
    public int evaluate(String expression) {
        Scanner scanner = new Scanner(expression);
        Stack<Integer> stack = new Stack<>();

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                stack.push(scanner.nextInt());
            } else {
                String operator = scanner.next();
                int num1 = stack.pop(); // throws exception if stack.isEmpty()
                int num2 = stack.pop(); // throws exception if stack.isEmpty()
                int result = apply(operator, num2, num1); // note the order
                stack.push(result);
            }
        }

        if (stack.size() != 1) {
            throw new RuntimeException("Incorrect number of operators in expression");
        } else {
            return stack.peek();
        }
    }

    // Given an operator (+, -, *, or /) and two operands, returns the
    // result of applying the given operator to the given operands.
    private static int apply(String operator, int operand1, int operand2) {
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            default -> throw new RuntimeException("Illegal operator " + operator);
        };
    }
}