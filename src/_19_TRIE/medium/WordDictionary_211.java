package _19_TRIE.medium;

class WordDictionary_211 {
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


    public WordDictionary_211() {
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
    
    public boolean search2(String word) {
        Node temp = knot;
        for (char ch : word.toCharArray()) {
            if (!temp.contains(ch)) {
                return false;
            }
            temp = temp.get(ch);
        }
        return temp.getWord();
    }

    public boolean search(String word) {
        return solve(0, word, knot);
    }

    private boolean solve(int index, String word, Node temp) {
        if (index == word.length()) {
            return temp.getWord();
        }
        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                if (temp.get(i) != null && solve(index + 1, word, temp.get(i))) {
                    return true;
                }
            }
        } else {
            temp = temp.get(word.charAt(index));
            return temp == null ? false : solve(index + 1, word, temp);
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