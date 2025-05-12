package POTD_LEETCODE.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class FindEvenNumbers_2094 {

    // TC : n^3 * log(n^3)
    public static int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue;               // first integer can not start from zero
            for (int j = 0; j < n; j++) {
                if (i == j) continue;                   // can not take same index twice
                for (int k = 0; k < n; k++) {
                    if (j == k || i == k) continue;     // can not take same index twice
                    if ((digits[k] & 1) == 1) continue; // resultant integer would not be even

                    set.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                }
            }
        }

        int[] ans = new int[set.size()];
        int i = 0;
        for (Integer val : set) {
            ans[i++] = val;
        }
        Arrays.sort(ans);
        return ans;
    }


    //================================================================
    // optional approach : range of answer were very low [100, 998]
    // Hence applied reverse engineering where checking each value in range can be made build using given set of digits or not
    private static final List<Integer> list;

    static {
        list = new ArrayList<>();
        for (int i = 100; i <= 998; i += 2) {
            list.add(i);
        }
    }


    public static int[] findEvenNumbers2(int[] digits) {
        int[] map = new int[11];

        for (int digit : digits) {
            map[digit]++;
        }

        List<Integer> temp = new ArrayList<>();
        for (int val : list) {
            if (canBeMade(val, map)) {
                temp.add(val);
            }
        }

        int[] ans = new int[temp.size()];
        int i = 0;
        for (Integer val : temp) {
            ans[i++] = val;
        }
        return ans;
    }

    private static boolean canBeMade(int val, int[] source) {
        int[] map = new int[11];
        while (val > 0) {
            map[val % 10]++;
            val /= 10;
        }

        for (int i = 0; i < 11; i++) {
            if (map[i] > source[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 8, 8, 2};
        int[] ans = findEvenNumbers2(arr);
        System.out.println("ans = " + Arrays.toString(ans));
    }

}