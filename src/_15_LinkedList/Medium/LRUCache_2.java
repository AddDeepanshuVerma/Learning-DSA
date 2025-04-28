package _15_LinkedList.Medium;

import java.util.*;

public class LRUCache_2 {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> map;

    public LRUCache_2(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Integer val = map.remove(key);
            map.put(key, val);
            return val;
        }
        return -1;
    }


    public void put(int key, int value) {
        if (map.containsKey(key))
            map.remove(key);
        else if (map.size() == capacity)
            map.remove(map.keySet().iterator().next());
        map.put(key, value);
    }
}
