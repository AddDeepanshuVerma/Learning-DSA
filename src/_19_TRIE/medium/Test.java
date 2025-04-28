package _19_TRIE.medium;

public class Test {
    public static void main(String[] args) {
        /*Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));        // return True
        System.out.println(trie.search("app"));          // return False
        System.out.println(trie.startsWith("app"));           // return True
        trie.insert("app");
        System.out.println(trie.search("app"));        // return True*/

        System.out.println("==============");

        TrieII trieII = new TrieII();
        trieII.insert("apple");                                     // Inserts "apple".
        trieII.insert("apple");                                     // Inserts another "apple".
        System.out.println(trieII.countWordsEqualTo("apple"));            // There are two instances of "apple" so return 2.
        System.out.println(trieII.countWordsStartingWith("app"));   // "app" is a prefix of "apple" so return 2.
        trieII.erase("apple");                                      // Erases one "apple".
        System.out.println(trieII.countWordsEqualTo("apple"));            // Now there is only one instance of "apple" so return 1.
        System.out.println(trieII.countWordsStartingWith("app"));   // return 1
        trieII.erase("apple");                                      // Erases "apple". Now the trie is empty.
        System.out.println(trieII.countWordsStartingWith("app"));   // return 0


    }
}
