package DailyCodeChallenge.Level_2;

import java.util.*;

class CombinationSum2_40 {
    Set<List<Integer>> set = new HashSet<>();

    public static void main(String[] args) {
        CombinationSum2_40 obj = new CombinationSum2_40();

        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        for (List<Integer> list : obj.combinationSum2(arr, target))
            System.out.println(list);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int idx = 0;
        solve(candidates, target, idx, new ArrayList<Integer>());
        return new ArrayList<>(set);
    }

    private void solve(int[] arr, int target, int idx, ArrayList<Integer> temp) {
        if (target == 0) {
            set.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0 || idx >= arr.length) {
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            Integer val = arr[i];
            temp.add(val);
            solve(arr, target - val, i + 1, temp);
            temp.remove(val);
        }
    }
}