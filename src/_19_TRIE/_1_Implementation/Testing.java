package _19_TRIE._1_Implementation;

public class Testing {
    public static void main(String[] args) {
        Trie obj1 = new Trie();
        obj1.insert("deep");
        System.out.println("Added \"deep\" in the dictionary");
        System.out.println("Contains deepanshu ?    : " + obj1.search("deepanshu"));
        System.out.println("Contains prefix as d ?  : " + obj1.prefix("d"));

        System.out.println("=========");

        Try obj2 = new Try();
        obj2.insert("deep");
        System.out.println("Added \"deep\" in the dictionary");
        System.out.println("Contains deepanshu ?    : " + obj2.search("deepanshu"));
        System.out.println("Contains prefix as d ?  : " + obj2.prefix("d"));

        System.out.println("=========");

        TryWithMap obj3 = new TryWithMap();
        obj3.insert("deep");
        System.out.println("Added \"deep\" in the dictionary");
        System.out.println("Contains deepanshu ?    : " + obj3.search("deepanshu"));
        System.out.println("Contains prefix as d ?  : " + obj3.prefix("d"));


    }
}
