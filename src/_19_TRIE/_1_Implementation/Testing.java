package _19_TRIE._1_Implementation;

public class Testing {
    public static void main(String[] args) {
        _3Trie obj1 = new _3Trie();
        obj1.insert("deep");
        System.out.println("Added \"deep\" in the dictionary");
        System.out.println("Contains deepanshu ?    : " + obj1.search("deepanshu"));
        System.out.println("Contains prefix as d ?  : " + obj1.prefix("d"));

        System.out.println("=========");

        _1Trie obj2 = new _1Trie();
        obj2.insert("deep");
        System.out.println("Added \"deep\" in the dictionary");
        System.out.println("Contains deepanshu ?    : " + obj2.search("deepanshu"));
        System.out.println("Contains prefix as d ?  : " + obj2.prefix("d"));

        System.out.println("=========");

        _2TrieWithMap obj3 = new _2TrieWithMap();
        obj3.insert("deep");
        System.out.println("Added \"deep\" in the dictionary");
        System.out.println("Contains deepanshu ?    : " + obj3.search("deepanshu"));
        System.out.println("Contains prefix as d ?  : " + obj3.prefix("d"));


    }
}
