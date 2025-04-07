package POTD_LEETCODE.z_TBD;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Description("Simple recursion :: TLE")
class LargestDivisibleSubset_368_2 {
    static ArrayList<Integer> ans;

    static void dfs(int idx, int prev, ArrayList<Integer> curr, int[] nums) {
        if (idx >= nums.length) {
            if (curr.size() > ans.size()) {
                ans = new ArrayList<>(curr);
            }
            return;
        }

        dfs(idx + 1, prev, curr, nums);
        if (nums[idx] % prev == 0) {
            curr.add(nums[idx]);
            dfs(idx + 1, nums[idx], curr, nums);
            curr.removeLast();
        }
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
//        solve(0, new ArrayList<>(), nums);
        dfs(0, 1, new ArrayList<>(), nums);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 16, 8};
        List<Integer> ans = largestDivisibleSubset(nums);
        System.out.println("ans = " + ans);
    }
}