// The Java Collections Framework is a set of interfaces and classes used
// for storing collections of data. For example, ArrayList is part of the JCF.
// The JCF is a small part of the Java library, also known as the Java API.

// The following program demonstrates the java.util.Stack class, part of the JCF.
// There's a better version of stack in the JCF; we'll cover it later, with Deque.
void main() {
    Stack<Integer> stack = new Stack<>();
    stack.push(10);
    stack.push(5);
    stack.push(15);
    IO.println(stack.isEmpty()); // false
    IO.println(stack.size()); // 3
    IO.println(stack); // [10, 5, 15]
    // Note that Stack's toString() lists the elements from bottom to top,
    // unlike the usual convention, which we followed in Stack264.

    IO.println(stack.peek()); // 15
    IO.println(stack.peek()); // 15

    IO.println(stack.pop()); // 15
    IO.println(stack.peek()); // 5

    IO.println(stack.pop()); // 5
    IO.println(stack.pop()); // 10
    IO.println(stack.isEmpty()); // true
}