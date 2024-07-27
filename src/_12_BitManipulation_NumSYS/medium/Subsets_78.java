package _12_BitManipulation_NumSYS.medium;

import java.util.ArrayList;
import java.util.List;

class Subsets_78 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(Subsets_78.subsets(arr));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> output = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        DFS(nums, 0, output, res);
        return res;
    }

    public static void DFS(int[] nums, int i, List<Integer> op, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(op));
            return;
        }
        DFS(nums, i + 1, op, res);
        op.add(nums[i]);
        DFS(nums, i + 1, op, res);
        op.removeLast();
    }
}