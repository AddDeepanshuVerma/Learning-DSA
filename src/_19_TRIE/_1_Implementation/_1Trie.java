package _19_TRIE._1_Implementation;

public class _1Trie {
    private final Node root;

    public _1Trie() {
        root = new Node();
    }

    static class Node {
        boolean flag;
        Node[] children = new Node[26];
    }

    public void insert(String data) {
        Node temp = root;
        for (char ch : data.toCharArray()) {
            if (temp.children[ch - 'a'] == null) {
                temp.children[ch - 'a'] = new Node();
            }
            temp = temp.children[ch - 'a'];
        }
        temp.flag = true;
    }

    public boolean search(String data) {
        Node temp = root;
        for (char ch : data.toCharArray()) {
            if (temp.children[ch - 'a'] == null) {
                return false;
            }
            temp = temp.children[ch - 'a'];
        }
        return temp.flag;
    }

    public boolean prefix(String data) {
        Node temp = root;
        for (char ch : data.toCharArray()) {
            if (temp.children[ch - 'a'] == null) {
                return false;
            }
            temp = temp.children[ch - 'a'];
        }
        return true;
    }

}
