package _19_TRIE.algo;

public class Trie {
    private final Node root;

    public void insert(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            if (!temp.contains(ch)) {
                temp.put(ch, new Node());
            }
            temp = temp.get(ch);
        }
        temp.setWord(true);
    }

    public boolean search(String search) {
        Node temp = root;
        for (char ch : search.toCharArray()) {
            if (!temp.contains(ch)) {
                return false;
            }
            temp = temp.get(ch);
        }
        return temp.getWord();
    }

    public boolean prefix(String prefix) {
        Node temp = root;
        for (char ch : prefix.toCharArray()) {
            if (!temp.contains(ch)) {
                return false;
            }
            temp = temp.get(ch);
        }
        return true;
    }

    static class Node {
        private boolean isWord;
        Node[] links = new Node[26];

        public boolean contains(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        public Node get(char ch) {
            return links[ch - 'a'];
        }

        public void setWord(boolean word) {
            isWord = word;
        }

        public boolean getWord() {
            return isWord;
        }
    }

    public Trie() {
        root = new Node();
    }


}
