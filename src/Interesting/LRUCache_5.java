package Interesting;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_5 {
    static class Node {
        int key;

        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;

    public LRUCache_5(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        map.put(key, value);
    }
}
