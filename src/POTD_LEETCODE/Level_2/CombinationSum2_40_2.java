package POTD_LEETCODE.Level_2;

import java.util.*;

class CombinationSum2_40_2 {
    static List<List<Integer>> list;

    public static void main(String[] args) {
        CombinationSum2_40_2 obj = new CombinationSum2_40_2();

        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        for (List<Integer> list : obj.combinationSum2(arr, target))
            System.out.println(list);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int idx = 0;
        list = new ArrayList<>();
        solve(candidates, target, idx, new ArrayList<Integer>());
        return list;
    }

    private void solve(int[] arr, int target, int idx, ArrayList<Integer> temp) {
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            temp.add(arr[i]);
            solve(arr, target - arr[i], i + 1, temp);
            temp.removeLast();
        }
    }
}