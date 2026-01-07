package E_adt.distance;

// contains utility methods for working with Distance objects
public class Distances {
    public static void printMilesAndKilometers(Distance distance) {
        // Note that this method doesn't care or know what kind of Distance it is given.
        IO.println(distance.miles() + "m " + distance.kilometers() + "k");
    }

    // Returns -1, 1, or 0, as the provided Distance is negative, positive, or zero.
    public static int signum(Distance distance) {
        // This method also doesn't care or know what kind of Distance it is given.
        // We could just as well have used kilometers() instead of miles().
        if (distance.miles() < 0) {
            return -1;
        } else if (distance.miles() > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}