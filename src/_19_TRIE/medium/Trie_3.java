package _19_TRIE.medium;

public class Trie_3 {
    final Node root;

    static class Node {
        private boolean isWord;
        private final Node[] childs = new Node[26];

        public boolean contains(char ch) {
            return !(childs[ch - 'a'] == null);
        }

        public void set(char ch, Node node) {
            childs[ch - 'a'] = node;
        }

        public Node get(char ch) {
            return childs[ch - 'a'];
        }

        public void setEnd() {
            isWord = true;
        }

        public boolean isEnd() {
            return isWord;
        }

    }

    public Trie_3() {
        root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            if (!temp.contains(ch)) {
                temp.set(ch, new Node());
            }
            temp = temp.get(ch);
        }
        temp.setEnd();
    }

    public boolean search(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            if (!temp.contains(ch)) {
                return false;
            }
            temp = temp.get(ch);
        }
        return temp.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for (char ch : prefix.toCharArray()) {
            if (!temp.contains(ch)) {
                return false;
            }
            temp = temp.get(ch);
        }
        return true;
    }
}