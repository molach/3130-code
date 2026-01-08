import F_generics.A_generic_types.set.ArraySet;
import F_generics.A_generic_types.set.MySet;

void main() {
    MySet<String> stringSet = new ArraySet<>(10);

    stringSet.add("hello");
    stringSet.add(null); // allowed
    stringSet.add("world");

    MySet<Double> doubleSet = new ArraySet<>(5);
    doubleSet.add(1.5); // autoboxed
}
