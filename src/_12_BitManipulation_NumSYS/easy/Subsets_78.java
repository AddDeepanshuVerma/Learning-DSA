package _12_BitManipulation_NumSYS.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Subsets_78 {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println(Subsets_78.subsets(arr));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> input = new ArrayList<>();
        for (int num : nums) input.add(num);
        ArrayList<Integer> output = new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        DFS(output, input, res);
        return res;
    }

    private static void DFS(ArrayList<Integer> output, ArrayList<Integer> input, List<List<Integer>> res) {
        if (input.isEmpty()) {
            res.add(new ArrayList<>(output));
            return;
        }
        Integer remove = input.removeFirst();
        DFS(output, input, res);
        output.add(remove);
        DFS(output, input, res);
    }
}