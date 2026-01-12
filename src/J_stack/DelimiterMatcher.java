package J_stack;

import java.util.List;
import java.util.Stack;

/**
 * A tool that can determine whether the delimiters (), [], and {} in
 * an expression are properly matched. (A classic stack application.)
 */
public class DelimiterMatcher {
    /**
     * Determines if the delimiters in the provided expression are properly matched.
     */
    public boolean isMatched(String expression) {
        Stack<Character> stack = new Stack<>();
        // alternatively, we could use Stack3130 and ArrayStack3130/LinkedStack3130

        for (char ch : expression.toCharArray()) {
            if (isOpeningDelimiter(ch)) {
                stack.push(ch);
            } else if (isClosingDelimiter(ch)) {
                if (stack.isEmpty()) {
                    return false; // nothing to match with
                }

                if (!matches(stack.pop(), ch)) {
                    return false; // mismatched delimiter
                }
            }

            // for debugging
            // IO.println("ch = " + ch + ", stack = " + stack);
        }

        return stack.isEmpty(); // were all opening delimiters matched?
    }

    // parallel Lists (better done with a Map, but we haven't covered that yet)
    private static final List<Character> OPENING_DELIMITERS = List.of('(', '[', '{');
    private static final List<Character> CLOSING_DELIMITERS = List.of(')', ']', '}');

    private static boolean isOpeningDelimiter(char ch) {
        return OPENING_DELIMITERS.contains(ch);
    }

    private static boolean isClosingDelimiter(char ch) {
        return CLOSING_DELIMITERS.contains(ch);
    }

    private static boolean matches(char opening, char closing) {
        return OPENING_DELIMITERS.indexOf(opening) == CLOSING_DELIMITERS.indexOf(closing);
    }

    // some tests
    static void main() {
        String[] valid = {
                "()(()){([()])}",
                "( ) ( ( ) ) {( [ ( )  ] ) } ",
                "(3) (3 + (4 - 5) ) {( [ ( )  ] ) } ",
                "((()(()){([()])}))",
                "[(5+x)-(y+z)]"
        };

        String[] invalid = {
                ")(()){([()])}",
                "({[])}",
                "([]"
        };

        DelimiterMatcher matcher = new DelimiterMatcher();

        for (String s : valid) {
            if (matcher.isMatched(s)) {
                IO.println(s + " is valid");
            } else { // this should not happen
                IO.println(s + " is not valid");
            }
        }

        for (String s : invalid) {
            if (matcher.isMatched(s)) { // this should not happen
                IO.println(s + " is valid");
            } else {
                IO.println(s + " is not valid");
            }
        }
    }
}