package Contest.Weekly_Contest._445;

public class Q2 {
    public String smallestPalindrome(String s) {
        // there will only be one odd value, find it separately
        char[] arr = s.toCharArray();
        int[] map = new int[26];
        for (char c : arr) {
            map[c - 'a']++;
        }

        boolean oddExists = false;
        int oddChar = -1;
        for (int i = 0; i < map.length; i++) {
            if ((map[i] & 1) == 1) {
                oddExists = true;
                oddChar = i;
                map[i]--;
            }
            map[i] >>= 1; // make all digits half
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            while (map[i]-- > 0) {
                sb.append((char) (i + 'a'));
            }
        }

        String ans = sb.toString();
        if (oddExists) {
            ans += (char) (oddChar + 'a');
        }

        return ans + sb.reverse().toString();
    }

    public String smallestPalindrome2(String s) {
        // there will only be one odd value, find it separately
        boolean oddExists = (s.length() & 1) == 1;
        int[] map = new int[26];
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }

        char oddChar = '0';
        for (int i = 0; i < map.length; i++) {
            if ((map[i] & 1) == 1) {
                oddChar = (char) (i + 'a');
            }
            map[i] >>= 1; // make all digits half
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            while (map[i]-- > 0) {
                sb.append((char) (i + 'a'));
            }
        }

        String ans = sb.toString() + (oddExists ? oddChar : "");
        return ans + sb.reverse().toString();
    }

    public static void main(String[] args) {
        Q2 obj = new Q2();
        String ans = obj.smallestPalindrome("jjejj");
        System.out.println(ans);
    }
}
