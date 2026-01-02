package A_catchup;

import java.util.Objects;

public class NullSafeEqualsDemo {
    static void main() {
        String[] arr1 = {"hello", null, "world"};
        IO.println(contains(arr1, "world")); // true
        IO.println(contains(arr1, "goodbye")); // false
        IO.println(contains(arr1, null)); // true
    }

    public static boolean contains(String[] arr, String s) {
        for (String element : arr) {
            /*
            if (element == null) {
                if (s == null) {
                    return true;
                }
            } else {
                if (element.equals(s)) { // call standard equals
                    return true;
                }
            }
             */
            // more concise:
            if (Objects.equals(element, s)) { // null-safe
                return true;
            }
        }

        return false;
    }
}
