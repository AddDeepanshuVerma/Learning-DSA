package Contest.Biweekly_Contest._141;

import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        Q2 obj = new Q2();
//        obj.;
    }


    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        int i = 0;
        for (int num : nums) {
            ans[i++] = getMinValue(num);
        }
        return ans;
    }

    private int getMinValue(int num) {
        int ans = -1;
        for (int i = 31; i >= 0; i--) {
            if (((num >> i) & 1) == 1) {
                // this bit is 1, now change this bit to 0 and check if update number is valid or not
                int temp = (1 << i) ^ num;
                if (isValid(temp, num)) {
                    return temp;
                }
            }
        }
        return ans;
    }

    private boolean isValid(int temp, int num) {
        return (temp | (temp + 1)) == num;
    }

}
