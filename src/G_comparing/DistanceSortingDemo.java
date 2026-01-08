import G_comparing.distance.Distance;

void main() throws FileNotFoundException {
    Scanner fileScanner = new Scanner(new File("distances.txt"));
    List<Distance> distances = new ArrayList<>();

    while (fileScanner.hasNext()) {
        String distanceString = fileScanner.next();

        try {
            distances.add(Distance.parse(distanceString));
        } catch (IllegalArgumentException e) {
            IO.println("skipping invalid distance string: " + distanceString);
        }
    }

    Collections.sort(distances);
    // or: distances.sort(Comparator.naturalOrder());

    IO.println("distances sorted by numeric order:");
    for (Distance distance : distances) {
        IO.println(distance);
    }

    distances.sort(Distance.BY_MAGNITUDE);
    // or: Collections.sort(distances, Distance.BY_MAGNITUDE);

    IO.println("distances sorted by magnitude:");
    for (Distance distance : distances) {
        IO.println(distance);
    }
}