package _15_LinkedList.Medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_5 {

    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;

    public LRUCache_5(int capacity) {
        CAPACITY = capacity;

        /*
        new LinkedHashMap<Integer,String>(16, .75f, true);
        With that true you specify that you want an "access-ordered" map, not an "insertion-ordered" map.
        This means that you will get the values in the order of access (least recently accessed first).
        Both your get and put calls constitute an "access".

        A special constructor is provided to create a linked hash map whose order of iteration is the order in which its entries were last accessed,
        from least-recently accessed to most-recently (access-order). This kind of map is well-suited to building LRU caches.
        Invoking the put or get method results in access to the corresponding entry (assuming it exists after the invocation completes).
        */

        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
