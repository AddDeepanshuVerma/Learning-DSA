package POTD_LEETCODE.level_3;

import java.util.HashMap;

class SubarraysWithKDistinct_992 {
    public static void main(String[] args) {
        SubarraysWithKDistinct_992 obj = new SubarraysWithKDistinct_992();
        int[] arr = {1, 2, 1, 2, 3};
        System.out.println("ANS = " + obj.subarraysWithKDistinct(arr, 2));
    }

    public int subarraysWithKDistinct(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, count = 0;
        for (int j = 0; j < arr.length; j++) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            while (map.size() > k) {
                if (map.get(arr[i]) == 1) {
                    map.remove(arr[i]);
                } else {
                    map.put(arr[i], map.get(arr[i]) - 1);
                }
                i++;
            }
            if (map.size() == k) {
                for (int m = i; m <= j; m++) {
                    System.out.print(arr[m] + " ");
                }
                count++;
                System.out.println();
            }
        }
        return count;
    }
}