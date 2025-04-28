package POTD_LEETCODE.Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupThePeople_1282 {
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            adj.computeIfAbsent(groupSizes[i], list -> new ArrayList<>()).add(i);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> item : adj.entrySet()) {
            List<List<Integer>> temp = getList(item.getKey(), item.getValue());
            ans.addAll(temp);
        }

        return ans;
    }

    private static List<List<Integer>> getList(int size, List<Integer> list) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        for (Integer val : list) {
            item.add(val);
            if (item.size() == size) {
                res.add(new ArrayList<>(item));
                item.clear();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> res = groupThePeople(arr);
        System.out.println("res = " + res);
    }
}