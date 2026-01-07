import E_adt.distance.Distance;
import E_adt.distance.Distances;

void main() throws FileNotFoundException {
    File file = new File("src/E_adt/distances.txt");
    Scanner fileScanner = new Scanner(file);
    Distance sum = Distance.ZERO;

    while (fileScanner.hasNext()) {
        String token = fileScanner.next();

        try {
            Distance distance = Distance.parse(token);
            sum = sum.plus(distance);
        } catch (IllegalArgumentException e) {
            IO.println(e);
        }
    }

    Distances.printMilesAndKilometers(sum);
}