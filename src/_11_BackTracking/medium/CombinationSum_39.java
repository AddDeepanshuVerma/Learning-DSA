package _11_BackTracking.medium;

import java.util.*;

class CombinationSum_39 {
    Set<List<Integer>> set;

    public static void main(String[] args) {
        CombinationSum_39 obj = new CombinationSum_39();
        int[] arr = {2, 3, 5};
        System.out.println(obj.combinationSum(arr, 8));
    }

//    naive approach, do check its second sol : CombinationSum_39_2.java
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        set = new HashSet<>();
        int sum = 0;
        List<Integer> temp = new ArrayList<>();
        dfs(sum, target, arr, temp);
        return new ArrayList<>(set);
    }

    private void dfs(int sum, int target, int[] arr, List<Integer> temp) {
        if (sum > target) return;
        if (sum == target) {
            List<Integer> sorted = new ArrayList<>(temp);
            Collections.sort(sorted);
            set.add(sorted);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            temp.add(arr[i]);
            sum += arr[i];
            dfs(sum, target, arr, new ArrayList<>(temp));
            sum -= arr[i];
            temp.removeLast();
        }
    }
}