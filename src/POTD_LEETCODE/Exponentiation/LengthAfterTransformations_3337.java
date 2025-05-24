package POTD_LEETCODE.Exponentiation;

import java.util.List;

// This solution is a TLE : We need to apply matrix exponentiation for the optimal solution
// Exponentiation needs to be studied later.
class LengthAfterTransformations_3337 {
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        final int MOD = (int) (1e9 + 7);
        long[] map = new long[26];

        char[] arr = s.toCharArray();
        for (char ch : arr) map[ch - 'a']++;

        while (t-- > 0) {
            long[] temp = new long[26];
            for (int i = 0; i < map.length; i++) {
                if (map[i] > 0) {
                    generateString(i, map[i], temp, nums, MOD);
                }
            }
            map = temp;
            temp = null;
        }

        long count = 0;
        for (long val : map) {
            count = (count + val) % MOD;
        }
        return (int) count;
    }

    private void generateString(int idx, long repeat, long[] temp, List<Integer> nums, int MOD) {
        int nextElements = nums.get(idx);
        StringBuilder sb = new StringBuilder();

        while (nextElements-- > 0) {
            idx = (idx + 1) % 26;
            sb.append((char) (idx + 'a'));
        }

        String str = sb.toString();
        while (repeat-- > 0) {
            for (char ch : str.toCharArray()) {
                temp[ch - 'a'] = (temp[ch - 'a'] + 1) % MOD;
            }
        }

    }
}