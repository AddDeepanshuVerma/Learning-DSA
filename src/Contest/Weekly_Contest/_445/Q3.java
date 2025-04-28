package Contest.Weekly_Contest._445;

public class Q3 {
    public String smallestPalindrome(String s, int k) {
        boolean oddExists = (s.length() & 1) == 1;
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }

        int oddChar = -1;
        for (int i = 0; i < map.length; i++) {
            if ((map[i] & 1) == 1) oddChar = i;
            map[i] >>= 1; // make all digits half
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            while (map[i]-- > 0) {
                sb.append((char) (i + 'a'));
            }
        }
        String ans = sb.toString();
        // now we need to find the kth anagram of this ans string in lexicographically order
        // ans simply add that revers in it back

        return null;
    }

}
