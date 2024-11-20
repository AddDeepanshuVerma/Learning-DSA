package POTD_LEETCODE.Level_1;

import java.util.Arrays;
import java.util.HashMap;

class CanBeEqual_1460 {
    public static void main(String[] args) {
        int[] target = {1, 2, 3, 4};
        int[] arr = {2, 4, 1, 3};
        System.out.println(canBeEqual3(target, arr));
    }

    private static boolean canBeEqual3(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : target) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (int key : arr) {
            if (map.containsKey(key)) {
                if (map.get(key) == 0) {
                    return false;
                } else {
                    map.put(key, map.get(key) - 1);
                }
            } else return false;
        }
        return true;
    }

    private static boolean canBeEqual2(int[] target, int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(target);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean canBeEqual1(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(arr, target);
    }

}