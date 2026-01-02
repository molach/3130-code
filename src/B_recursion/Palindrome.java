void main() {
    IO.println(isPalindrome("racecar"));  // true
    IO.println(isPalindrome("abrttrba")); // true
    IO.println(isPalindrome("abrttsba")); // false
    IO.println(isPalindrome("abrtsba"));  // false
}

/*
In order to write a recursive method, we must identify two things:
1. Base case: the case (or cases) where we can solve the problem very simply, with little or no work.
2. Recursive case: how can we express the problem as a smaller version of itself?
We must make sure that the way we break the problem into smaller parts eventually leads to a base case; otherwise, we'll have infinite recursion.
 */

boolean isPalindrome(String s) {
    if (s.length() <= 1) {
        return true;
    } else {
        String middle = s.substring(1, s.length() - 1);
        return s.charAt(0) == s.charAt(s.length() - 1) && isPalindrome(middle);
    }
}

// another equally-good way:
boolean isPalindrome2(String s) {
    if (s.length() <= 1) {
        return true;
    } else if (s.charAt(0) != s.charAt(s.length() -1)) {
        return false;
    } else {
        return isPalindrome2(s.substring(1, s.length() - 1));
    }
}