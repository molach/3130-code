// Prints the unique words from the file, ordered by
// the order in which they were first seen in the file.
void main() throws FileNotFoundException {
    String filename = IO.readln("filename? ");
    Scanner scanner = new Scanner(new File(filename));
    SequencedSet<String> words = new LinkedHashSet<>();

    while (scanner.hasNext()) {
        String word = scanner.next();
        words.add(word);
    }

    for (String word : words) {
        IO.println(word);
    }
}