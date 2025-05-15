package POTD_LEETCODE.String;

class LengthAfterTransformations_3335_2 {

    public static int lengthAfterTransformations(String s, int t) {
        final int MOD = (int) (1e9 + 7);
        int[] map = new int[26];
        for (char ch : s.toCharArray()) map[ch - 'a']++;

        while (t-- > 0) {
            int temp = map[25] % MOD;
            for (int i = 25; i > 0; i--) {
                map[i] = map[i - 1] % MOD;
            }
            map[0] = temp;
            map[1] = (map[1] + temp) % MOD;
        }

        int count = 0;
        for (int val : map) {
            count = (count + val) % MOD;
        }
        return (int) count;
    }

    public static void main(String[] args) {
        int count = lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 7517);
        System.out.println("count = " + count);
    }
}