package E_adt.distance;

// A package-private record; clients do not need to know of its existence.
// In this implementation, we store the temperature in miles form,
// and the kilometers() method performs a conversion.
record DistanceM(double miles) implements Distance {
    @Override
    public double kilometers() {
        return miles * MI_KM_CONVERSION_CONSTANT;
    }
}