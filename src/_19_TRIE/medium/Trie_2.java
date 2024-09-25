package _19_TRIE.medium;

public class Trie_2 {
    Node root;

    static class Node {
        boolean isWord;
        Node[] childs = new Node[26];
    }

    public Trie_2() {
        root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            if (temp.childs[ch - 'a'] == null) {
                temp.childs[ch - 'a'] = new Node();
            }
            temp = temp.childs[ch - 'a'];
        }
        temp.isWord = true;
    }

    public boolean search(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            if (temp.childs[ch - 'a'] == null) {
                return false;
            }
            temp = temp.childs[ch - 'a'];
        }
        return temp.isWord;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for (char ch : prefix.toCharArray()) {
            if (temp.childs[ch - 'a'] == null) {
                return false;
            }
            temp = temp.childs[ch - 'a'];
        }
        return true;
    }
}