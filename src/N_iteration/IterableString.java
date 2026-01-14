package N_iteration;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableString implements Iterable<Character> {
    private final String s;

    public IterableString(String s) {
        this.s = s;
    }

    @Override
    public Iterator<Character> iterator() {
        // returning an instance of an anonymous class that implements Iterator<Character>
        // (alternatively, we could've written a non-static inner class)
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < s.length();
            }

            @Override
            public Character next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                return s.charAt(index++);
            }
        };
    }

    // demo
    static void main() {
        String s = "hello";
        IterableString is = new IterableString(s);

        for (Character ch : is) {
            IO.print(ch + " ");
        }
    }
}