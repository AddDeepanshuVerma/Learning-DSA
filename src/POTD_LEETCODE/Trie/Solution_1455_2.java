package POTD_LEETCODE.Trie;

class Solution_1455_2 {
    public static void main(String[] args) {
        Solution_1455_2 obj = new Solution_1455_2();
        System.out.println(obj.isPrefixOfWord("love errichto jonathan dumb", "dumb"));
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        Trie trie = new Trie();
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            trie.insert(split[i], i + 1);
        }
        return trie.searchPrefix(searchWord);
    }

    static class Trie {
        private final Node root;

        public Trie() {
            root = new Node();
        }

        static class Node {
            private int index = Integer.MAX_VALUE;
            private boolean isWord;
            private final Node[] children = new Node[26];

            public boolean contains(char c) {
                return children[c - 'a'] != null;
            }

            public void set(char c, Node newNode, int index) {
                children[c - 'a'] = newNode;
                setIndex(index);
            }

            public Node get(char c) {
                return children[c - 'a'];
            }

            public void setWord() {
                isWord = true;
            }

            public void setIndex(int index) {
                this.index = Math.min(this.index, index);
            }
        }


        public void insert(String str, int index) {
            Node temp = root;
            for (char c : str.toCharArray()) {
                if (!temp.contains(c)) {
                    temp.set(c, new Node(), index);
                }
                temp = temp.get(c);
            }
            temp.setWord();
            temp.setIndex(index);
        }

        public int searchPrefix(String prefix) {
            Node temp = root;
            for (char ch : prefix.toCharArray()) {
                if (!temp.contains(ch)) {
                    return -1;
                }
                temp = temp.get(ch);
            }
            return temp.index;
        }

    }

}