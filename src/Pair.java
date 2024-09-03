class Pair<K, V> {
    public static void main(String[] args) {
        Pair4 p4 = new Pair4();
        Pair3 p3 = new Pair3(5, 6);
        System.out.println(p3.key());
        System.out.println(p3.value());

        Pair<String, String> p = new Pair<>("key", "value");
        System.out.println(p.getKey());

    }

    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "(" + this.key + ", " + this.value + ")";
    }
}

record Pair2<K, V>(K key, V value) {
}

record Pair3(Integer key, Integer value) {
}

record Pair4() {
}