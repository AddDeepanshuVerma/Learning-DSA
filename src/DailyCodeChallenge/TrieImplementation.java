package DailyCodeChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TrieImplementation {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("cat","bat","rat");
        String st = "the cattle was rattled by the battery";
        String s = replaceWords(list, st);
        System.out.println(s);
    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        // Insert all dictionary words into the Trie with their respective indices.
        for (int i = 0; i < dictionary.size(); i++) {
            trie.insert(dictionary.get(i), i);
        }

        // Split the sentence into words.
        String[] words = sentence.split("\\s+");
        // Prepare a list to store the sentence after replacements.
        List<String> modifiedSentence = new ArrayList<>();
        for (String word : words) {
            // For each word, search the Trie for the shortest root's index.
            int index = trie.search(word);
            // If a root is found, replace the word with the root; otherwise, keep the word as is.
            modifiedSentence.add(index == -1 ? word : dictionary.get(index));
        }
        // Join the modified words into a single string, separated by spaces.
        return String.join(" ", modifiedSentence);
    }

    static class Trie {
        // Trie contains 26 children for each possible lowercase letter.
        private Trie[] children = new Trie[26];
        // 'ref' is used to store the index of the word in the dictionary.
        private int wordIndex = -1;

        // Method to insert a word and its index into the Trie.
        public void insert(String word, int index) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                int charIndex = c - 'a'; // Calculate the index of the character.
                if (node.children[charIndex] == null) {
                    // If there's no child Trie node for this character, create it.
                    node.children[charIndex] = new Trie();
                }
                node = node.children[charIndex];
            }
            node.wordIndex = index; // Store the index of the word at the last node.
        }

        // Method to search for the index of the shortest root in the Trie that is a prefix of the word.
        public int search(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                int charIndex = c - 'a'; // Calculate the index of the character.
                // If there's no child Trie node for this character, return -1.
                if (node.children[charIndex] == null) {
                    return -1;
                }
                node = node.children[charIndex];
                // At each node, check if it's the end of a word in the dictionary.
                if (node.wordIndex != -1) {
                    return node.wordIndex; // Return the stored index if we found a word.
                }
            }
            return -1; // If no word is found or the complete word must be returned.
        }
    }
}