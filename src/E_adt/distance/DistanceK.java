package E_adt.distance;

// A package-private record; clients do not need to know of its existence.
// In this implementation, we store the temperature in kilometers form,
// and the miles() method performs a conversion.
public record DistanceK(double kilometers) implements Distance {
    @Override
    public double miles() {
        return kilometers / MI_KM_CONVERSION_CONSTANT;
    }
}