package Contest.Weekly_Contest._421;

public class Q2_2 {
    public static void main(String[] args) {

    }
    public int lengthAfterTransformations(String s, int t) {
        int MOD = 1000000007;
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (int i = 0; i < t; i++) {
            int[] newCount = new int[26];

            for (int j = 0; j < 25; j++) {
                newCount[j + 1] = count[j];
            }

            newCount[0] = count[25];
            newCount[1] = (newCount[1] + count[25]) % MOD;

            count = newCount;
        }

        // Sum up the transformed counts
        long result = 0;
        for (int num : count) {
            result = (result + num) % MOD;
        }
        return (int) result;
    }
}
