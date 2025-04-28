package POTD_LEETCODE.Trie;

import jdk.jfr.Description;

import java.util.*;

@Description("Knew it will be demise, still chose to code with two Tries.")
class CountPrefixSuffixPairs_3045_TLE {
    public static void main(String[] args) {
        String[] arr = {"pa", "papa", "ma", "mama"};
//        String[] arr = {"abab","ab"};
//        String[] arr = {"a","aba","ababa","aa"};
        long ans = countPrefixSuffixPairs(arr);
        System.out.println(ans);
    }

    public static long countPrefixSuffixPairs(String[] words) {
        Trie forward = new Trie(), reverse = new Trie();
        for (int i = 0; i < words.length; i++) {
            forward.insert(words[i], i);
            reverse.insert(new StringBuilder(words[i]).reverse().toString(), i);
        }
        /*
        now we; need to find all the indexes where this String is present in
         forward and reverse trie, after which we need to find number of common
         indexed bw them which are greater than that searched String index
         */
        long count = 0;
        for (int i = 0; i < words.length; i++) {
            List<Integer> frd = forward.search(words[i]);
            List<Integer> rev = reverse.search(new StringBuilder(words[i]).reverse().toString());
            count += findCommon(frd, rev, i);
        }
        return count;
    }

    private static long findCommon(List<Integer> frd, List<Integer> rev, int val) {
        // to find common values bw both lists which are greater then val
        Set<Integer> set = new HashSet<>();
        for (Integer item : frd) {
            if (item > val) set.add(item);
        }
        long count = 0;
        for (Integer item : rev) {
            if (item > val && set.contains(item)) {
                count++;
            }
        }
        return count;
    }

    static class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        static class Node {
            HashMap<Character, Node> children = new HashMap<>();
            List<Integer> passedIndexes = new ArrayList<>();
            boolean isWord;
        }

        public List<Integer> search(String word) {
            Node temp = root;
            for (char ch : word.toCharArray()) {
                if (!temp.children.containsKey(ch)) {
                    return Collections.emptyList();
                }
                temp = temp.children.get(ch);
            }
            return temp.passedIndexes;
        }

        public void insert(String string, int index) {
            Node temp = root;
            for (char ch : string.toCharArray()) {
                temp = temp.children.computeIfAbsent(ch, v -> new Node());
                temp.passedIndexes.add(index);
            }
            temp.isWord = true;
        }

    }
}