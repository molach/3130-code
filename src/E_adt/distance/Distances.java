package E_adt.distance;

// contains a utility method for working with distances
public class Distances {
    public static void printMilesAndKilometers(Distance distance) {
        // Note that this method doesn't care or know what kind of Distance it is given.
        IO.println(distance.miles() + "m " + distance.kilometers() + "k");
    }
}