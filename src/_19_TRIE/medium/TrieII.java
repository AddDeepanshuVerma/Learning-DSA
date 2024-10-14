package _19_TRIE.medium;

public class TrieII {
    /*
    Trie(): Initializes the trie object.
    void insert(string word): Inserts the string word into the trie.
    int countWordsEqualTo(string word): Returns the number of instances of the string word in the trie.
    int countWordsStartingWith(string prefix): Returns the number of strings in the trie that have the string prefix as a prefix.
    void erase(string word): Erases the string word from the trie.
    */

    Node root;

    static class Node {
        private final Node[] links = new Node[26];
        private int count;
        private int visited;

        public boolean contains(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        public Node get(char ch) {
            return links[ch - 'a'];
        }

        public int getCount() {
            return count;
        }

        public void increaseCount() {
            count++;
        }

        public void decreaseCount() {
            count--;
        }

        public int getVisited() {
            return visited;
        }

        public void increaseVisited() {
            visited++;
        }

        public void decreaseVisited() {
            visited--;
        }
    }

    public TrieII() {
        root = new Node();
    }

    void insert(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            if (!temp.contains(ch)) {
                temp.put(ch, new Node());
            }
            temp = temp.get(ch);
            temp.increaseVisited();
        }
        temp.increaseCount();
    }

    int countWordsEqualTo(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            if (!temp.contains(ch)) {
                return 0;
            }
            temp = temp.get(ch);
        }
        return temp.getCount();
    }

    int countWordsStartingWith(String prefix) {
        Node temp = root;
        for (char ch : prefix.toCharArray()) {
            if (!temp.contains(ch)) {
                return 0;
            }
            temp = temp.get(ch);
        }
        return temp.getVisited();
    }

    void erase(String word) {
        // expecting that this word was inserted earlier
        Node temp = root;
        for (char ch : word.toCharArray()) {
            if (!temp.contains(ch)) {
                return;
            }
            temp = temp.get(ch);
            temp.decreaseVisited();
        }
        temp.decreaseCount();
    }
}
