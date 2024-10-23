package Contest.Weekly_Contest._420;

public class Q2_3 {
    public static void main(String[] args) {
        Q2_3 obj = new Q2_3();
        System.out.println(obj.numberOfSubstrings("abcde", 1));
    }

    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int result = 0;
        int[] freq;
        for (int i = 0; i < n; i++) {
            freq = new int[26];
            inner:
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++; //
                for (int f : freq) {
                    if (f >= k) {
                        result++;
                        continue inner;
                    }
                }
            }
        }

        return result;
    }

    public int numberOfSubstrings2(String s, int k) {
        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                boolean valid = false;
                for (int f : freq) {
                    if (f >= k) {
                        valid = true;
                        break;
                    }
                }
                if (valid) result++;
            }
        }

        return result;
    }
}
