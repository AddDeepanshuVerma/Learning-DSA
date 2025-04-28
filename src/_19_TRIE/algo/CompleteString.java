package _19_TRIE.algo;

import jdk.jfr.Description;

@Description("https://www.naukri.com/code360/problems/complete-string_2687860?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos" +
        " Striver : https://www.youtube.com/watch?v=AWnBa91lThI&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=3&ab_channel=takeUforwards")
public class CompleteString {
    // A String of given array is called Complete String if all possible prefixes of this String is a word available in given array
    public static void main(String[] args) {
        String[] arr = {"n", "ni", "nin", "ninj", "ninja", "ninga"};
        String ans = solve(arr);
        System.out.println("ans = " + ans);
    }

    private static String solve(String[] arr) {
        // first insert all available String of array in the trie
        Trie trie = new Trie();
        for (String s : arr) trie.insert(s);

        // again go through the loop and for each string check all prefixes are word or not
        String ans = "";
        for (String str : arr) {
            if (trie.checkAllPrefixExists(str)) {
                if (ans.length() < str.length()) {
                    ans = str;
                } else if (ans.length() == str.length()) {
                    ans = ans.compareTo(str) < 0 ? str : ans;
                }
            }
        }

        return ans.isEmpty() ? "None" : ans;
    }

    static class Node {

        private boolean isWord;
        private final Node[] links = new Node[26];

        public void setWord(boolean word) {
            isWord = word;
        }

        public boolean getWord() {
            return isWord;
        }

        public boolean contains(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        public Node get(char ch) {
            return links[ch - 'a'];
        }

    }

    static class Trie {

        Node root;

        public Trie() {
            root = new Node();
        }

        public boolean checkAllPrefixExists(String data) {
            Node temp = root;
            boolean flag = true;
            for (char ch : data.toCharArray()) {
//                if (!temp.contains(ch) || !temp.get(ch).getWord()) return false;
//                temp = temp.get(ch);
                if (temp.contains(ch)) {
                    temp = temp.get(ch);
                    if (!temp.getWord()) return false;
                } else {
                    return false;
                }
            }
//            return temp.getWord(); // no need to check this
            return true;// this string will definitely be a word as the same complete String was added earlier
        }

        public void insert(String data) {
            Node temp = root;
            for (char ch : data.toCharArray()) {
                if (!temp.contains(ch)) {
                    temp.put(ch, new Node());
                }
                temp = temp.get(ch);
            }
            temp.setWord(true);
        }

        public boolean search(String word) {
            Node temp = root;
            for (char ch : word.toCharArray()) {
                if (!temp.contains(ch)) {
                    return false;
                }
                temp = temp.get(ch);
            }
            return temp.getWord();
        }

    }

}
