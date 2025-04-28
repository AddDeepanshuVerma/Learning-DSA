package _15_LinkedList.Medium;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LRUCache_1 {
    private final int capacity;
    private final LinkedHashSet<Integer> cache;
    private final Map<Integer, Integer> map;

    public LRUCache_1(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new LinkedHashSet<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeItMostFrequent(key);
        return map.get(key);
    }

    private void makeItMostFrequent(int key) {
        cache.remove(key);
        cache.add(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            makeItMostFrequent(key);
            return;
        }
        if (map.size() == capacity) {
            // remove first element of the LinkedHashSet
            Integer removed = cache.removeFirst();
            map.remove(removed);
        }
        // now we can put new element
        map.put(key, value);
        makeItMostFrequent(key);
    }
}
