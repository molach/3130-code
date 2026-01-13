package K_queue;

import java.util.ArrayDeque;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * A StringSplitter breaks up a string into a sequence of tokens using
 * both whitespace and a list of special characters that are each
 * considered tokens. The special characters in this case are used
 * to tokenize an arithmetic expression. For example, the expression:
 *      2*3.8/(4.95-7.8)
 * would be tokenized as
 *      2 * 3.8 / ( 4.95 - 7.8 )
 * even though it has no whitespace to separate these tokens.
 * (From Building Java Programs ch. 14, with some modifications.)
 */
public class StringSplitter {
    private final Queue<Character> queue; // the characters we still need to process
    private String token; // the next token for next() to return, or null if we've run out of tokens

    // better to use a Set, but we haven't covered that yet
    private static final List<Character> SPECIAL_CHARACTERS = List.of('(', ')', '+', '-', '*', '/');

    public StringSplitter(String expression) {
        queue = new ArrayDeque<>(expression.length());

        for (char ch : expression.toCharArray()) {
            queue.add(ch);
        }

        findNext();
    }

    public boolean hasNext() {
        return token != null;
    }

    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        String result = token;
        findNext();
        return result;
    }

    private void findNext() {
        while (!queue.isEmpty() && Character.isWhitespace(queue.peek())) {
            queue.remove();
        }

        if (queue.isEmpty()) {
            token = null;
        } else if (SPECIAL_CHARACTERS.contains(queue.peek())) {
            token = String.valueOf(queue.remove());
        } else { // build a token
            StringBuilder sb = new StringBuilder().append(queue.remove());
            boolean done = false;

            while (!queue.isEmpty() && !done) {
                char ch = queue.peek();

                if (Character.isWhitespace(ch) || SPECIAL_CHARACTERS.contains(ch)) {
                    done = true;
                } else {
                    sb.append(queue.remove());
                }
            }

            token = sb.toString();
        }
    }

    // small demo
    static void main() {
        StringSplitter stringSplitter = new StringSplitter("2*3.8/(4.95-7.8)");

        while (stringSplitter.hasNext()) {
            IO.print(stringSplitter.next() + " ");
        }
    }
}