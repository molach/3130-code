import K_queue.Evaluator;

/**
 * This program prompts for fully-parenthesized arithmetic expressions, and it
 * evaluates each expression.
 */
void main() {
    IO.println("This program evaluates fully parenthesized expressions");
    IO.println("with the operators +, -, *, and /");

    String line = IO.readln("expression (return to quit)? ");

    while (!line.isEmpty()) {
        Evaluator evaluator = new Evaluator(line);

        try {
            IO.println(evaluator.evaluate());
        } catch (Exception e) {
            IO.println("Error: " + e);
        }

        line = IO.readln("expression (return to quit)? ");
    }
}