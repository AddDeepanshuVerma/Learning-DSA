package Contest.Biweekly_Contest._141;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1 {
    public static void main(String[] args) {
        Q1 obj = new Q1();
//        obj.;
    }

    static int[] dp = new int[1001];

    public int[] minBitwiseArray(List<Integer> nums) {
        Arrays.fill(dp, -2);
        int[] ans = new int[nums.size()];
        int i = 0;
        for (int num : nums) {
            ans[i++] = getSmallest(num);
        }
        return ans;
    }

    private int getSmallest(int num) {
        if (dp[num] != -2) return dp[num];

        int ans = -1;
        for (int i = 0; i < num; i++) {
            if ((i | (i + 1)) == num) {
                ans = i;
                break;
            }
        }
        dp[num] = ans;
        return ans;
    }


}
