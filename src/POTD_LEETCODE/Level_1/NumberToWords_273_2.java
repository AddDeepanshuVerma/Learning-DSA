package POTD_LEETCODE.Level_1;

import java.util.HashMap;
import java.util.Map;

class NumberToWords_273_2 {
    public static void main(String[] args) {
        int num = 50868;
        NumberToWords_273_2 obj = new NumberToWords_273_2();
        System.out.println(obj.numberToWords(num));
    }

    private final HashMap<Integer, String> below_10 = new HashMap<>(Map.of(0, "", 1, "One", 2, "Two", 3, "Three", 4, "Four", 5, "Five", 6, "Six", 7, "Seven", 8, "Eight", 9, "Nine"));
    private final HashMap<Integer, String> below_20 = new HashMap<>(Map.of(10, "Ten", 11, "Eleven", 12, "Twelve", 13, "Thirteen", 14, "Fourteen", 15, "Fifteen", 16, "Sixteen", 17, "Seventeen", 18, "Eighteen", 19, "Nineteen"));
    private final HashMap<Integer, String> below_100 = new HashMap<>(Map.of(2, "Twenty", 3, "Thirty", 4, "Forty", 5, "Fifty", 6, "Sixty", 7, "Seventy", 8, "Eighty", 9, "Ninety"));

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return solve(num).trim();
    }

    private String solve(int n) {
        if (n < 10)         return below_10.get(n);
        if (n < 20)         return below_20.get(n);
        if (n < 100)        return (below_100.get(n / 10) + " " + solve(n % 10)).trim();
        if (n < 1000)       return solve(n / 100) + " Hundred " + solve(n % 100);
        if (n < 1000000)    return solve(n / 1000) + " Thousand " + solve(n % 1000);
        if (n < 1000000000) return solve(n / 1000000) + " Million " + solve(n % 1000000);
        else                return solve(n / 1000000000) + " Billion " + solve(n % 1000000000);
    }
}