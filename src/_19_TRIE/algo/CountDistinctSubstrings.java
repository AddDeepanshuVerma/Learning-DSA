package _19_TRIE.algo;

public class CountDistinctSubstrings {
    //	In the first test case string = "sds":, the 6 distinct substrings are { "s","d",”sd”,”ds”,”sds”,“”}
    public static int countDistinctSubstrings(String s) {
//        to count distinct substring we will put each substring in Trie
//        and whenever there is a need to create a new node in Trie, a new distinct substring gets spawned

        int ans = 0;
        Trie trie = new Trie();
        for (int i = 0; i < s.length(); i++) {
            ans += trie.insert(s.substring(i));
        }
        return ans;
    }

    static class Node {
        Node[] links = new Node[26];// all lower case character
    }

    static class Trie {
        Node root;
        public Trie() {
            root = new Node();
        }

        public int insert(String word) {
            int count = 0;
            Node temp = root;
            for (char ch : word.toCharArray()) {
                if (temp.links[ch - 'a'] == null) {
                    count++;
                    temp.links[ch - 'a'] = new Node();
                }
                temp = temp.links[ch - 'a'];
            }
            return count;
        }
    }

}