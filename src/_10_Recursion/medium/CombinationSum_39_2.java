package _10_Recursion.medium;

import java.util.*;

class CombinationSum_39_2 {
    List<List<Integer>> list;

    public static void main(String[] args) {
        CombinationSum_39_2 obj = new CombinationSum_39_2();
        int[] arr = {2, 3, 5};
        System.out.println(obj.combinationSum(arr, 8));
    }

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        list = new ArrayList<>();
//        Arrays.sort(arr); No need to sort as we are applying back-tracking
        dfs(0, target, arr, new ArrayList<>());
        return list;
    }

    private void dfs(int index, int target, int[] arr, List<Integer> temp) {
        if (target < 0) return;
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            temp.add(arr[i]);
//             no need to create a new list each time as we are removing the last element as each step while applying back tracking
//            dfs(i, target - arr[i], arr, new ArrayList<>(temp));
            dfs(i, target - arr[i], arr, temp);
            temp.removeLast();
        }
    }
}