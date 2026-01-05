
package D_complexity;

/**
 * Provides an empirical test of the efficiency of repeated string concatenation
 * versus use of the StringBuilder class.
 */
public class StringExperiment {
    /**
     * Uses repeated concatenation to compose a String with n copies of ch.
     */
    public static String repeat1(char ch, int n) {
        String result = "";

        for (int i = 0; i < n; i++) {
            result += ch;
        }

        return result;
    }
    /*
    String objects are immutable. Therefore, when executing `result += ch`,
    Java does not add ch to the end of an existing String object. Instead,
    Java creates a new String object, copies all characters from the old
    String object into the new String object, and adds ch at the end.
    Running time of repeat1:
    - in the first pass of the loop, there is 1 step
    - in the second pass, there are two steps.
    - in the third pass, there are three steps
    - and so on.
    - There are n passes in total.
    The total number of steps is approximately 1 + 2 + 3 + ... + n.
    1 + 2 + 3 + ... + n = (1/2)n^2 + (1/2)n.
    So the running time is O(n^2).
     */

    /**
     * Uses a StringBuilder to compose a String with n copies of ch.
     */
    public static String repeat2(char ch, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(ch);
        }

        return sb.toString();
    }
    /*
    Executing `sb.append(ch)` does not create a new StringBuilder object.
    Instead, it simply adds ch to the end of the existing StringBuilder.
    Running time of repeat2:
     - the for loop runs n times.
     - Inside the loop, we just call the append method of StringBuilder
     - the append method runs in constant time.
     - The toString() method runs in O(n) time, but only gets called once.
    So the running time of repeat2 is O(n).
     */

    /**
     * Tests the two versions of the 'repeat' algorithm, doubling the size of n each trial.
     */
    static void main() {
        int n = 50000;
        int trials = 10;
        int start = n;  // remember the original starting value

        // let's run version 2 (the faster one) first
        IO.println("Testing repeat2...");
        for (int t = 0; t < trials; t++) {
            long startTime = System.currentTimeMillis();
            String temp = repeat2('-', n);
            long endTime = System.currentTimeMillis();
            long elapsed = endTime - startTime;
            IO.println("n: %,12d took %,12d milliseconds%n".formatted(n, elapsed));
            n *= 2;                                // double the problem size
        }

        IO.println("Testing repeat1...");
        n = start;                               // restore n to its start value
        for (int t = 0; t < trials; t++) {
            long startTime = System.currentTimeMillis();
            String temp = repeat1('-', n);
            long endTime = System.currentTimeMillis();
            long elapsed = endTime - startTime;
            IO.println("n: %,12d took %,12d milliseconds%n".formatted(n, elapsed));
            n *= 2;                                // double the problem size
        }
    }
}
