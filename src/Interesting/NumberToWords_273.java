package Interesting;

import java.util.HashMap;
import java.util.Map;

class NumberToWords_273 {
    private final HashMap<Long, String> below_10 = new HashMap<>(Map.of(0L, "", 1L, "One", 2L, "Two", 3L, "Three", 4L, "Four", 5L, "Five", 6L, "Six", 7L, "Seven", 8L, "Eight", 9L, "Nine"));
    private final HashMap<Long, String> below_20 = new HashMap<>(Map.of(10L, "Ten", 11L, "Eleven", 12L, "Twelve", 13L, "Thirteen", 14L, "Fourteen", 15L, "Fifteen", 16L, "Sixteen", 17L, "Seventeen", 18L, "Eighteen", 19L, "Nineteen"));
    private final HashMap<Long, String> below_100 = new HashMap<>(Map.of(2L, "Twenty", 3L, "Thirty", 4L, "Forty", 5L, "Fifty", 6L, "Sixty", 7L, "Seventy", 8L, "Eighty", 9L, "Ninety"));

    public static void main(String[] args) {
        long num = 1000000000000000000L;
        NumberToWords_273 obj = new NumberToWords_273();
        System.out.println(obj.numberToWords(num));
    }

    public String numberToWords(long num) {
        if (num == 0) return "Zero";
        return solve(num);
    }

    private String solve(long n) {
        if (n < 10) return below_10.get(n);
        if (n < 20) return below_20.get(n);
        if (n < 100) return below_100.get(n / 10) + ((n % 10 != 0) ? " " + solve(n % 10) : "");
        if (n < 1000) return solve(n / 100) + " Hundred" + ((n % 100 != 0) ? " " + solve(n % 100) : "");
        if (n < 1000000) return solve(n / 1000) + " Thousand" + ((n % 1000 != 0) ? " " + solve(n % 1000) : "");
        if (n < 1000000000) return solve(n / 1000000) + " Million" + ((n % 1000000 != 0) ? " " + solve(n % 1000000) : "");
        if (n < 1000000000000L) return solve(n / 1000000000) + " Billion" + ((n % 1000000000 != 0) ? " " + solve(n % 1000000000) : "");
        if (n < 1000000000000000L) return solve(n / 1000000000000L) + " Trillion" + ((n % 1000000000000L != 0) ? " " + solve(n % 1000000000000L) : "");
        if (n < 1000000000000000000L) return solve(n / 1000000000000000L) + " Quadrillion" + ((n % 1000000000000000L != 0) ? " " + solve(n % 1000000000000000L) : "");
        return "Ab kya Quintillion bhi chahiye !!!";
    }
}