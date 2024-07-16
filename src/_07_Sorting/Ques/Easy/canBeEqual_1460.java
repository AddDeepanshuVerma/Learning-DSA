package _07_Sorting.Ques.Easy;

import java.util.Arrays;
import java.util.HashMap;

class canBeEqual_1460 {
    public static void main(String[] args) {
        int[] target = {1, 2, 3, 4};
        int[] arr = {2, 4, 1, 4};
        System.out.println(canBeEqual3(target, arr));
    }

    private static boolean canBeEqual3(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : target) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) - 1);
                if (map.get(arr[i]) == 0) {
                    map.remove(arr[i]);
                }
            }else return false;
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

    public static boolean canBeEqual(int[] target, int[] arr) {
        int temp = 0;
        for (int i = 0; i < target.length; i++)
            temp = temp ^ arr[i] ^ target[i];
        return temp == 0;
    }
}