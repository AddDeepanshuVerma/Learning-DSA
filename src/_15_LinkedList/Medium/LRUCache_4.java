package _15_LinkedList.Medium;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache_4 {

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
    HashMap<Integer, Node> map;

    public LRUCache_4(int capacity) {
        this.capacity = capacity;
        DLL = new LinkedList<>();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // make this element most frequent
            DLL.remove(node);
            DLL.addFirst(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DLL.remove(map.remove(key));
        } else if (map.size() == capacity) {
            map.remove(DLL.removeLast().key);
        }
        Node newNode = new Node(key, value);
        DLL.addFirst(newNode);
        map.put(key, newNode);
    }

    public void put2(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            temp.value = value;

            DLL.remove(temp);
            DLL.addFirst(temp);
            return;
        } else if (map.size() == capacity) {
            map.remove(DLL.removeLast().key);
        }
        Node newNode = new Node(key, value);
        DLL.addFirst(newNode);
        map.put(key, newNode);
    }

    public void put3(int key, int value) {
        if (map.containsKey(key)) {
            Node oldPair = map.get(key);
//            delete previous Node from DLL & map
            DLL.remove(oldPair);
            map.remove(key);
        } else if (map.size() == capacity) {
            Node node = DLL.removeLast();
            map.remove(node.key);
        }
//         add new key value pair in map and put that as first node of DLL
        Node newNode = new Node(key, value);
        DLL.addFirst(newNode);
        map.put(key, newNode);
    }
}
