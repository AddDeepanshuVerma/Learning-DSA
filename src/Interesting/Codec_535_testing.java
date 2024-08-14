package Interesting;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Codec_535_testing {
    private static final Codec_535_2 obj = new Codec_535_2();
    private static final Codec_535 obj2 = new Codec_535();
    private static final Set<Integer> set = new HashSet<Integer>();

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            int value = new Random().nextInt(100000);
            set.add(value);
            String longUrl = "https://leetcode.com/" + value;
            System.out.println("longUrl = " + longUrl);
            ourCode(longUrl);
//            CopiedCode_1(longUrl);
        }
        System.out.println(set.size());
        obj2.printCache();
    }

    public static void CopiedCode_1(String longUrl) {
        String shortUrl = obj.encode(longUrl);
        System.out.println("encoded shortUrl = " + shortUrl);
    }

    public static void ourCode(String longUrl) {
        String shortUrl = obj2.encode(longUrl);
        System.out.println("encoded shortUrl = " + shortUrl);
    }
}
