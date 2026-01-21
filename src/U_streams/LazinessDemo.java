void main() {
    Stream<String> stream = Stream.of("one", "two", "three", "four");

    stream = stream.filter(s -> {
        IO.println("filtering " + s);
        return s.length() == 5;
    });

    // nothing gets printed yet

    IO.println("About to invoke the terminal operation");

    stream.findAny().ifPresent(IO::println);
    // filtering one
    // filtering two
    // filtering three
    // three

    // note that four was never filtered, because it didn't need to be
}
