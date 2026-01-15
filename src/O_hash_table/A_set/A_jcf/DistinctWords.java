/*
This program prints the number of distinct words in a given file.

The running time is O(n), where n is the number of words in the file.
*/
void main() throws FileNotFoundException {
    String filename = IO.readln("filename? ");
    Scanner fileScanner = new Scanner(new File(filename));
    Set<String> distinctWords = new HashSet<>();

    while (fileScanner.hasNext()) {
        String word = fileScanner.next();
        distinctWords.add(word);
    }

    IO.println("Number of distinct words: " + distinctWords.size());
}