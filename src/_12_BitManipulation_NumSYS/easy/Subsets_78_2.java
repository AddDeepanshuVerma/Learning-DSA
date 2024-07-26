package _12_BitManipulation_NumSYS.easy;

import java.util.ArrayList;
import java.util.List;

class Subsets_78_2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(Subsets_78_2.subsets(arr));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> input = new ArrayList<>();
        for (int num : nums) input.add(num);
        ArrayList<Integer> output = new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        recursion(output, 0, input, res);
        return res;
    }

    private static void recursion(ArrayList<Integer> op, int index, ArrayList<Integer> ip, List<List<Integer>> res) {
        if (index == ip.size()) {
            res.add(new ArrayList<>(op));
            return;
        }
        recursion(op, index + 1, ip, res);
        op.add(ip.get(index));
        recursion(op, index + 1, ip, res);
        op.removeLast();
    }

   /* private static void subsets(String str) {
        recursion("", str);
    }

    private static void recursion(String op, String ip) {
        if (ip.isEmpty()) {
            System.out.printf(op +" ");
            return;
        }
        recursion(op, ip.substring(1));
        recursion(op + ip.charAt(0), ip.substring(1));
    }*/

}