package _19_TRIE._1_Implementation;

public class Trie {
    private final Node root;

    public Trie() {
        root = new Node();
    }

    static class Node {
        private boolean flag;
        private final Node[] links = new Node[26];

        public Node() {
        }

        public boolean containsKey(char ch) {
            return !(links[ch - 'a'] == null);
        }

        public void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        public Node get(char ch) {
            return links[ch - 'a'];
        }

        public void setEnd() {
            flag = true;
        }

        public boolean isEnd() {
            return flag;
        }
    }

    public void insert(String data) {
        Node node = root;
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            // if it does not contain a node at this character position then create one
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String data) {
        Node node = root;
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        // if we reached till end char of our input data then is our node marked at as END or NOT
        return node.isEnd();
    }

    public boolean prefix(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        //no need to check if it was end or not; it was available as prefix
        return true;
    }

}
