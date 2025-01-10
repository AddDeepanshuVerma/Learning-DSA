package POTD_LEETCODE.Trie;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class CountPrefixSuffixPairs_3045 {
    public static void main(String[] args) {
        String[] words = {"a", "aba", "ababa", "aa"};
        long ans = countPrefixSuffixPairs(words);
        System.out.println("ans = " + ans);
        printTrie(root, 0);
    }

    public static long countPrefixSuffixPairs(String[] words) {
        long ans = 0;
        root = new TrieNode();
        for (final String word : words)
            ans += insert(word);
        return ans;
    }

    private static TrieNode root;

    static class TrieNode {
        Map<Integer, TrieNode> children = new HashMap<>();
        int count = 0;
    }

    public static int insert(final String word) {
        final int n = word.length();
        int count = 0;
        TrieNode node = root;
        for (int i = 0; i < n; ++i) {
            final char prefix = word.charAt(i);
            final char suffix = word.charAt(n - 1 - i);
            final int key = (prefix - 'a') * 26 + (suffix - 'a');
            node.children.putIfAbsent(key, new TrieNode());
            node = node.children.get(key);
            count += node.count;
        }
        ++node.count;
        return count;
    }

    public static void printTrie(TrieNode root, int offset) {
        for (var item : root.children.entrySet()) {
            IntStream.range(0, offset).forEach(n -> System.out.print(" "));
            System.out.print(item.getKey() + "\n");
            printTrie(item.getValue(), offset + 3);
        }
    }

}