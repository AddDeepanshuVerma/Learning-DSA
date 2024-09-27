package _19_TRIE.medium;

import java.util.Arrays;

class MinExtraChar_2707 {
    static int[] dp;


    private static class Node {
        private boolean isWord;
        private final Node[] links = new Node[26];

        public boolean contains(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        public Node get(char ch) {
            return links[ch - 'a'];
        }

        public void setIsWord(boolean b) {
            isWord = b;
        }

        public boolean getIsWord() {
            return isWord;
        }

    }

    private static class Trie {
        static Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node temp = root;
            for (char ch : word.toCharArray()) {
                if (!temp.contains(ch)) {
                    temp.put(ch, new Node());
                }
                temp = temp.get(ch);
            }
            temp.setIsWord(true);
        }

        public boolean searchWord(String word) {
            Node temp = root;
            for (char ch : word.toCharArray()) {
                if (!temp.contains(ch)) {
                    return false;
                }
                temp = temp.get(ch);
            }
            return temp.getIsWord();
        }
    }


    public static int minExtraChar(String s, String[] dictionary) {
        Trie node = new Trie();
        for (String string : dictionary) node.insert(string);

        dp = new int[51];
        Arrays.fill(dp, -1);

        int index = 0;
        return solve(index, s.toCharArray(), node, dp);
    }

    private static int solve(int index, char[] arr, Trie node, int[] dp) {
        if (index == arr.length) return 0;

        if (dp[index] != -1) return dp[index];

        int ans = arr.length;
        String subStr = "";
        for (int i = index; i < arr.length; i++) {
            subStr += arr[i];
            int count = (node.searchWord(subStr) ? 0 : subStr.length()) + solve(i + 1, arr, node, dp);
            ans = Math.min(count, ans);
        }
        return dp[index] = ans;
    }
}