package _19_TRIE._1_Implementation;

import java.util.HashMap;
import java.util.Map;

public class TryWithMap {
    final Node root;

    public TryWithMap() {
        root = new Node();
    }

    static class Node {
        boolean isEnd;
        final Map<Character, Node> children = new HashMap<>();
    }

    public void insert(String data) {
        Node temp = root;
        for (char ch : data.toCharArray()) {
            if (!temp.children.containsKey(ch)) {
                temp.children.put(ch, new Node());
            }
            temp = temp.children.get(ch);
        }
        temp.isEnd = true;
    }

    public boolean search(String data) {
        Node temp = root;
        for (char ch : data.toCharArray()) {
            if (!temp.children.containsKey(ch)) {
                return false;
            }
            temp = temp.children.get(ch);
        }
        return temp.isEnd;
    }

    public boolean prefix(String data) {
        Node temp = root;
        for (char ch : data.toCharArray()) {
            if (!temp.children.containsKey(ch)) {
                return false;
            }
            temp = temp.children.get(ch);
        }
        return true;
    }
}
