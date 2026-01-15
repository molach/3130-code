void main() {
    IO.println("demoing HashMap");
    Map<String, Integer> map1 = new HashMap<>();
    demo(map1);

    IO.println("demoing LinkedHashMap");
    SequencedMap<String, Integer> map2 = new LinkedHashMap<>();
    demo(map2);
}

private static void demo(Map<String, Integer> map) {
    map.put("January", 31);
    map.put("February", 28);
    map.put("March", 31);
    IO.println("map = " + map);
    IO.println(map.get("March")); // 31
    IO.println(map.put("February", 29)); // 28
    IO.println("map = " + map);
    Set<String> keys = map.keySet();
    IO.println("map's keys: " + keys);
    Collection<Integer> values = map.values();
    IO.println("map's values: " + values);
    Set<Map.Entry<String, Integer>> entries = map.entrySet();
    IO.println("map's entries: " + entries);
    IO.println();
}