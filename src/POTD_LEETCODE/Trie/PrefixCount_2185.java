package POTD_LEETCODE.Trie;

import java.util.Arrays;
import java.util.HashMap;

class PrefixCount_2185 {

    // brute force approach :
    public int prefixCount1(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;

    }

    // single liner approach :
    public int prefixCount2(String[] words, String pref) {
        return (int) Arrays.stream(words).filter(item -> item.startsWith(pref)).count();
    }

    // using Trie to solve :
    public int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();
        for (String word : words) trie.insert(word);

        return trie.prefix(pref);
    }

    static class Node {
        HashMap<Character, Node> children = new HashMap<>();
        int passedCount;
        boolean isWord;
    }

    static class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node temp = root;
            for (char ch : word.toCharArray()) {
                temp = temp.children.computeIfAbsent(ch, v -> new Node());
                temp.passedCount++;
            }
            temp.isWord = true;
        }

        public int prefix(String prefix) {
            Node temp = root;
            for (char ch : prefix.toCharArray()) {
                if (!temp.children.containsKey(ch)) return 0;
                temp = temp.children.get(ch);
            }
            return temp.passedCount;
        }
    }
}