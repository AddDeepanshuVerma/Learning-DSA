package _19_TRIE.medium;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    Node root;
    static class Node {
        boolean isWord;
        Map<Character, Node> childs = new HashMap<>();
    }

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            if (!temp.childs.containsKey(ch)) {
                temp.childs.put(ch, new Node());
            }
            temp = temp.childs.get(ch);
        }
        temp.isWord = true;
    }
    
    public boolean search(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            if (!temp.childs.containsKey(ch)) {
                return false;
            }
            temp = temp.childs.get(ch);
        }
        return temp.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;
        for (char ch : prefix.toCharArray()) {
            if (!temp.childs.containsKey(ch)) {
                return false;
            }
            temp = temp.childs.get(ch);
        }
        return true;
    }
}