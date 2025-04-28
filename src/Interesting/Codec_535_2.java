package Interesting;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Codec_535_2 {
    private final HashMap<String, String> idVsLongUrlDb;
    private final AtomicInteger integer;

    public Codec_535_2() {
        this.idVsLongUrlDb = new HashMap<>();
        integer = new AtomicInteger(0);
    }

    public String encode(String longUrl) {
        int id = integer.incrementAndGet();
        String encodedString = encodeNumber(id);
        idVsLongUrlDb.put(encodedString, longUrl);
        return encodedString;
    }

    private String encodeNumber(int i) {
        StringBuilder str = new StringBuilder();
        while (i > 0) {
            int a = i % 64;
            str.append((char) (('a' - 1) + a));
            i = i / 64;
        }
        return str.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return idVsLongUrlDb.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));