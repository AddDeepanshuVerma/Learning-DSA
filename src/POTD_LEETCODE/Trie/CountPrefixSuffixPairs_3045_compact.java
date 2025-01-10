package POTD_LEETCODE.Trie;

import java.util.HashMap;

class CountPrefixSuffixPairs_3045_compact {
    static class TrieNode {
        HashMap<Integer, TrieNode> children = new HashMap<>();
        int count = 0;
    }

    public long countPrefixSuffixPairs(String[] words) {
        TrieNode root = new TrieNode();
        long res = 0;
        /*
         * here we are inserting each word from start and while inserting if we find we have encountered a previous added word,
         * we are adding that in result as we need to check both prefix & suffix hence storing a rolling hash in Trie as key
         * OR we can also use Pair<char, char> which will store first and last char (source : Lee from solution tab & NeetCode from YouTube)
         * */
        for (String word : words) {
            TrieNode x = root;
            for (int i = 0, n = word.length(); i < n; ++i) {
                int key = word.charAt(i) * 128 + word.charAt(word.length() - i - 1);
                x = x.children.computeIfAbsent(key, v -> new TrieNode());
                res += x.count;
            }
            x.count++;
        }
        return res;
    }

}