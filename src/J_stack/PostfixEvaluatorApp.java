import J_stack.PostfixEvaluator;

void main() {
    PostfixEvaluator evaluator = new PostfixEvaluator();
    String line = IO.readln("postfix expression: ");

    while (!line.isEmpty()) {
        try {
            int result = evaluator.evaluate(line);
            IO.println("result: " + result);
        } catch (Exception e) {
            IO.println("invalid");
        }

        line = IO.readln("postfix expression: ");
    }
}