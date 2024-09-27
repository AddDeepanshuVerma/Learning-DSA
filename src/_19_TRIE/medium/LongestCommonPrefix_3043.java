package _19_TRIE.medium;

class LongestCommonPrefix_3043 {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        // insert all elements of one of the array in Trie
        Trie trie = new Trie();
        for (int num : arr1) {
            trie.insert(num);
        }

        // now get max prefix count of every number of arr2 out of trie to find the longest
        int longest = 0; // if none found, 0 is the answer
        for (int num : arr2) {
            longest = Math.max(longest, trie.maxPrefixCount(num));
        }
        return longest;
    }

    static class Node {
        Node[] children = new Node[10];  // from 0 till 9
    }

    static class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        public void insert(int num) {
            String word = String.valueOf(num);

            Node temp = root;
            for (char ch : word.toCharArray()) {
                if (temp.children[ch - '0'] == null) {
                    temp.children[ch - '0'] = new Node();
                }
                temp = temp.children[ch - '0'];
            }
        }

        public int maxPrefixCount(int num) {
            String word = String.valueOf(num);

            int count = 0;
            Node temp = root;
            for (char ch : word.toCharArray()) {
                if (temp.children[ch - '0'] == null) {
                    return count;
                }
                temp = temp.children[ch - '0'];
                count++;
            }
            return count;
        }
    }

}