package Interesting;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Codec_535 {
    private static final HashMap<String, String> cache = new HashMap<>();
    private static final String alias_hash = "http://xyz.com/";
    private static final AtomicInteger uniqueId = new AtomicInteger(0);

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = idToShortURL(uniqueId.incrementAndGet());
        cache.put(shortUrl, longUrl);
        return alias_hash + shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String temp = shortUrl.substring(15);
        return cache.get(temp);
    }

    public void printCache() {
        System.out.println("alias_hash = " + alias_hash);
        System.out.println("cache.size() = " + cache.size());
        System.out.println(cache);
    }

    private String idToShortURL(int n) {
        // Map to store 62 possible characters
        char[] map = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuilder shortURL = new StringBuilder();

        // Convert given integer id to a base 62 number
        while (n > 0) {
            shortURL.append(map[(n - 1) % 62]);
            n = n / 62;
        }
        // Reverse shortURL to complete base conversion
        shortURL.reverse();
        return shortURL.toString();
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));