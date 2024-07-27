package _12_BitManipulation_NumSYS.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SubsetsWithDup_90 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        System.out.println(SubsetsWithDup_90.subsetsWithDup(arr));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<Integer> output = new ArrayList<>();
        Set<List<Integer>> res = new HashSet<>();
        DFS(nums, 0, output, res);
        return new ArrayList<>(res);
    }

    public static void DFS(int[] nums, int i, List<Integer> op, Set<List<Integer>> res) {
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