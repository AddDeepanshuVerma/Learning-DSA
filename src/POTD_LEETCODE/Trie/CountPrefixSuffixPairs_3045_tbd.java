package POTD_LEETCODE.Trie;

import java.util.HashMap;

class CountPrefixSuffixPairs_3045_tbd {
    static class Node {
        HashMap<Pair<Character, Character>, Node> children = new HashMap<>();
        int count = 0;
    }

    public long countPrefixSuffixPairs(String[] words) {
        Node root = new Node();
        long res = 0;
        for (String word : words) {
            Node x = root;
            for (int i = 0, n = word.length(); i < n; ++i) {
                var key = new Pair<>(word.charAt(i), word.charAt(n - i - 1));
                x = x.children.computeIfAbsent(key, v -> new Node());
                res += x.count;
            }
            x.count++;
        }
        return res;
    }

    record Pair<K, V>(K first, V second) {
    }

}