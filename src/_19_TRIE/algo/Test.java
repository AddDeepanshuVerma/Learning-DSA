package _19_TRIE.algo;

public class Test {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("deepanshu");
        System.out.println(trie.search("deepanshus"));
        System.out.println(trie.prefix("deepansh"));

    }
}
