package _12_BitManipulation_NumSYS.medium;

import java.util.ArrayList;
import java.util.List;

class Subsets_78_3 {
    private List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(new Subsets_78_3().subsets(arr));
    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> input = new ArrayList<>();
        for (int num : nums)
            input.add(num);
        recursion(new ArrayList<>(), 0, input);
        return res;
    }

    private void recursion(ArrayList<Integer> op, int index, ArrayList<Integer> ip) {
        if (index == ip.size()) {
            res.add(new ArrayList<>(op));
            return;
        }
        recursion(op, index + 1, ip);
        op.add(ip.get(index));
        recursion(op, index + 1, ip);
        op.removeLast();
    }

/*

    private static void subsets(String str) {
        recursion("", str);
    }

    private static void recursion(String op, String ip) {
        if (ip.isEmpty()) {
            System.out.printf(op +" ");
            return;
        }
        recursion(op, ip.substring(1));
        recursion(op + ip.charAt(0), ip.substring(1));
    }

*/

}