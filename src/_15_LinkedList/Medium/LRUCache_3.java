package _15_LinkedList.Medium;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache_3 {
    record Pair<K, V>(K node, V value) {
    }

    static class Node {
        int key;

        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    int capacity;
    LinkedList<Node> DLL;
    HashMap<Integer, Pair<Node, Integer>> map;

    public LRUCache_3(int capacity) {
        this.capacity = capacity;
        DLL = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Pair<Node, Integer> pair = map.get(key);
            // make this element most frequent
            DLL.remove(pair.node);
            DLL.addFirst(pair.node);
            return pair.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLL.remove(map.remove(key).node);
        } else if (map.size() == capacity) {
            map.remove(DLL.removeLast().key);
        }
        Node newNode = new Node(key, value);
        DLL.addFirst(newNode);
        map.put(key, new Pair<>(newNode, value));
    }

    public void put2(int key, int value) {
        if (map.containsKey(key)) {
            Pair<Node, Integer> oldPair = map.get(key);
//            delete previous Node from DLL & map
            DLL.remove(oldPair.node);
            map.remove(key);
        } else if (map.size() == capacity) {
            Node node = DLL.removeLast();
            map.remove(node.key);
        }
//         add new key value pair in map and put that as first node of DLL
        Node newNode = new Node(key, value);
        Pair<Node, Integer> newPair = new Pair<>(newNode, value);
        DLL.addFirst(newNode);
        map.put(key, newPair);
    }
}
