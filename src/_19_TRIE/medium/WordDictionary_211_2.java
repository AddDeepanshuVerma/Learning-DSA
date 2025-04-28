package _19_TRIE.medium;

class WordDictionary_211_2 {
    Node knot;

    static class Node {
        private boolean isWord;
        final private Node[] children = new Node[26];

        public boolean contains(char ch) {
            return children[ch - 'a'] != null;
        }

        public void put(char ch, Node node) {
            children[ch - 'a'] = node;
        }

        public Node get(char ch) {
            return children[ch - 'a'];
        }

        public Node get(int index) {
            return children[index];
        }

        public void setWord(boolean flag) {
            isWord = flag;
        }

        public boolean getWord() {
            return isWord;
        }


    }

    public WordDictionary_211_2() {
        knot = new Node();
    }

    public void addWord(String word) {
        Node temp = knot;
        for (char ch : word.toCharArray()) {
            if (!temp.contains(ch)) {
                temp.put(ch, new Node());
            }
            temp = temp.get(ch);
        }
        temp.setWord(true);
    }

    public boolean search(String word) {
        return solve(0, word.toCharArray(), knot);
    }

    private boolean solve(int index, char[] word, Node temp) {
        if (index == word.length) {
            return temp.getWord();
        }
        if (word[index] != '.') {
            temp = temp.get(word[index]);
            return temp != null && solve(index + 1, word, temp);
        }
        for (int idx = 0; idx < 26; idx++) {
            if (temp.get(idx) != null && solve(index + 1, word, temp.get(idx)))
                return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */