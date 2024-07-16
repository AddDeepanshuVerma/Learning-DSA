package _07_Sorting.Ques.Easy;

import java.util.HashMap;

class containsDuplicate_217_3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
//        for (Map.Entry<Integer, Integer> eS : map.entrySet()) {
//            if (eS.getValue() >= 2) {
//                return true;
//            }
//        }
        for (Integer value : map.values()) {
            if (value == 2) {
                return true;
            }
        }
        return false;
    }
}