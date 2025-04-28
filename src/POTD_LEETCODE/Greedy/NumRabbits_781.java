package POTD_LEETCODE.Greedy;

import java.util.HashMap;

class NumRabbits_781 {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int val : answers) {
            map.merge(val + 1, 1, Integer::sum);
        }

        int count = 0;
        for (var item : map.entrySet()) {
            int key = item.getKey();
            int size = item.getValue();

            count += ((size + key - 1) / key) * key;
        }
        return count;
    }

    public static void main(String[] args) {
        var obj = new NumRabbits_781();
        int[] arr = {1, 1, 2};
        int count = obj.numRabbits(arr);
        System.out.println("count = " + count);
    }
}