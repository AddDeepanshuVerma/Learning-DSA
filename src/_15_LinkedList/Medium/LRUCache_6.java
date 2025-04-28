package _15_LinkedList.Medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_6 extends LinkedHashMap<Integer, Integer> {
    private final int capacity;

    public LRUCache_6(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }
}
