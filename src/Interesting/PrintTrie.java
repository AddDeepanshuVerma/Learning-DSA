package Interesting;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class PrintTrie {
    public static void main(String[] args) {
        PrintTrie trie = new PrintTrie();
        String[] arr = {"abcd", "abno", "amno", "bcde", "cdef", "defg"};
        for (String st : arr) {
            trie.insert(st);
        }
        printTrie(trie.root, 0);
    }

    private static void printTrie(Node root, int offset) {
        for (var item : root.childs.entrySet()) {
            IntStream.range(0, offset).forEach(n -> System.out.print(" "));
            System.out.print(item.getKey() + "\n");
            printTrie(item.getValue(), offset + 3);
        }
    }

    Node root;

    static class Node {
        boolean isWord;
        Map<Character, Node> childs = new HashMap<>();
    }

    public PrintTrie() {
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