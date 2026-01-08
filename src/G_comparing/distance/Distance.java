package G_comparing.distance;

import java.util.Comparator;

/**
 * A distance in miles or kilometers.
 */
public interface Distance extends Comparable<Distance> {
    // notice: we say that an interface extends (not implements) an interface

    /**
     * Constant used for converting between miles and kilometers:
     * <ul>
     *     <li>mi to km: multiply by 1.60934</li>
     *     <li>km to mi: divide by 1.60934</li>
     * </ul>
     */
    double MI_KM_CONVERSION_CONSTANT = 1.60934;

    /**
     * A distance of zero.
     */
    Distance ZERO = ofMiles(0);

    /**
     * Compares two Distances by their magnitude, that is, by their absolute values.
     */
    Comparator<Distance> BY_MAGNITUDE = new Comparator<>() {
        @Override
        public int compare(Distance d1, Distance d2) {
            return Double.compare(Math.abs(d1.miles()), Math.abs(d2.miles()));
        }
    };

    /**
     * Returns the distance in miles.
     */
    double miles();

    /**
     * Returns the distance in kilometers.
     */
    double kilometers();

    /**
     * Returns a String containing the distance in both mi and km form.
     */
    @Override String toString();

    /**
     * Returns a Distance representing the specified number of miles.
     */
    static Distance ofMiles(double miles) {
        return new DistanceM(miles);
    }

    /**
     * Returns a Distance representing the specified number of kilometers.
     */
    static Distance ofKilometers(double kilometers) {
        return new DistanceK(kilometers);
    }

    /**
     * Returns a Distance parsed from the provided distance string.
     * @param distanceString a String consisting of a number followed by "mi" or "km" and no spaces
     * @throws IllegalArgumentException if the distance string is invalid
     */
    static Distance parse(String distanceString) {
        if (distanceString.endsWith("mi")) {
            return ofMiles(Double.parseDouble(distanceString.substring(0, distanceString.length() - 2)));
        } else if (distanceString.endsWith("km")) {
            return ofKilometers(Double.parseDouble(distanceString.substring(0, distanceString.length() - 2)));
        } else {
            throw new IllegalArgumentException("invalid distance string: " + distanceString);
        }
    }

    /**
     * Returns a Distance representing the sum of this Distance and the provided other Distance.
     */
    default Distance plus(Distance other) {
        return ofMiles(this.miles() + other.miles());
    }

    /**
     * Compares Distances by length.
     * @param other the Distance to compare with this one
     * @return
     * <ul>
     *     <li>a negative int if this distance is less than the other distance</li>
     *     <li>0 if the distances are equal</li>
     *     <li>a positive int if this distance is greater than the other distance</li>
     * </ul>
     */
    @Override
    default int compareTo(Distance other) {
        return Double.compare(this.miles(), other.miles());
        // or: return Double.compare(this.kilometers(), other.kilometers());
    }
}