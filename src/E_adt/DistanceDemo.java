import E_adt.distance.Distance;
import E_adt.distance.Distances;

// client code. doesn't know or care about the various implementations of Distance
void main() {
    Distance d1 = Distance.ofMiles(10);
    IO.println(d1.miles()); // 10.0
    IO.println(d1.kilometers()); // 16.0934

    Distance d2 = Distance.ofKilometers(10);
    Distances.printMilesAndKilometers(d2); // 6.213727366498068m 10.0k

    Distance sum = d1.plus(d2);
    IO.println(sum.miles()); // 16.21372736649807
    IO.println(sum.kilometers()); // 26.093400000000003

    Distance d3 = Distance.parse("1.5mi");
    Distances.printMilesAndKilometers(d3);

    Distance d4 = Distance.parse("1.5km");
    Distances.printMilesAndKilometers(d4);
}