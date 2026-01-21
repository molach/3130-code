void main() {
    String[] arr = {"aa", "b", "ccc", "aaa", "baa", "aa"};

    // classify the elements by their first character
    Map<Character, List<String>> map1 = Arrays.stream(arr)
            .collect(Collectors.groupingBy(s -> s.charAt(0)));
    IO.println(map1);

    Set<String> set = Arrays.stream(arr)
            .map(String::toUpperCase)
            .collect(Collectors.toSet());
    IO.println(set);

    String s1 = Arrays.stream(arr)
            .map(String::toUpperCase)
            .collect(Collectors.joining());
    IO.println(s1);

    String s2 = Arrays.stream(arr)
            .map(String::toUpperCase)
            .collect(Collectors.joining(", "));
    IO.println(s2);
}