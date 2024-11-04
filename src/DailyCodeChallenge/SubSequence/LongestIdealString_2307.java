package DailyCodeChallenge.SubSequence;

import java.util.Arrays;

class LongestIdealString_2307 {
    public static void main(String[] args) {
        LongestIdealString_2307 obj = new LongestIdealString_2307();
        System.out.println(obj.longestIdealString("pvjcci", 4));
    }

    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[] res = new int[n];

        Arrays.fill(res, 1);
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                char pre = s.charAt(j);
                char curr = s.charAt(i);
                if (Math.abs(curr - pre) <= k) {
                    res[i] = Math.max(res[i], 1 + res[j]);
                    ans = Math.max(ans, res[i]);
                }
            }
        }
        System.out.println("res = " + Arrays.toString(res));
        return ans;
    }
}