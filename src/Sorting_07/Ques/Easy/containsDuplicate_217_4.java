package Sorting_07.Ques.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class containsDuplicate_217_4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for (int num : nums) {
            map.add(num);
        }
        return map.size() < nums.length;
    }

    public static boolean containsDuplicate2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if(map.containsKey(n)) return true;
            map.put(n, 1);
        }
        return false;
    }
}