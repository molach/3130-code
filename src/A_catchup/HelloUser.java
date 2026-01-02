// Prompts the user for their name, reads it in, and prints a greeting.
// Uses new Java 25 features. To learn more: https://openjdk.org/jeps/512

// whatever

void main() {
    String name = IO.readln("What is your name? ");
    printGreeting(name);
}

void printGreeting(String name) {
    IO.println("Hello, " + name + "!");
}
