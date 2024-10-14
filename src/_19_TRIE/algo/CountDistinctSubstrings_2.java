package _19_TRIE.algo;

public class CountDistinctSubstrings_2 {
    public static int countDistinctSubstrings(String s) {
        int ans = 0;
        Node trie = new Node();
        for (int i = 0; i < s.length(); i++) {
            Node root = trie;
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (root.links[ch - 'a'] == null) {
                    ans++;
                    root.links[ch - 'a'] = new Node();
                }
                root = root.links[ch - 'a'];
            }
        }
        return ans;
    }

    static class Node {
        Node[] links = new Node[26];// all lower case character
    }
}