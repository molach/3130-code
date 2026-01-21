void main() throws IOException {
    Path path = Paths.get("input.txt");

    IO.println("all lines:");
    Files.lines(path).forEach(IO::println);
    IO.println();

    IO.print("longest line containing \"the\": ");
    Files.lines(path)
            .filter(line -> line.contains("the"))
            .max(Comparator.comparing(String::length))
            .ifPresent(IO::println);

    IO.print("longest token: ");
    Scanner scanner = new Scanner(new File("input.txt"));
//        String longestSoFar = "";
//        while (scanner.hasNext()) {
//            String current = scanner.next();
//            if (current.length() > longestSoFar.length()) {
//                longestSoFar = current;
//            }
//        }
//        IO.println(longestSoFar);
    scanner.tokens()
            .max(Comparator.comparing(String::length))
            .ifPresent(IO::println);
}